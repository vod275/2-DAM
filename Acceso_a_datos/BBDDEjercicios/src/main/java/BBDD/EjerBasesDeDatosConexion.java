package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjerBasesDeDatosConexion {

    public static void main(String[] args) throws SQLException {

        System.out.println("----------------sqlite-----------------");
        sqlite();
        
        System.out.println("----------------derby-----------------");
        derby();
        
        System.out.println("----------------hsqldb-----------------");
        hsqldb();
        
        System.out.println("----------------h2-----------------");
        h2();
        
        System.out.println("----------------MySQL-----------------");
        mySQL();
        
        System.out.println("----------------ascces-----------------");
        ascces();
        
        System.out.println("----------------oracle-----------------");
        oracle();
    }

    public static void sqlite() throws SQLException {


        Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso_a_datos\\BBDDEjercicios\\Basesdatos\\sqlite\\ejemplo.db");
        Statement sentencia = conexion.createStatement();
        

        String sql = "SELECT * FROM departamentos";
        ResultSet resul = sentencia.executeQuery(sql);
        

        lislistardepartamentos(resul);
        
        // Cerrar ResultSet y Statement
        resul.close();
        sentencia.close();
        conexion.close();
    }
    
    
    public static void derby() throws SQLException {


        Connection conexion = DriverManager.getConnection("jdbc:derby:C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso_a_datos\\BBDDEjercicios\\Basesdatos\\derby\\ejemplo");
        Statement sentencia = conexion.createStatement();
        

        String sql = "SELECT * FROM departamentos";
        ResultSet resul = sentencia.executeQuery(sql);
        

        lislistardepartamentos(resul);
        
        // Cerrar ResultSet y Statement
        resul.close();
        sentencia.close();
        conexion.close();
    }
    
    public static void hsqldb() throws SQLException {


        Connection conexion = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso_a_datos\\BBDDEjercicios\\Basesdatos\\hsqldb\\ejemplo\\ejemplo");
        Statement sentencia = conexion.createStatement();
        

        String sql = "SELECT * FROM departamentos";
        ResultSet resul = sentencia.executeQuery(sql);
        

        lislistardepartamentos(resul);
        
        // Cerrar ResultSet y Statement
        resul.close();
        sentencia.close();
        conexion.close();
    }
    
    public static void h2() throws SQLException {


        Connection conexion = DriverManager.getConnection("jdbc:h2:file:C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso_a_datos\\BBDDEjercicios\\Basesdatos\\h2\\ejemplo", "sa","");
        Statement sentencia = conexion.createStatement();
        

        String sql = "SELECT * FROM departamentos";
        ResultSet resul = sentencia.executeQuery(sql);
        

        lislistardepartamentos(resul);
        
        // Cerrar ResultSet y Statement
        resul.close();
        sentencia.close();
        conexion.close();
    }
    
    public static void mySQL() throws SQLException {


        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
        Statement sentencia = conexion.createStatement();
        

        String sql = "SELECT * FROM departamentos";
        ResultSet resul = sentencia.executeQuery(sql);
        

        lislistardepartamentos(resul);
        
        // Cerrar ResultSet y Statement
        resul.close();
        sentencia.close();
        conexion.close();
    }
    
    public static void oracle() throws SQLException {


        Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##VICTOR","Ora1234");
        Statement sentencia = conexion.createStatement();
        

        String sql = "SELECT * FROM departamentos";
        ResultSet resul = sentencia.executeQuery(sql);
        

        lislistardepartamentos(resul);
        
        // Cerrar ResultSet y Statement
        resul.close();
        sentencia.close();
        conexion.close();
    }
    
    public static void ascces() throws SQLException {


        Connection conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso_a_datos\\BBDDEjercicios\\Basesdatos\\ejemplo.accdb");
        Statement sentencia = conexion.createStatement();
        

        String sql = "SELECT * FROM departamentos";
        ResultSet resul = sentencia.executeQuery(sql);
        

        lislistardepartamentos(resul);
        
        // Cerrar ResultSet y Statement
        resul.close();
        sentencia.close();
        conexion.close();
    }


    // Método para listar los departamentos
    public static void lislistardepartamentos(ResultSet resul) throws SQLException {
        int rowCount = 0; 


        while (resul.next()) {
            rowCount++;

            System.out.printf("Fila %d: Dept_no: %d, Nombre: %s, Localización: %s%n", 
                rowCount, resul.getInt("dept_no"), resul.getString("dnombre"), resul.getString("loc"));
        }
     
    }
}
