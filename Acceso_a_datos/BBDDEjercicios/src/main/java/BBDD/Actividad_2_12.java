package BBDD;

import java.sql.*;

public class Actividad_2_12 {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:free", "C##VICTOR", "Ora1234")) {

            // Preparar llamada al procedimiento
            String sql = "{? = call obtenersalario(?, ?)}"; // Cambia el nombre si es necesario
            CallableStatement llamada = connection.prepareCall(sql);

            // Consulta para obtener los departamentos
            String sql2 = "SELECT DEPT_NO, DNOMBRE, LOC FROM C##VICTOR.DEPARTAMENTOS";
            PreparedStatement stmt = connection.prepareStatement(sql2);
            ResultSet rs = stmt.executeQuery();

            System.out.println("DEPARTAMENTO | NOMBRE          | Nº EMPLEADOS          | LOCALIDAD      | SALARIO MEDIO");
            System.out.println("---------------------------------------------------------------------------------------"
            		+ " ");

            while (rs.next()) {
                // Obtener datos del departamento
                int deptNo = rs.getInt("DEPT_NO");
                String nombre = rs.getString("DNOMBRE");
                String loc = rs.getString("LOC");

                // Configurar los parámetros de la función
                llamada.registerOutParameter(1, Types.FLOAT); 
                llamada.setInt(2, deptNo);                    
                llamada.registerOutParameter(3, Types.INTEGER); 

                // Ejecutar función
                llamada.execute();

                // Obtener resultados
                float salarioMedio = llamada.getFloat(1);
                int numEmpleados = llamada.getInt(3);

                // Mostrar datos formateados
                System.out.printf("%-13d | %-15s | %-15s | %-15s | %-10.2f\n",
                        deptNo, nombre, numEmpleados, loc, salarioMedio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
