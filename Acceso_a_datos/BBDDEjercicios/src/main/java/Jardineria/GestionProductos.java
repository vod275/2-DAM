package Jardineria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionProductos {
	
	
	  public static void crearYActualizarStock() {
	        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##JARDINERIA", "Ora1234")) {

	            // 1. Verificar si la columna STOCKACTUALIZADO existe en la tabla PRODUCTOS, si no, agregarla
	            String verificarColumnaQuery = "SELECT COUNT(*) FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'PRODUCTOS' AND COLUMN_NAME = 'STOCKACTUALIZADO'";
	            try (PreparedStatement stmt = connection.prepareStatement(verificarColumnaQuery);
	                 ResultSet rs = stmt.executeQuery()) {
	                if (rs.next() && rs.getInt(1) == 0) {
	                    // La columna no existe, la creamos
	                    String agregarColumnaQuery = "ALTER TABLE PRODUCTOS ADD STOCKACTUALIZADO NUMERIC";
	                    try (PreparedStatement alterStmt = connection.prepareStatement(agregarColumnaQuery)) {
	                        alterStmt.executeUpdate();
	                        System.out.println("Columna STOCKACTUALIZADO añadida a la tabla PRODUCTOS.");
	                    }
	                } else {
	                    System.out.println("La columna STOCKACTUALIZADO ya existe en la tabla PRODUCTOS.");
	                }
	            }

	            // 2. Consultar los productos y su cantidad vendida
	            String consultaStockQuery = "SELECT P.CODIGOPRODUCTO, P.CANTIDADENSTOCK, NVL(SUM(V.CANTIDAD), 0) AS CANTIDADVENDIDA " +
	                    "FROM PRODUCTOS P LEFT JOIN VENTAS V ON P.CODIGOPRODUCTO = V.CODIGOPRODUCTO " +
	                    "GROUP BY P.CODIGOPRODUCTO, P.CANTIDADENSTOCK";

	            try (PreparedStatement pstmt = connection.prepareStatement(consultaStockQuery);
	                 ResultSet rs = pstmt.executeQuery()) {

	                // 3. Actualizar la columna STOCKACTUALIZADO en la tabla PRODUCTOS
	                String actualizarStockQuery = "UPDATE PRODUCTOS SET STOCKACTUALIZADO = CANTIDADENSTOCK - ? WHERE CODIGOPRODUCTO = ?";
	                try (PreparedStatement updateStmt = connection.prepareStatement(actualizarStockQuery)) {
	                    while (rs.next()) {
	                        int codigoProducto = rs.getInt("CODIGOPRODUCTO");
	                        int cantidadEnStock = rs.getInt("CANTIDADENSTOCK");
	                        int cantidadVendida = rs.getInt("CANTIDADVENDIDA");

	                        // Calcular el stock actualizado
	                        int stockActualizado = cantidadEnStock - cantidadVendida;

	                        // Actualizar el stock en la tabla
	                        updateStmt.setInt(1, cantidadVendida);
	                        updateStmt.setInt(2, codigoProducto);
	                        int filasAfectadas = updateStmt.executeUpdate();

	                        // Mostrar actualización en consola
	                        System.out.printf("Producto código: %-5d | Stock Original: %-3d | Cantidad Vendida: %-3d | Stock Actualizado: %-3d\n", 
	                                          codigoProducto, cantidadEnStock, cantidadVendida, stockActualizado);
	                    }
	                }
	            }

	            // 4. Obtener y mostrar los productos que necesitan reposición (stock actualizado menor a 5)
	            String consultaReponerQuery = "SELECT CODIGOPRODUCTO, STOCKACTUALIZADO FROM PRODUCTOS WHERE STOCKACTUALIZADO < 5";

	            try (PreparedStatement pstmtReponer = connection.prepareStatement(consultaReponerQuery);
	                 ResultSet rsReponer = pstmtReponer.executeQuery()) {

	                System.out.println("\nProductos que necesitan reposición (stock actualizado menor que 5):");
	                while (rsReponer.next()) {
	                    int codigoProducto = rsReponer.getInt("CODIGOPRODUCTO");
	                    int stockActualizado = rsReponer.getInt("STOCKACTUALIZADO");
	                    System.out.printf("Producto código: %-5d | Stock Actualizado: %-3d\n", codigoProducto, stockActualizado);
	                }
	            }

	        } catch (SQLException e) {
	            System.err.println("Error al procesar la actualización de stock: " + e.getMessage());
	        }
	    }

}
