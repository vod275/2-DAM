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
                	insertarEmpleadoDesdeMenu(scanner);
                    break;
                case 2:
                	System.out.print("Dime el codigo del cliente que quieras ver su pedido: ");
                    String codigoCliente = scanner.nextLine();
                    GestionClientes.visualizarPedidosCliente(codigoCliente);
                    break;
                case 3:
                    ClientManager.createClientsWithoutOrders();
                    break;
                case 4:
                    EmployeeManager.updateClientsPerEmployee();
                    break;
                case 5:
                    ProductManager.createStockUpdated();
                    break;
                case 6:
                    OfficeManager.showOfficeDetails("OFFICE_CODE_EXAMPLE");
                    break;
                case 7:
                    OrderManager.viewAllOrders();
                    break;
                case 8:
                    EmployeeManager.handleNewEmployees();
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
        private static void insertarEmpleadoDesdeMenu(Scanner scanner) {
            System.out.println("===== Insertar Nuevo Empleado =====");

            try {
            	 
            	
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Apellido 1: ");
                String apellido1 = scanner.nextLine();

                System.out.print("Apellido 2: ");
                String apellido2 = scanner.nextLine();

                System.out.print("Extensión: ");
                String extension = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                System.out.print("Código de Oficina: ");
                String codigoOficina = scanner.nextLine();

                System.out.print("Código de Jefe (0 si no tiene jefe): ");
                int codigoJefeInput = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                Integer codigoJefe = (codigoJefeInput == 0) ? null : codigoJefeInput;

                System.out.print("Puesto: ");
                String puesto = scanner.nextLine();

                // Llamar al método de gestión para insertar empleado
                GestionEmpleados.insertarEmpleado(nombre, apellido1, apellido2, extension, email, codigoOficina, codigoJefe, puesto);

            } catch (Exception e) {
                System.err.println("Error al insertar empleado: " + e.getMessage());
            }
        }
    
}
