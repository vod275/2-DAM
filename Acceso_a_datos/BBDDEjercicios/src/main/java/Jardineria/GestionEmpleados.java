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
}
