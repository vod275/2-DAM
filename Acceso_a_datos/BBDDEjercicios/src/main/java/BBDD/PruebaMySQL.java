package BBDD;
import java.sql.*;


public class PruebaMySQL {

	public static void main(String[] args) {
		
		
		try {
			// Cargar el driver
			//Class.forName("com.mysql.jdbc.Driver"); para las deppendencias(que ya las tenemos asique 0)
			
			
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
			
			
			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT * FROM departamentos";
			ResultSet resul = sentencia.executeQuery(sql);
			
			
			resul.last(); //Nos situamos en el último registro
			System.out.println ("NÚMERO DE FILAS: " + resul.getRow());
			resul.beforeFirst(); //Nos situamos antes del primer registro
			
			// Recorremos el resultado para visualizar cada fila
			// Se hace un bucle mientras haya registros y se van mostrando
			while (resul.next()) {
				System.out.printf("Fila: %d, %s, %s %n",resul.getRow(), resul.getInt(1), resul.getString(2), resul.getString(3));
			}
			resul.close(); // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexión
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// fin de main
}// fin de la clase

