package Jardineria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionClientes {

    public static void visualizarPedidosCliente(String codigoCliente) {
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##VICTOR", "Ora1234")) {

            // Verificar si el cliente existe
            String clienteQuery = "SELECT nombre, direccion1 FROM clientes WHERE codigocliente = ?";
            PreparedStatement clientePs = connection.prepareStatement(clienteQuery);
            clientePs.setString(1, codigoCliente);
            ResultSet clienteRs = clientePs.executeQuery();

            if (!clienteRs.next()) {
                System.out.println("El cliente con código " + codigoCliente + " no existe en la base de datos.");
                return;
            }

            String nombreCliente = clienteRs.getString("nombre");
            String direccion1 = clienteRs.getString("direccion1");

            // Consultar los pedidos del cliente
            String pedidosQuery = "SELECT \r\n"
                    + "    p.CODIGOPEDIDO, \r\n"
                    + "    p.FECHAPEDIDO, \r\n"
                    + "    p.ESTADO, \r\n"
                    + "    dp.NUMEROLINEA, \r\n"
                    + "    dp.CODIGOPRODUCTO, \r\n"
                    + "    pr.NOMBRE AS NOMBREPRODUCTO, \r\n"
                    + "    dp.CANTIDAD, \r\n"
                    + "    dp.PRECIOUNIDAD, \r\n"
                    + "    (dp.CANTIDAD * dp.PRECIOUNIDAD) AS IMPORTE\r\n"
                    + "FROM \r\n"
                    + "    PEDIDOS p\r\n"
                    + "JOIN \r\n"
                    + "    DETALLEPEDIDOS dp ON p.CODIGOPEDIDO = dp.CODIGOPEDIDO\r\n"
                    + "JOIN \r\n"
                    + "    PRODUCTOS pr ON dp.CODIGOPRODUCTO = pr.CODIGOPRODUCTO\r\n"
                    + "WHERE \r\n"
                    + "    p.CODIGOCLIENTE = ?\r\n"
                    + "ORDER BY \r\n"
                    + "    p.CODIGOPEDIDO, dp.NUMEROLINEA";

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
                int numLinea = pedidosRs.getInt("numlinea");
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
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##VICTOR", "Ora1234")) {
            
            // 1. Verificar si la tabla CLIENTESSINPEDIDO existe y si no, crearla
            String crearTablaQuery = "CREATE TABLE CLIENTESSINPEDIDO AS SELECT * FROM CLIENTES WHERE 1=0";
            try (PreparedStatement stmt = connection.prepareStatement(crearTablaQuery)) {
                stmt.executeUpdate();
                System.out.println("La tabla CLIENTESSINPEDIDO ha sido creada.");
            } catch (SQLException e) {
                // Código de error 955 indica que la tabla ya existe en Oracle
                if (e.getErrorCode() != 955) {
                    System.err.println("Error al intentar crear la tabla CLIENTESSINPEDIDO: " + e.getMessage());
                    return;
                }
            }

            // 2. Consultar los clientes que no tienen pedidos
            String consultaClientesSinPedidos = "SELECT c.CODIGOCLIENTE, c.NOMBRE, c.DIRECCION1 "
                    + "FROM CLIENTES c "
                    + "LEFT JOIN PEDIDOS p ON c.CODIGOCLIENTE = p.CODIGOCLIENTE "
                    + "WHERE p.CODIGOPEDIDO IS NULL";

            try (PreparedStatement pstmt = connection.prepareStatement(consultaClientesSinPedidos);
                 ResultSet rs = pstmt.executeQuery()) {

                // 3. Insertar los clientes sin pedidos en la tabla CLIENTESSINPEDIDO
                String insertarClienteQuery = "INSERT INTO CLIENTESSINPEDIDO (CODIGOCLIENTE, NOMBRE, DIRECCION1) VALUES (?, ?, ?)";
                try (PreparedStatement insertStmt = connection.prepareStatement(insertarClienteQuery)) {
                    while (rs.next()) {
                        String codigoCliente = rs.getString("CODIGOCLIENTE");
                        String nombre = rs.getString("NOMBRE");
                        String direccion = rs.getString("DIRECCION1");

                        insertStmt.setString(1, codigoCliente);
                        insertStmt.setString(2, nombre);
                        insertStmt.setString(3, direccion);

                        // Ejecutamos la inserción en CLIENTESSINPEDIDO
                        insertStmt.executeUpdate();
                        System.out.printf("Cliente sin pedidos insertado: COD-CLIENTE: %-15s NOMBRE: %-25s DIRECCIÓN: %-30s\n",
                                codigoCliente, nombre, direccion);
                    }
                }

            }

            // 4. Eliminar los clientes que no tienen pedidos de la tabla CLIENTES
            String eliminarClientesQuery = "DELETE FROM CLIENTES WHERE CODIGOCLIENTE IN (SELECT CODIGOCLIENTE FROM CLIENTESSINPEDIDO)";
            try (PreparedStatement deleteStmt = connection.prepareStatement(eliminarClientesQuery)) {
                int filasEliminadas = deleteStmt.executeUpdate();
                System.out.println("Clientes eliminados de la tabla CLIENTES: " + filasEliminadas);
            }

        } catch (SQLException e) {
            System.err.println("Error al procesar la eliminación de clientes sin pedidos: " + e.getMessage());
        }
    }
    
    public static void visualizarPedidosDeTodosLosClientes() {
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##VICTOR", "Ora1234")) {
            
            // Obtener todos los clientes
            String clientesQuery = "SELECT codigocliente, nombre, direccion1 FROM clientes";
            Statement clientesStmt = connection.createStatement();
            ResultSet clientesRs = clientesStmt.executeQuery(clientesQuery);

            // Recorrer todos los clientes
            while (clientesRs.next()) {
                String codigoCliente = clientesRs.getString("codigocliente");
                String nombreCliente = clientesRs.getString("nombre");
                String direccion1 = clientesRs.getString("direccion1");

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
                    int numLinea = pedidosRs.getInt("numlinea");
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
