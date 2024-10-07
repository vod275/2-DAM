import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
        Scanner scanner = new Scanner(System.in);
        GestorAlumnos gestorAlumnos = new GestorAlumnos();
        GestorNotas gestorNotas = new GestorNotas();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                	GestorAlumnos.listarAlumnos("C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso a datos\\Ejercicio_Tipo_Examen\\src\\main\\resources\\Alumnos.dat");
                    break;
                case 2:
                    GestorNotas.listarNotas("C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso a datos\\Ejercicio_Tipo_Examen\\src\\main\\resources\\Notas.dat");
                    break;
                case 3:
                	GestorAlumnosYNotas.actualizarAlumnos();
                    break;
                case 4:
                	GenerarAlumnosXML.generarXMLAlumnos("C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso a datos\\Ejercicio_Tipo_Examen\\src\\main\\resources\\Alumnos.dat", "C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso a datos\\Ejercicio_Tipo_Examen\\src\\main\\resources\\Notas.dat", "C:\\Users\\Alumno\\Documents\\Alumnos.xml");
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);

        scanner.close(); // Cerrar el scanner al final
    }

    private static void mostrarMenu() {
        System.out.println("MENÚ DE OPERACIONES");
        System.out.println("1. Listar alumnos");
        System.out.println("2. Listar notas");
        System.out.println("3. Actualizar el fichero Alumnos");
        System.out.println("4. Generar el fichero Alumnos.xml");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion(Scanner scanner) {
        int opcion = 0;
        while (true) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                break; // Salir del bucle si la conversión fue exitosa
            } catch (NumberFormatException e) {
                System.out.print("Por favor, ingrese un número válido: ");
            }
        }
        return opcion;
    }

   
}
