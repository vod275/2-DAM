package Jardineria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionEmpleados {

    public static void insertarEmpleado(String nombre, String apellido1, String apellido2, String extension,
                                        String email, String codigoOficina, Integer codigoJefe, String puesto) {
    	
    	
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##VICTOR","Ora1234")){
            // Comprobar si el código de oficina existe
            if (!existeCodigoOficina(connection, codigoOficina)) {
                System.err.println("Error: El código de oficina " + codigoOficina + " no existe.");
                return;
            }

            // Comprobar si el código de jefe existe (si se proporciona)
            if (codigoJefe != null && !existeCodigoJefe(connection, codigoJefe)) {
                System.err.println("Error: El código de jefe " + codigoJefe + " no existe.");
                return;
            }

            // Obtener el código de empleado más alto
            String maxEmployeeQuery = "SELECT MAX(codigoempleado) FROM empleados";
            try (PreparedStatement ps = connection.prepareStatement(maxEmployeeQuery);
                 ResultSet rs = ps.executeQuery()) {
                int nuevoCodigoEmpleado = 1;
                if (rs.next()) {
                    nuevoCodigoEmpleado = rs.getInt(1) + 1;
                }

                // Insertar empleado
                String insertQuery = "INSERT INTO empleados (codigoempleado, nombre, apellido1, apellido2, extension, email, codigooficina, codigojefe, puesto) " +
                                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement insertPs = connection.prepareStatement(insertQuery)) {

                    insertPs.setString(2, nombre);
                    insertPs.setString(3, apellido1);
                    insertPs.setString(4, apellido2);
                    insertPs.setString(5, extension);
                    insertPs.setString(6, email);
                    insertPs.setString(7, codigoOficina);
                    insertPs.setInt(8, codigoJefe); 
                    insertPs.setString(9, puesto);

                    int rowsAffected = insertPs.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Empleado insertado correctamente con código: " + nuevoCodigoEmpleado);
                    } else {
                        System.err.println("Error: No se pudo insertar el empleado.");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar empleado: " + e.getMessage());
        }
    }

    private static boolean existeCodigoOficina(Connection connection, String codigoOficina) throws SQLException {
        String query = "SELECT COUNT(*) FROM oficinas WHERE codigooficina = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, codigoOficina);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    private static boolean existeCodigoJefe(Connection connection, int codigoJefe) throws SQLException {
        String query = "SELECT COUNT(*) FROM empleados WHERE codigoempleado = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, codigoJefe);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    
    
    public static void actualizarClientesPorEmpleado() {
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##VICTOR", "Ora1234")) {

            // 1. Verificar si la columna NUMCLIENTES existe en la tabla EMPLEADOS, si no, agregarla
            String verificarColumnaQuery = "SELECT COUNT(*) FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'EMPLEADOS' AND COLUMN_NAME = 'NUMCLIENTES'";
            try (PreparedStatement stmt = connection.prepareStatement(verificarColumnaQuery);
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) == 0) {
                    // La columna no existe, la creamos
                    String agregarColumnaQuery = "ALTER TABLE EMPLEADOS ADD NUMCLIENTES NUMERIC";
                    try (PreparedStatement alterStmt = connection.prepareStatement(agregarColumnaQuery)) {
                        alterStmt.executeUpdate();
                        System.out.println("Columna NUMCLIENTES añadida a la tabla EMPLEADOS.");
                    }
                } else {
                    System.out.println("La columna NUMCLIENTES ya existe en la tabla EMPLEADOS.");
                }
            }

            // 2. Consultar el número de clientes asignados a cada empleado
            String consultaClientesPorEmpleado = "SELECT EMPLEADO_ID, COUNT(CODIGOCLIENTE) AS NUM_CLIENTES " +
                    "FROM CLIENTES " +
                    "GROUP BY EMPLEADO_ID";

            try (PreparedStatement pstmt = connection.prepareStatement(consultaClientesPorEmpleado);
                 ResultSet rs = pstmt.executeQuery()) {

                // 3. Actualizar la columna NUMCLIENTES en la tabla EMPLEADOS
                String actualizarClientesQuery = "UPDATE EMPLEADOS SET NUMCLIENTES = ? WHERE EMPLEADO_ID = ?";
                try (PreparedStatement updateStmt = connection.prepareStatement(actualizarClientesQuery)) {
                    while (rs.next()) {
                        int empleadoId = rs.getInt("EMPLEADO_ID");
                        int numClientes = rs.getInt("NUM_CLIENTES");

                        updateStmt.setInt(1, numClientes);
                        updateStmt.setInt(2, empleadoId);

                        // Ejecutar la actualización en la tabla EMPLEADOS
                        int filasAfectadas = updateStmt.executeUpdate();
                        System.out.printf("Empleado ID: %-5d Número de Clientes Actualizado: %-3d\n", empleadoId, numClientes);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al procesar la actualización de clientes por empleado: " + e.getMessage());
        }
    }
}
