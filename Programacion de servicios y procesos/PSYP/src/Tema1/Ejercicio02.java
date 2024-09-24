package Tema1;

import java.io.IOException;
//ejemplo terminacion procesos
public class Ejercicio02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(args);
			Thread.sleep(6000);
			process.destroy();
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		}
	}

}