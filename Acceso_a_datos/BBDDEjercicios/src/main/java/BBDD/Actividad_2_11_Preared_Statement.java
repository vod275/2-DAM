package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Actividad_2_11_Preared_Statement {
	
	 

	public static void main(String[] args) {
		
		 int deptNo = 10; 
	     mostrarInformacionDepartamento(deptNo);
		
		
	}
	
	
	 public static void mostrarInformacionDepartamento(int deptNo) {
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root", "")) {

	            
	            String nombreDepartamento = obtenerNombreDepartamento(connection, deptNo);
	            if (nombreDepartamento == null) {
	                System.out.println("El departamento con n�mero " + deptNo + " no existe.");
	                return;
	            }
	            System.out.println("EMPLEADOS DEL DEPARTAMENTO: " + nombreDepartamento);

	           
	            visualizarEmpleados(connection, deptNo);

	       
	            salarioMedioYNumeroDeEmpleados(connection, deptNo);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	 
	 
	 
	 
    public static String obtenerNombreDepartamento(Connection connection, int deptNo) throws SQLException {
        String sqlDepartamento = "SELECT dnombre FROM departamentos WHERE dept_no = ?";
        try (PreparedStatement stmtDept = connection.prepareStatement(sqlDepartamento)) {
        	stmtDept.setInt(1, deptNo);
            ResultSet rsDeptName = stmtDept.executeQuery();

            if (rsDeptName.next()) {
                return rsDeptName.getString("dnombre");
            } else {
                return null; 
            }
        }
    }

		
	
	public static void visualizarEmpleados(Connection conexion, int deptNo) throws SQLException {
		
			
		DecimalFormat df = new DecimalFormat("#,###.00");
		String sqlEmpleados = "SELECT apellido, salario, oficio FROM empleados WHERE dept_no = ?";
        try (PreparedStatement stmtEmpl = conexion.prepareStatement(sqlEmpleados)) {
        	stmtEmpl.setInt(1, deptNo);
            ResultSet rsEmployees = stmtEmpl.executeQuery();

            System.out.printf("%-20s %-10s %-15s%n", "APELLIDO", "SALARIO", "OFICIO");
            System.out.println("---------------------------------------------");

            while (rsEmployees.next()) {
                String apellido = rsEmployees.getString("apellido");
                double salario = rsEmployees.getDouble("salario");
                String oficio = rsEmployees.getString("oficio");

                System.out.printf("%-20s %-10s %-15s%n", apellido, df.format(salario), oficio);
            }
        }
			
	}
	
	
	public static void salarioMedioYNumeroDeEmpleados(Connection conexion, int deptNo) throws SQLException {
		
		 String sqlSalario_Numero = "SELECT AVG(salario) AS salario_medio, COUNT(emp_no) AS num_empleados FROM empleados WHERE dept_no = ?";
		 DecimalFormat df = new DecimalFormat("#,###.00");
		
	        try (PreparedStatement stmtDatos = conexion.prepareStatement(sqlSalario_Numero)) {
	        	stmtDatos.setInt(1, deptNo);
	            ResultSet rsStats = stmtDatos.executeQuery();

	            if (rsStats.next()) {
	                double salarioMedio = rsStats.getDouble("salario_medio");
	                int numEmpleados = rsStats.getInt("num_empleados");

	                System.out.println("---------------------------------------------");
	                System.out.println("SALARIO MEDIO: " + df.format(salarioMedio));
	                System.out.println("NUM EMPLEADOS: " + numEmpleados);
	            }
	        }
	}

}
