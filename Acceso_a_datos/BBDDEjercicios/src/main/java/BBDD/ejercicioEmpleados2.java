package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ejercicioEmpleados2 {

    public static void main(String[] args) throws SQLException {
        // Conectar a la base de datos
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
        
        // Crear una sentencia SQL
        Statement sentencia = conexion.createStatement();
        
        // Consulta SQL corregida con espacios y alias para la tabla empleados
        String sql = "SELECT e.apellido, e.salario, d.dnombre "
                   + "FROM empleados e "
                   + "JOIN departamentos d ON e.dept_no = d.dept_no "
                   + "WHERE e.salario = (SELECT MAX(salario) FROM empleados);";
        
        // Ejecutar la consulta y obtener el resultado
        ResultSet resul = sentencia.executeQuery(sql);
        
        // Obtener el número de filas
        resul.last();
        System.out.println("NÚMERO DE FILAS: " + resul.getRow());
        resul.beforeFirst();
        
        // Imprimir los resultados
        while (resul.next()) {
            // Cambié resul.getInt(2) por resul.getFloat(2) o resul.getDouble(2) para que sea numérico
            System.out.printf("Fila %d %s, %.2f, %s %n", resul.getRow(), resul.getString(1), resul.getFloat(2), resul.getString(3));
        }
        
        // Cerrar el ResultSet, Statement y la conexión
        resul.close();
        sentencia.close();
        conexion.close();
    }
}
