package Jardineria;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("--------------------------------------------------------------");
            System.out.println(".  1 Insertar Empleado");
            System.out.println(".  2 Visualizar pedidos de un cliente");
            System.out.println(".  3 Crear clientes sin pedido");
            System.out.println(".  4 Actualizar Clientes por empleado");
            System.out.println(".  5 Crear STOCKACTUALIZADO");
            System.out.println(".  6 Oficinas con función almacenada");
            System.out.println(".  7 Ver los pedidos de todos los clientes");
            System.out.println(".  8 Tratar nuevos empleados");
            System.out.println(".  0 SALIR");
            System.out.println("--------------------------------------------------------------");
            System.out.print("TECLEA OPERACIÓN: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                	insertarEmpleadoDesdeMenu();
                    break;
                case 2:
                	System.out.print("Dime el codigo del cliente que quieras ver su pedido: ");
                    String codigoCliente = scanner.nextLine();
                    GestionClientes.visualizarPedidosCliente(codigoCliente);
                    break;
                case 3:
                    GestionClientes.eliminarCrearClientesSinPedidos();
                    break;
                case 4:
                    GestionEmpleados.actualizarClientesPorEmpleado();
                    break;
                case 5:
                    GestionProductos.crearYActualizarStock();
                    break;
                case 6:
                	System.out.println("Introduce un codigo de oficinas: ");
                	String codigo = scanner.next();
                    GestionOficinas.verOficina(codigo);
                    
                    break;
                case 7:
                    GestionClientes.visualizarPedidosDeTodosLosClientes();
                    break;
                case 8:
                    
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 0);

        scanner.close();
        
        
    } 
    private static void insertarEmpleadoDesdeMenu() {
        System.out.println("===== Insertar Nuevo Empleado =====");

        try {
            // Datos inventados
            String nombre = "Juan";
            String apellido1 = "Pérez";
            String apellido2 = "González";
            String extension = "1234";
            String email = "juan.perez@empresa.com";
            String codigoOficina = "OF001";
            Integer codigoJefe = 2; // Asumiendo que el jefe tiene código 2, puedes poner null si no tiene jefe.
            String puesto = "Desarrollador";

            // Llamar al método de gestión para insertar empleado
            GestionEmpleados.insertarEmpleado(nombre, apellido1, apellido2, extension, email, codigoOficina, codigoJefe, puesto);

        } catch (Exception e) {
            System.err.println("Error al insertar empleado: " + e.getMessage());
        }
    }

    
}
