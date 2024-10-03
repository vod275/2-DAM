import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GestorAlumnosYNotas {

	
	public static void actualizarAlumnos() throws IOException {
		String rutaAlumnos = "C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso a datos\\Ejercicio_Tipo_Examen\\src\\main\\resources\\Alumnos.dat";
        String rutaNotas = "C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso a datos\\Ejercicio_Tipo_Examen\\src\\main\\resources\\Notas.dat";

        File ficheroAlumnos = new File(rutaAlumnos);
        File ficheroNotas = new File(rutaNotas);

        RandomAccessFile file = new RandomAccessFile(ficheroAlumnos, "r");
        RandomAccessFile file1= new RandomAccessFile(ficheroNotas, "r");

		   

		    // Imprimir encabezados
		    System.out.printf("%-10s %-20s %-20s %-10s %-10s%n", "NUMALUM", "NOMBRE", "LOCALIDAD", "NUMASIG", "NOTA MEDIA");
		    System.out.println("--------------------------------------------------------------");

		    for (int posicion = 0; posicion<file.length(); posicion+=92 ) {
		        file.seek(posicion); // Nos posicionamos en la posición
		        int codAlumno = file.readInt(); // Obtengo el código de alumno

		        char[] nombreChars = new char[20];
		        for (int i = 0; i < nombreChars.length; i++) {
		            nombreChars[i] = file.readChar(); // Leo carácter por carácter
		        }
		        String nombre = new String(nombreChars).trim(); // Convertir a String y eliminar espacios

		        
		        
		        char[] localidadChars = new char[20];
		        for (int i = 0; i < localidadChars.length; i++) {
		            localidadChars[i] = file.readChar(); // Leo carácter por carácter
		        }
		        String localidad = new String(localidadChars).trim(); // Convertir a String y eliminar espacios

		        //Segundo For
		        
		        
		        int numAsignaturas = file.readInt(); // Obtengo el número de asignaturas
		        float notaMedia = file.readFloat(); // Obtengo la nota media

		        // Mostrar los datos formateados
		        System.out.printf("%-10d %-20s %-20s %-10d %-10.2f%n", 
		                          codAlumno, nombre, localidad, numAsignaturas, notaMedia);

		        posicion += 92; // 92

		        // Si he recorrido todos los bytes salgo del for
		        if (file.getFilePointer() >= file.length()) {
		            break;
		        }
		    }
		    
		    file.close(); // Cerrar fichero
		}
}

