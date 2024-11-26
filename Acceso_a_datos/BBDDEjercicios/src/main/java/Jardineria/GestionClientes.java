package Jardineria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionClientes {

	public static void visualizarPedidosCliente(String codigoCliente) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##JARDINERIA", "Ora1234")) {

			// Verificar si el cliente existe
			String clienteQuery = "SELECT NOMBRECLIENTE, LINEADIRECCION1 FROM CLIENTES WHERE CODIGOCLIENTE = ?";
			PreparedStatement clientePs = connection.prepareStatement(clienteQuery);
			clientePs.setString(1, codigoCliente);
			ResultSet clienteRs = clientePs.executeQuery();

			if (!clienteRs.next()) {
				System.out.println("El cliente con código " + codigoCliente + " no existe en la base de datos.");
				return;
			}

			String nombreCliente = clienteRs.getString("nombrecliente");
			String direccion1 = clienteRs.getString("lineadireccion1");

			// Consultar los pedidos del cliente
			String pedidosQuery = "SELECT p.CODIGOPEDIDO, p.FECHAPEDIDO, p.ESTADO, dp.NUMEROLINEA, dp.CODIGOPRODUCTO, pr.NOMBRE AS NOMBREPRODUCTO, dp.CANTIDAD, dp.PRECIOUNIDAD, (dp.CANTIDAD * dp.PRECIOUNIDAD) AS IMPORTE " +
					"FROM PEDIDOS p " +
					"JOIN DETALLEPEDIDOS dp ON p.CODIGOPEDIDO = dp.CODIGOPEDIDO " +
					"JOIN PRODUCTOS pr ON dp.CODIGOPRODUCTO = pr.CODIGOPRODUCTO " +
					"WHERE p.CODIGOCLIENTE = ? " +
					"ORDER BY p.CODIGOPEDIDO, dp.NUMEROLINEA";

			PreparedStatement pedidosPs = connection.prepareStatement(pedidosQuery);
			pedidosPs.setString(1, codigoCliente);
			ResultSet pedidosRs = pedidosPs.executeQuery();

			if (!pedidosRs.isBeforeFirst()) { // Verifica si no hay resultados
				System.out.println("El cliente con código " + codigoCliente + " no tiene pedidos registrados.");
				return;
			}

			// Mostrar información del cliente
			System.out.printf("COD-CLIENTE: %-15s NOMBRE: %-25s\n", codigoCliente, nombreCliente);
			System.out.printf("DIRECCIÓN1: %-25s Número de pedidos: %d\n", direccion1, getPedidosCount(connection, codigoCliente));
			System.out.println("------------------------------------------------------------------------------------------------------");

			// Variables para los totales generales y máximos
			double maxImporteTotal = 0;
			String maxPedido = "";
			String maxFechaPedido = "";
			int maxCantidad = 0;
			String maxProductoCodigo = "";
			String maxProductoNombre = "";

			// Variables para los totales por pedido
			String ultimoPedido = "";
			double totalCantidadPedido = 0;
			double totalPrecioUnidadPedido = 0;
			double totalImportePedido = 0;

			while (pedidosRs.next()) {
				String codigoPedido = pedidosRs.getString("codigopedido");

				// Si es un nuevo pedido, imprimir totales del anterior
				if (!codigoPedido.equals(ultimoPedido)) {
					if (!ultimoPedido.isEmpty()) {
						// Mostrar totales del pedido anterior
						System.out.printf("       TOTALES POR PEDIDO                                              %-7.2f  %-10.2f  %-10.2f\n",
								totalCantidadPedido, totalPrecioUnidadPedido, totalImportePedido);
						System.out.println("------------------------------------------------------------------------------------------------------");
					}

					// Mostrar encabezado del nuevo pedido
					String fechaPedido = pedidosRs.getString("fechapedido");
					String estadoPedido = pedidosRs.getString("estado");
					System.out.printf("COD-PEDIDO:  %-10s FECHA PEDIDO: %-15s ESTADO DEL PEDIDO: %-15s\n",
							codigoPedido, fechaPedido, estadoPedido);

					System.out.println("NUM-LINEA  COD-PROD  NOMBRE PRODUCTO                           CANTIDAD  PREC-UNID    IMPORTE");
					System.out.println("---------  --------  ----------------------------------------- --------  -----------  ----------");

					// Reiniciar totales por pedido
					ultimoPedido = codigoPedido;
					totalCantidadPedido = 0;
					totalPrecioUnidadPedido = 0;
					totalImportePedido = 0;
				}

				// Mostrar líneas del pedido
				int numLinea = pedidosRs.getInt("NUMEROLINEA");
				String codigoProducto = pedidosRs.getString("CODIGOPRODUCTO");
				String nombreProducto = pedidosRs.getString("NOMBREPRODUCTO");
				int cantidad = pedidosRs.getInt("cantidad");
				double precioUnidad = pedidosRs.getDouble("preciounidad");
				double importe = pedidosRs.getDouble("importe");

				System.out.printf("%-9d  %-8s  %-40s  %-8d  %-11.2f  %-10.2f\n",
						numLinea, codigoProducto, nombreProducto, cantidad, precioUnidad, importe);

				// Acumular totales del pedido
				totalCantidadPedido += cantidad;
				totalPrecioUnidadPedido += precioUnidad;
				totalImportePedido += importe;

				// Verificar máximos
				if (totalImportePedido > maxImporteTotal) {
					maxImporteTotal = totalImportePedido;
					maxPedido = codigoPedido;
					maxFechaPedido = pedidosRs.getString("fechapedido");
				}
				if (cantidad > maxCantidad) {
					maxCantidad = cantidad;
					maxProductoCodigo = codigoProducto;
					maxProductoNombre = nombreProducto;
				}
			}

			// Mostrar totales del último pedido
			System.out.printf("TOTALES POR PEDIDO                                              %-7.2f  %-10.2f  %-10.2f\n",
					totalCantidadPedido, totalPrecioUnidadPedido, totalImportePedido);
			System.out.println("------------------------------------------------------------------------------------------------------");

			// Mostrar totales generales
			System.out.printf("COD de PEDIDO y FECHA PEDIDO CON TOTAL IMPORTE MÁXIMO:  %-15s %-10s\n", maxPedido, maxFechaPedido);
			System.out.printf("COD PRODUCTO y NOMBRE PRODUCTO, del producto más comprado (producto con CANTIDAD Máxima): %-10s %-30s\n",
					maxProductoCodigo, maxProductoNombre);

		} catch (SQLException e) {
			System.err.println("Error al obtener pedidos del cliente: " + e.getMessage());
		}
	}




	private static int getPedidosCount(Connection connection, String codigoCliente) throws SQLException {
		String countQuery = "SELECT COUNT(*) FROM PEDIDOS WHERE CODIGOCLIENTE = ?";
		PreparedStatement countPs = connection.prepareStatement(countQuery);
		countPs.setString(1, codigoCliente);
		ResultSet rs = countPs.executeQuery();
		rs.next();
		return rs.getInt(1);
	}


	public static void eliminarCrearClientesSinPedidos() {
	    try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##JARDINERIA", "Ora1234")) {
	    	
	    	String eliminarTablaQuery = "DROP TABLE CLIENTESSINPEDIDO CASCADE CONSTRAINTS";
	    	try (PreparedStatement stmt = connection.prepareStatement(eliminarTablaQuery)) {
	    	    stmt.executeUpdate();
	    	    System.out.println("Tabla CLIENTESSINPEDIDO eliminada.");
	    	} catch (SQLException e) {
	    	    System.out.println("La tabla CLIENTESSINPEDIDO no existía.");
	    	}

	    	
	        // 1. Crear la tabla CLIENTESSINPEDIDO si no existe
	        String crearTablaQuery = "CREATE TABLE CLIENTESSINPEDIDO ("
	                + "CODIGOCLIENTE NUMBER(10) NOT NULL, "
	                + "NOMBRECLIENTE VARCHAR2(100) NOT NULL, "
	                + "NOMBRECONTACTO VARCHAR2(50), "
	                + "APELLIDOCONTACTO VARCHAR2(50), "
	                + "TELEFONO VARCHAR2(20), "
	                + "FAX VARCHAR2(20), "
	                + "LINEADIRECCION1 VARCHAR2(100) NOT NULL, "
	                + "LINEADIRECCION2 VARCHAR2(100), "
	                + "CIUDAD VARCHAR2(50), "
	                + "REGION VARCHAR2(50), "
	                + "PAIS VARCHAR2(50), "
	                + "CODIGOPOSTAL VARCHAR2(10), "
	                + "CODIGOEMPLEADOREPVENTAS NUMBER(10), "
	                + "LIMITECREDITO NUMBER(10, 2)"
	                + ")";
	        try (PreparedStatement stmt = connection.prepareStatement(crearTablaQuery)) {
	            stmt.executeUpdate();
	            System.out.println("La tabla CLIENTESSINPEDIDO ha sido creada.");
	        } catch (SQLException e) {
	            if (e.getErrorCode() != 955) { // 955: tabla ya existe
	                System.err.println("Error al intentar crear la tabla CLIENTESSINPEDIDO: " + e.getMessage());
	                return;
	            }
	        }

	        // 2. Consultar los clientes que no tienen pedidos
	        String consultaClientesSinPedidos = "SELECT c.CODIGOCLIENTE, c.NOMBRECLIENTE, c.LINEADIRECCION1, c.FAX "
	                + "FROM CLIENTES c "
	                + "LEFT JOIN PEDIDOS p ON c.CODIGOCLIENTE = p.CODIGOCLIENTE "
	                + "WHERE p.CODIGOPEDIDO IS NULL";

	        String insertarClienteQuery = "INSERT INTO CLIENTESSINPEDIDO (CODIGOCLIENTE, NOMBRECLIENTE, NOMBRECONTACTO, APELLIDOCONTACTO, TELEFONO, FAX, LINEADIRECCION1, LINEADIRECCION2, CIUDAD, REGION, PAIS, CODIGOPOSTAL, CODIGOEMPLEADOREPVENTAS, LIMITECREDITO) "
	                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        try (PreparedStatement pstmt = connection.prepareStatement(consultaClientesSinPedidos);
	             ResultSet rs = pstmt.executeQuery();
	             PreparedStatement insertStmt = connection.prepareStatement(insertarClienteQuery)) {

	            while (rs.next()) {
	                // Recupera los valores desde el ResultSet
	                String codigoCliente = rs.getString("CODIGOCLIENTE");
	                String nombreCliente = rs.getString("NOMBRECLIENTE");
	                String lineaDireccion1 = rs.getString("LINEADIRECCION1");
	                String fax = rs.getString("FAX");
	                String ciudad = rs.getString("CIUDAD");

	                // Inserta los valores necesarios y utiliza valores predeterminados para los demás
	                insertStmt.setString(1, codigoCliente); // CODIGOCLIENTE
	                insertStmt.setString(2, nombreCliente); // NOMBRECLIENTE
	                insertStmt.setString(3, "SIN CONTACTO"); // NOMBRECONTACTO
	                insertStmt.setString(4, "SIN APELLIDO"); // APELLIDOCONTACTO
	                insertStmt.setString(5, "SIN TELÉFONO"); // TELEFONO
	                insertStmt.setString(6, fax != null ? fax : "SIN FAX"); // FAX
	                insertStmt.setString(7, lineaDireccion1); // LINEADIRECCION1
	                insertStmt.setString(8, null); // LINEADIRECCION2 (valor predeterminado)
	                insertStmt.setString(9, ciudad != null ? ciudad : "SIN CIUDAD"); // CIUDAD (valor predeterminado)
	                insertStmt.setString(10, "SIN REGIÓN"); // REGION
	                insertStmt.setString(11, "SIN PAÍS"); // PAIS
	                insertStmt.setString(12, "00000"); // CODIGOPOSTAL
	                insertStmt.setInt(13, 0); // CODIGOEMPLEADOREVENTAS
	                insertStmt.setDouble(14, 0.0); // LIMITECREDITO
	                // Ejecuta la inserción
	                insertStmt.executeUpdate();
	                System.out.printf("Cliente sin pedidos insertado: COD-CLIENTE: %-15s NOMBRE: %-25s DIRECCIÓN: %-30s\n",
	                        codigoCliente, nombreCliente, lineaDireccion1);
	            }
	        }

	        // 3. Eliminar los clientes que no tienen pedidos de la tabla CLIENTES
	        String eliminarClientesQuery = "DELETE FROM CLIENTES WHERE CODIGOCLIENTE IN (SELECT CODIGOCLIENTE FROM CLIENTESSINPEDIDO)";
	        try (PreparedStatement deleteStmt = connection.prepareStatement(eliminarClientesQuery)) {
	            int filasEliminadas = deleteStmt.executeUpdate();
	            System.out.println("Clientes eliminados de la tabla CLIENTES: " + filasEliminadas);
	        }

	    } catch (SQLException e) {
	    	e.printStackTrace(); // Ver detalles del error
	        System.err.println("Error al procesar la eliminación de clientes sin pedidos: " + e.getMessage());
	    }
	}


	public static void visualizarPedidosDeTodosLosClientes() {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##JARDINERIA", "Ora1234")) {
			
			

			// Obtener todos los clientes
			String clientesQuery = "SELECT codigocliente, nombreclientes, lineadireccion1 FROM clientes";
			Statement clientesStmt = connection.createStatement();
			ResultSet clientesRs = clientesStmt.executeQuery(clientesQuery);

			// Recorrer todos los clientes
			while (clientesRs.next()) {
				String codigoCliente = clientesRs.getString("codigocliente");
				String nombreCliente = clientesRs.getString("nombreclientes");
				String direccion1 = clientesRs.getString("lineadireccion1");

				// Consultar los pedidos del cliente
				String pedidosQuery = "SELECT p.CODIGOPEDIDO, p.FECHAPEDIDO, p.ESTADO, dp.NUMEROLINEA, " +
						"dp.CODIGOPRODUCTO, pr.NOMBRE AS NOMBREPRODUCTO, dp.CANTIDAD, dp.PRECIOUNIDAD, " +
						"(dp.CANTIDAD * dp.PRECIOUNIDAD) AS IMPORTE " +
						"FROM PEDIDOS p " +
						"JOIN DETALLEPEDIDOS dp ON p.CODIGOPEDIDO = dp.CODIGOPEDIDO " +
						"JOIN PRODUCTOS pr ON dp.CODIGOPRODUCTO = pr.CODIGOPRODUCTO " +
						"WHERE p.CODIGOCLIENTE = ? " +
						"ORDER BY p.CODIGOPEDIDO, dp.NUMEROLINEA";

				PreparedStatement pedidosPs = connection.prepareStatement(pedidosQuery);
				pedidosPs.setString(1, codigoCliente);
				ResultSet pedidosRs = pedidosPs.executeQuery();

				if (!pedidosRs.isBeforeFirst()) {
					System.out.println("El cliente con código " + codigoCliente + " no tiene pedidos registrados.");
					continue;
				}

				// Mostrar información del cliente
				System.out.printf("COD-CLIENTE: %-15s NOMBRE: %-25s\n", codigoCliente, nombreCliente);
				System.out.printf("DIRECCIÓN1: %-25s Número de pedidos: %d\n", direccion1, getPedidosCount(connection, codigoCliente));
				System.out.println("------------------------------------------------------------------------------------------------------");

				// Variables para totales generales y máximos
				double maxImporteTotal = 0;
				String maxPedido = "";
				String maxFechaPedido = "";
				int maxCantidad = 0;
				String maxProductoCodigo = "";
				String maxProductoNombre = "";

				// Variables para totales por pedido
				String ultimoPedido = "";
				double totalCantidadPedido = 0;
				double totalPrecioUnidadPedido = 0;
				double totalImportePedido = 0;

				while (pedidosRs.next()) {
					String codigoPedido = pedidosRs.getString("codigopedido");

					// Si es un nuevo pedido, imprimir totales del anterior
					if (!codigoPedido.equals(ultimoPedido)) {
						if (!ultimoPedido.isEmpty()) {
							// Mostrar totales del pedido anterior
							System.out.printf("       TOTALES POR PEDIDO                                              %-7.2f  %-10.2f  %-10.2f\n",
									totalCantidadPedido, totalPrecioUnidadPedido, totalImportePedido);
							System.out.println("------------------------------------------------------------------------------------------------------");
						}

						// Mostrar encabezado del nuevo pedido
						String fechaPedido = pedidosRs.getString("fechapedido");
						String estadoPedido = pedidosRs.getString("estado");
						System.out.printf("COD-PEDIDO:  %-10s FECHA PEDIDO: %-15s ESTADO DEL PEDIDO: %-15s\n",
								codigoPedido, fechaPedido, estadoPedido);

						System.out.println("NUM-LINEA  COD-PROD  NOMBRE PRODUCTO                           CANTIDAD  PREC-UNID    IMPORTE");
						System.out.println("---------  --------  ----------------------------------------- --------  -----------  ----------");

						// Reiniciar totales por pedido
						ultimoPedido = codigoPedido;
						totalCantidadPedido = 0;
						totalPrecioUnidadPedido = 0;
						totalImportePedido = 0;
					}

					// Mostrar líneas del pedido
					int numLinea = pedidosRs.getInt("numerolinea");
					String codigoProducto = pedidosRs.getString("codigoproducto");
					String nombreProducto = pedidosRs.getString("nombreproducto");
					int cantidad = pedidosRs.getInt("cantidad");
					double precioUnidad = pedidosRs.getDouble("preciounidad");
					double importe = pedidosRs.getDouble("importe");

					System.out.printf("%-9d  %-8s  %-40s  %-8d  %-11.2f  %-10.2f\n",
							numLinea, codigoProducto, nombreProducto, cantidad, precioUnidad, importe);

					// Acumular totales del pedido
					totalCantidadPedido += cantidad;
					totalPrecioUnidadPedido += precioUnidad;
					totalImportePedido += importe;

					// Verificar máximos
					if (totalImportePedido > maxImporteTotal) {
						maxImporteTotal = totalImportePedido;
						maxPedido = codigoPedido;
						maxFechaPedido = pedidosRs.getString("fechapedido");
					}
					if (cantidad > maxCantidad) {
						maxCantidad = cantidad;
						maxProductoCodigo = codigoProducto;
						maxProductoNombre = nombreProducto;
					}
				}

				// Mostrar totales del último pedido
				System.out.printf("       TOTALES POR PEDIDO                                              %-7.2f  %-10.2f  %-10.2f\n",
						totalCantidadPedido, totalPrecioUnidadPedido, totalImportePedido);
				System.out.println("------------------------------------------------------------------------------------------------------");

				// Mostrar totales generales
				System.out.printf("COD de PEDIDO y FECHA PEDIDO CON TOTAL IMPORTE MÁXIMO:  %-15s %-10s\n", maxPedido, maxFechaPedido);
				System.out.printf("COD PRODUCTO y NOMBRE PRODUCTO, del producto más comprado (producto con CANTIDAD Máxima): %-10s %-30s\n",
						maxProductoCodigo, maxProductoNombre);

				System.out.println("------------------------------------------------------------------------------------------------------");

			}
		} catch (SQLException e) {
			System.err.println("Error al obtener pedidos: " + e.getMessage());
		}
	}

}
