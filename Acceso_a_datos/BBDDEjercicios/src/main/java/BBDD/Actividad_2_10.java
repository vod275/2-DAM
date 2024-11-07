package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class Actividad_2_10 {

	 public static void main(String[] args) {
	      
	        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","root", "")) {
	            String resultado = insertarEmpleado(conexion, 555, "Oliver", "Crack", 7788, 3000.0, 500.0, 10);
	            System.out.println(resultado);
	        } catch (SQLException e) {
	            System.out.println("Error de al conectarse bb: " + e.getMessage());
	        }
	    }

	
	
	
	
	 public static String insertarEmpleado(Connection conexion, int empNo, String apellido, String oficio, Integer dir, double salario, Double comision, int deptNo) {
	        try {
	            
	            if (existeEmpleado(conexion, empNo)) {
	                return "El numero de empleado ya existe, como tu suspenso en psp.";
	            }

	           
	            if (!existeDepartamento(conexion, deptNo)) {
	                return "El departamento  no existe como los reyes magos.";
	            }

	       
	            if (salario <= 0) {
	                return "El salario es negativo, si es negativo para que trabajas?.";
	            }


	            if (dir != null && !existeEmpleado(conexion, dir)) {
	                return "El director (dir) no existe en empleados, revisa el codigo coño.";
	            }


	            if (apellido == null || apellido.isEmpty()) {
	                return "El apellido no puede ser nulo.";
	            }
	            if (oficio == null || oficio.isEmpty()) {
	                return "El oficio no puede ser nulo.";
	            }

	
	            String sql = "INSERT INTO empleados (emp_no, apellido, oficio, dir, salario, comision, dept_no, fecha_alt) " +
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
	                return "Se inserto bien, en 500 años estas en la nasa.";
	            } else {
	                return "eres tan tonto que lo insertaste mal.";
	            }

	        } catch (SQLException e) {
	            return "Error en la operaci�n: " + e.getMessage();
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
