package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class GestionarEmpleados {


    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","root", "");
             Scanner scanner = new Scanner(System.in)) {
             
            int opcion;
            do {
                System.out.println("\n--- Menú de Gestión de Empleados ---");
                System.out.println("1. Comprobar empleado");
                System.out.println("2. Borrar empleado");
                System.out.println("3. Modificar empleado");
                System.out.println("4. Insertar empleado");
                System.out.println("5. Ver todos los empleados");
                System.out.println("6. Ver un empleado");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el número del empleado: ");
                        int empNo = scanner.nextInt();
                        //System.out.println(OperacionesEmple.comprobaremple(conexion, empNo) ? "El empleado existe." : "El empleado no existe.");
                        		if(OperacionesEmple.comprobaremple(conexion, empNo)) {
                        			System.out.println("El empleado existe");
                        		}else {
                        			System.out.println( "El empleado no existe");
                        		};
                        	
                        break;

                    case 2:
                        System.out.print("Ingrese el número del empleado a borrar: ");
                        empNo = scanner.nextInt();
                        System.out.println(OperacionesEmple.borraremple(conexion, empNo));
                        break;

                    case 3:
                        System.out.print("Ingrese los datos del empleado (número, apellido, oficio, salario, comisión, dept_no, dir): ");
                        empNo = scanner.nextInt();
                        String ape = scanner.next();
                        String ofi = scanner.next();
                        float sal = scanner.nextFloat();
                        float comi = scanner.nextFloat();
                        int dep = scanner.nextInt();
                        int dir = scanner.nextInt();
                        System.out.println(OperacionesEmple.modificaremple(conexion, empNo, ape, ofi, sal, comi, dep, dir));
                        break;

                    case 4:
                        System.out.print("Ingrese los datos del nuevo empleado (número, apellido, oficio, salario, comisión, dept_no, dir): ");
                        empNo = scanner.nextInt();
                        ape = scanner.next();
                        ofi = scanner.next();
                        sal = scanner.nextFloat();
                        comi = scanner.nextFloat();
                        dep = scanner.nextInt();
                        dir = scanner.nextInt();
                        System.out.println(OperacionesEmple.insertaremple(conexion, empNo, ape, ofi, sal, comi, dep, dir));
                        break;

                    case 5:
                        OperacionesEmple.verempleados(conexion);
                        break;

                    case 6:
                        System.out.print("Ingrese el número del empleado: ");
                        empNo = scanner.nextInt();
                        OperacionesEmple.verunempleado(conexion, empNo);
                        break;

                    case 0:
                        System.out.println("Saliendo del programa.");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
