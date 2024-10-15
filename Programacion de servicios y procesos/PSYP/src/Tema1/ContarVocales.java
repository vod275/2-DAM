package Tema1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContarVocales {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String letra = args[0];
		char letraChar = letra.charAt(0);
		String fichero = args[1];
		String nuevo = "..\\" + args[2];
		int suma = 0;
		
		try (FileReader fr = new FileReader(fichero)) {
			int caracter;
			while ((caracter = fr.read()) != -1) {
				if ((char) caracter == letraChar) {
					suma++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileWriter guardar = new FileWriter(nuevo)) {
			guardar.write(String.valueOf(suma));
			System.out.println("Suma guardada con exito en " + nuevo + " con el caracte: " + letraChar + " : " + suma);
		} catch (IOException e) {
			System.out.println("Ocurrió un error al guardar en " + nuevo);
			e.printStackTrace();
		}
	}
}
