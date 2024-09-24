package Tema1;

import java.io.IOException;

public class Ejercicio03 {
	
	private static final  String CHROME =
			"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
	private static String[] CALC = {"C:\\Windows\\System32\\calc.exe"};
	private static String[] CHROMEA = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};
	
	public static void main(String[] args) throws InterruptedException {
		
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		
		Runtime runtime = Runtime.getRuntime();
		
		try {
			Process process = runtime.exec(CALC);
			Process pr2 = runtime.exec(CHROME);
			Thread.sleep(6000);
			
			process.destroy();
			pr2.destroy();
			
		}catch (IOException e) {
			 
					System.err.println("Excepción de E/S!!");
					System.exit(-1);

	    }

   }
}
