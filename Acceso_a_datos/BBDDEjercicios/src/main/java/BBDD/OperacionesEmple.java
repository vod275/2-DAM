package BBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperacionesEmple {

	
	
	
	  public static boolean comprobaremple(Connection conexion, int empNo) throws SQLException {
	        String sql = "SELECT COUNT(*) FROM empleados WHERE emp_no = ?";
	        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	            stmt.setInt(1, empNo);
	            ResultSet rs = stmt.executeQuery();
	            rs.next();
	            return rs.getInt(1) > 0;
	        }
	    }
	 
	 public static String borraremple(Connection conexion, int empno) {
	        try {
	            if (!comprobaremple(conexion, empno)) {
	                return "El empleado no existe.";
	            }
	            String sql = "DELETE FROM empleados WHERE emp_no = ?";
	            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	                stmt.setInt(1, empno);
	                int rowsAffected = stmt.executeUpdate();
	                return rowsAffected > 0 ? "Empleado borrado exitosamente" : "Error al borrar el empleado";
	            }
	        } catch (SQLException e) {
	            return "Error: " + e.getMessage();
	        }
	    }
	 
	 
	 public static String modificaremple(Connection conexion, int empno, String ape, String ofi, float sal, float comi, int dep, int dir) {
	        try {
	            if (!comprobaremple(conexion, empno)) {
	                return "El empleado no existe.";
	            }
	            String sql = "UPDATE empleados SET apellido = ?, oficio = ?, salario = ?, comision = ?, dept_no = ?, dir = ? WHERE emp_no = ?";
	            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	                stmt.setString(1, ape);
	                stmt.setString(2, ofi);
	                stmt.setFloat(3, sal);
	                stmt.setFloat(4, comi);
	                stmt.setInt(5, dep);
	                stmt.setInt(6, dir);
	                stmt.setInt(7, empno);
	                int filasAfectadas = stmt.executeUpdate();
	                return filasAfectadas > 0 ? "Empleado modificado exitosamente" : "Error al modificar el empleado";
	            }
	        } catch (SQLException e) {
	            return "Error: " + e.getMessage();
	        }
	    }
	 
	 public static String insertaremple(Connection conexion, int empno, String ape, String ofi, float sal, float comi, int dep, int dir) {
	        try {
	            if (comprobaremple(conexion, empno)) {
	                return "El empleado ya existe.";
	            }
	            String sql = "INSERT INTO empleados (emp_no, apellido, oficio, salario, comision, dept_no, dir, fecha_alt) VALUES (?, ?, ?, ?, ?, ?, ?, CURDATE())";
	            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	                stmt.setInt(1, empno);
	                stmt.setString(2, ape);
	                stmt.setString(3, ofi);
	                stmt.setFloat(4, sal);
	                stmt.setFloat(5, comi);
	                stmt.setInt(6, dep);
	                stmt.setInt(7, dir);
	                int filasAfectadas = stmt.executeUpdate();
	                return filasAfectadas > 0 ? "Empleado insertado exitosamente" : "Error al insertar el empleado";
	            }
	        } catch (SQLException e) {
	            return "Error: " + e.getMessage();
	        }
	    }
	 
	
	    public static void verempleados(Connection conexion) {
	        String sql = "SELECT emp_no, apellido, oficio, salario, comision, fecha_alt, dept_no, dir FROM empleados";
	        try (PreparedStatement stmt = conexion.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {
	            System.out.printf("%-10s %-20s %-15s %-10s %-10s %-15s %-10s %-10s%n", "EMP_NO", "APELLIDO", "OFICIO", "SALARIO", "COMISION", "FECHA_ALT", "DEPT_NO", "DIR");
	            while (rs.next()) {
	                System.out.printf("%-10d %-20s %-15s %-10.2f %-10.2f %-15s %-10d %-10d%n",
	                        rs.getInt("emp_no"),
	                        rs.getString("apellido"),
	                        rs.getString("oficio"),
	                        rs.getFloat("salario"),
	                        rs.getFloat("comision"),
	                        rs.getDate("fecha_alt"),
	                        rs.getInt("dept_no"),
	                        rs.getInt("dir"));
	            }
	        } catch (SQLException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	    
	    
	    public static void verunempleado(Connection conexion, int empno) {
	        try {
	            if (!comprobaremple(conexion, empno)) {
	                System.out.println("El empleado no existe.");
	                return;
	            }
	            String sql = "SELECT emp_no, apellido, oficio, salario, comision, fecha_alt, dept_no, dir FROM empleados WHERE emp_no = ?";
	            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	                stmt.setInt(1, empno);
	                ResultSet rs = stmt.executeQuery();
	                if (rs.next()) {
	                    System.out.printf("%-10s %-20s %-15s %-10s %-10s %-15s %-10s %-10s%n", "EMP_NO", "APELLIDO", "OFICIO", "SALARIO", "COMISION", "FECHA_ALT", "DEPT_NO", "DIR");
	                    System.out.printf("%-10d %-20s %-15s %-10.2f %-10.2f %-15s %-10d %-10d%n",
	                            rs.getInt("emp_no"),
	                            rs.getString("apellido"),
	                            rs.getString("oficio"),
	                            rs.getFloat("salario"),
	                            rs.getFloat("comision"),
	                            rs.getDate("fecha_alt"),
	                            rs.getInt("dept_no"),
	                            rs.getInt("dir"));
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

}
