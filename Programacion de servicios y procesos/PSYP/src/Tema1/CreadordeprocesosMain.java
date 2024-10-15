package Tema1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import utilidades.Teclado;

public class CreadordeprocesosMain {

	public static void main(String[] args) throws IOException, InterruptedException {

		File path = new File(".\\bin\\");
		System.out.println(path.getAbsolutePath());
		String resultado = Teclado.leerCadena("Introduce si o no: ");

		ProcessBuilder pb = new ProcessBuilder("java", "Tema1.ContarVocalesMain", resultado);

		pb.redirectErrorStream(true);
		pb.directory(path);

		Process proceso = pb.start();

		if (resultado.equals("si")) {
			
			 proceso.waitFor();
			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			
			String linea;
			 while ((linea = br.readLine()) != null) {
	                System.out.println(linea); 
	            }
			
		}

		System.out.println("El proceso ha terminado");
		proceso.destroy();

	}

}
