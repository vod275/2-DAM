import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeerArchivoYcrearlo {

	public static void main(String[] args) {


		
		 String rutaArchivo = "C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.txt";
	        File archivo = new File(rutaArchivo);

	        // Verificar si el archivo existe
	        if (!archivo.exists()) {
	            try {
	                // Crear el archivo si no existe
	                archivo.createNewFile();
	                
	                // Escribir algo en el archivo
	                try (FileWriter fw = new FileWriter(archivo)) {
	                    fw.write("Hola, este archivo ha sido creado porque no existía.\n");
	                }
	            } catch (IOException e) {
	                System.out.println("Error al crear el archivo: " + e.getMessage());
	            }
	        }
	       

	        // Leer el archivo
	        try (FileReader fr = new FileReader(archivo)) {
	            int charLeido;
	            while ((charLeido = fr.read()) != -1) {
	                System.out.print((char) charLeido);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}
