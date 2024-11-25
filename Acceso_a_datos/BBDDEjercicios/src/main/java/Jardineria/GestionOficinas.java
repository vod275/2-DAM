package Jardineria;

import java.sql.*;

public class GestionOficinas {

	public static void verOficina(String codigoOficina) {
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##VICTOR", "Ora1234")) {
            
            

            // Llamar a la función veroficina
            CallableStatement stmt = connection.prepareCall("{? = call veroficina(?, ?, ?, ?, ?)}");

            // Establecer los parámetros de entrada y salida
            stmt.registerOutParameter(1, Types.INTEGER); // Número de empleados
            stmt.setString(2, codigoOficina); // Código de la oficina
            stmt.registerOutParameter(3, Types.VARCHAR); // Ciudad
            stmt.registerOutParameter(4, Types.VARCHAR); // País
            stmt.registerOutParameter(5, Types.VARCHAR); // Región
            stmt.registerOutParameter(6, Types.VARCHAR); // Dirección

            // Ejecutar la función almacenada
            stmt.execute();

            // Recuperar los valores devueltos
            int numEmpleados = stmt.getInt(1);
            String ciudad = stmt.getString(3);
            String pais = stmt.getString(4);
            String region = stmt.getString(5);
            String direccion = stmt.getString(6);

            // Mostrar la salida formateada
            System.out.printf("%-12s %-20s %-20s %-20s %-20s %-10s\n", "COD OFICINA", "CIUDAD", "PAIS", "REGION", "DIRECCION1", "NUM EMPLES");
            System.out.printf("%-12s %-20s %-20s %-20s %-20s %-10d\n", codigoOficina, ciudad, pais, region, direccion, numEmpleados);
            
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la función veroficina: " + e.getMessage());
        }
    }

}
