package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actividad_2_10Statemen {

    public static void main(String[] args) {

        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "")) {
            String resultado = insertarEmpleado(conexion, 101, "Pérez", "Analista", 7902, 3000.0, 500.0, 10);
            System.out.println(resultado);
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
    }

    public static String insertarEmpleado(Connection conexion, int empNo, String apellido, String oficio, Integer dir, double salario, Double comision, int deptNo) {
        try (Statement stmt = conexion.createStatement()) {

            if (existeEmpleado(conexion, empNo)) {
                return "El número de empleado ya existe, como tu suspenso en psp";
            }

            if (!existeDepartamento(conexion, deptNo)) {
                return "El departamento no existe como los reyes magos";
            }

            if (salario <= 0) {
                return "El salario es negativo, si es negativo ¿para qué trabajas?";
            }

            if (dir != null && !existeEmpleado(conexion, dir)) {
                return "El director (DIR) no existe en empleados, revisa el código";
            }

            if (apellido == null || apellido.isEmpty()) {
                return "El apellido no puede ser nulo";
            }
            if (oficio == null || oficio.isEmpty()) {
                return "El oficio no puede ser nulo";
            }


            String sql = String.format(
            		"INSERT INTO empleados (emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no) " +
    	                    "VALUES (?, ?, ?, ?, ?, ?, ?) CURDATE()",
                empNo,
                apellido,
                oficio,
                (dir != null ? dir : "NULL"),
                salario,
                (comision != null ? comision : "NULL"),
                deptNo
            );

            int filasAfectadas = stmt.executeUpdate(sql);
            if (filasAfectadas > 0) {
                return "Se insertó guay el empleado";
            } else {
                return "Error";
            }

        } catch (SQLException e) {
            return "Error en la operación: " + e.getMessage();
        }
    }

    private static boolean existeEmpleado(Connection conexion, int empNo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM empleados WHERE emp_no = " + empNo;
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            return rs.getInt(1) > 0;
        }
    }

    private static boolean existeDepartamento(Connection conexion, int deptNo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM departamentos WHERE dept_no = " + deptNo;
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            return rs.getInt(1) > 0;
        }
    }
}
