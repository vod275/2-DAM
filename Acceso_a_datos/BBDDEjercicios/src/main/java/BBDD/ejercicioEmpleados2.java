package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ejercicioEmpleados2 {

	public static void main(String[] args) throws SQLException {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
		
		Statement sentencia = conexion.createStatement();
		String sql = "SELECT e.apellido, e.salario, d.dnombre FROM empleados"
				+ "JOIN departamentos"
				+ "d ON e.dept_no = d.dept_no"
				+ "WHERE e.salario = (SELECT MAX(salario) FROM empleados);";
		ResultSet resul = sentencia.executeQuery(sql);
		
		resul.last(); 
		System.out.println("NÚMERO DE FILAS: " + resul.getRow());
		resul.beforeFirst(); 

		
		while (resul.next()) {
			System.out.printf("Fila %d %s, %s, %.2f %n", resul.getRow(), resul.getString(1), resul.getInt(2), resul.getString(3));
		}
		resul.close(); // Cerrar ResultSet
		sentencia.close(); // Cerrar Statement
		conexion.close(); // Cerrar conexión

	}

}
