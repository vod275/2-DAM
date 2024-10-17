import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class GestorNotas {
	
	public static void listarNotas(String rutaFichero) throws IOException {
		
		  File fichero = new File(rutaFichero);
		    RandomAccessFile file = new RandomAccessFile(fichero, "r");
		    int codigoAlumno = 1;
		    
		    
		    // Imprimir encabezados
		    System.out.printf("%-10s %-20s %-20s %-10s%n","REGIS", "NUMALUM",  "ASIGNATURA", "NOTA");
		    System.out.println("--------------------------------------------------------------");
		    
		    for (int posicion = 0; posicion<file.length(); posicion+=48 ) {
		        file.seek(posicion); // Nos posicionamos en la posición
		        int numAlumno = file.readInt();
		        
		        char[] nombreAsignatura  = new char[20];
		        for (int i = 0; i < nombreAsignatura.length; i++) {
		        	nombreAsignatura[i] = file.readChar(); // Leo carácter por carácter
		        }
		        String asignatura = new String(nombreAsignatura).trim(); // Convertir a String y eliminar espacios

		        
		        
		        
		        float notaMedia = file.readFloat(); // Obtengo la nota media

		        // Mostrar los datos formateados
		        System.out.printf("%-10s %-20s %-20s %-10s%n", 
		        		codigoAlumno ,numAlumno, asignatura, notaMedia);

		        posicion += 48; // 48

		        // Si he recorrido todos los bytes salgo del for
		        if (file.getFilePointer() >= file.length()) {
		            break;
		        }
		        codigoAlumno++;
		    }
		    
		    file.close();
		
		
	}
	
}