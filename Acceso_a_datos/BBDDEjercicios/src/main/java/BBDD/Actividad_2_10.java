package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class Actividad_2_10 {

	 public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost/ejemplo";
	        String usuario = "root";
	        String clave = "";

	        try (Connection conexion = DriverManager.getConnection(url, usuario, clave)) {
	            String resultado = insertarEmpleado(conexion, 101, "Pérez", "Analista", 100, 3000.0, 500.0, 10);
	            System.out.println(resultado);
	        } catch (SQLException e) {
	            System.out.println("Error de conexión: " + e.getMessage());
	        }
	    }

	
	
	
	
	 public static String insertarEmpleado(Connection conexion, int empNo, String apellido, String oficio, Integer dir, double salario, Double comision, int deptNo) {
	        try {
	            // Comprobar que el número del empleado no existe
	            if (existeEmpleado(conexion, empNo)) {
	                return "El número de empleado ya existe, error al insertar.";
	            }

	            // Comprobar que el departamento existe
	            if (!existeDepartamento(conexion, deptNo)) {
	                return "El número de departamento no existe en la tabla departamentos.";
	            }

	            // Comprobar que el salario es mayor que 0
	            if (salario <= 0) {
	                return "El salario es negativo, error: no puede ser negativo.";
	            }

	            // Comprobar que el director (DIR) existe en empleados, si dir no es nulo
	            if (dir != null && !existeEmpleado(conexion, dir)) {
	                return "El director (DIR) no existe en empleados, error al insertar.";
	            }

	            // Comprobar que apellido y oficio no sean nulos
	            if (apellido == null || apellido.isEmpty()) {
	                return "El apellido no puede ser nulo.";
	            }
	            if (oficio == null || oficio.isEmpty()) {
	                return "El oficio no puede ser nulo.";
	            }

	            // Preparar y ejecutar la inserción
	            String sql = "INSERT INTO empleados (emp_no, apellido, oficio, dir, salario, comision, dept_no, fecha_alta) " +
	                         "VALUES (?, ?, ?, ?, ?, ?, ?, CURDATE())";
	            PreparedStatement stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, empNo);
	            stmt.setString(2, apellido);
	            stmt.setString(3, oficio);
	            if (dir != null) {
	                stmt.setInt(4, dir);
	            } else {
	                stmt.setNull(4, Types.INTEGER);
	            }
	            stmt.setDouble(5, salario);
	            if (comision != null) {
	                stmt.setDouble(6, comision);
	            } else {
	                stmt.setNull(6, Types.DOUBLE);
	            }
	            stmt.setInt(7, deptNo);

	            int filasAfectadas = stmt.executeUpdate();
	            if (filasAfectadas > 0) {
	                return "Se ha insertado correctamente el empleado.";
	            } else {
	                return "Error desconocido al intentar insertar el empleado.";
	            }

	        } catch (SQLException e) {
	            return "Error en la operación: " + e.getMessage();
	        }
	    }
	 
	 
	 
	 private static boolean existeEmpleado(Connection conexion, int empNo) throws SQLException {
	        String sql = "SELECT COUNT(*) FROM empleados WHERE emp_no = ?";
	        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	            stmt.setInt(1, empNo);
	            ResultSet rs = stmt.executeQuery();
	            rs.next();
	            return rs.getInt(1) > 0;
	        }
	    }
	 
	 
	 private static boolean existeDepartamento(Connection conexion, int deptNo) throws SQLException {
	        String sql = "SELECT COUNT(*) FROM departamentos WHERE dept_no = ?";
	        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	            stmt.setInt(1, deptNo);
	            ResultSet rs = stmt.executeQuery();
	            rs.next();
	            return rs.getInt(1) > 0;
	        }
	    }
}
