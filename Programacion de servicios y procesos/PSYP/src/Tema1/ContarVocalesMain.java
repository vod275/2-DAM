package Tema1;
import java.io.IOException;

public class ContarVocalesMain {

	 public static void main(String[] args) {
	        
	        String archivoTexto = ".\\ContarVocales.txt";
	        String vocal = "a"; 
	        String archivoResultado = "D:\\Usuario\\Documents\\GitHub\\2-DAM\\Programacion de servicios y procesos\\PSYP\\resultado.txt";

	        
	        ProcessBuilder pb = new ProcessBuilder("java", "ContarVocales", archivoTexto, vocal, archivoResultado);
	        
	        try {
	           
	            Process proceso = pb.start();
	            proceso.waitFor(); 
	            System.out.println("Proceso completado, revisa el archivo " + archivoResultado);
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

}



