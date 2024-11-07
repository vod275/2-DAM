 package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class ManipulacionDeDatos {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
		
			 //CONEXION A MYSQL
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","root","");
			
			 //los ponemos en minuscula
			 //String sql="UPDATE departamentos SET dnombre = LOWER(dnombre)";
			 String sql="SELECT * FROM departamentos";
			 Statement sentencia =  conexion.createStatement();
			 boolean valor = sentencia.execute(sql);

			 if(valor){
			 ResultSet rs = sentencia.getResultSet();
			 while (rs.next())
			 System.out.printf("%d, %s, %s %n", rs.getInt(1), rs.getString(2), rs.getString(3)); 
			 rs.close();
			 } else {
			 int f = sentencia.getUpdateCount();
			 System.out.printf("Filas afectadas:%d %n", f);
			 }
			 sentencia.close();
			 conexion.close();
		
		
	}
	
	
	

}
