package Tema1;

import java.io.File;
import java.io.IOException;

import utilidades.Teclado;

public class ContarVocalesMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		char letra = 'a';
		File path = new File("..\\bin\\");
		System.out.println(path.getAbsolutePath());

		//do {
		//letra = Teclado.leerCaracter("Introduce la vocal a buscar: ");
		//Character.toLowerCase(letra);
		//} while (letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u');
		
		
		ProcessBuilder pb = new ProcessBuilder("java", "Tema1.ContarVocales", String.valueOf(letra),
				"..\\ContarVocales.txt", "Resultado.txt");
		
		
		pb.redirectErrorStream(true);
		pb.directory(path);
		Process proceso = pb.start();
		proceso.waitFor();
		System.out.println("El proceso ha terminado");
		proceso.destroy();
	}

}
