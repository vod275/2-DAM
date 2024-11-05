package Ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Padre {

	public static void main(String[] args) throws IOException {
		

		File path = new File(".\\bin\\");
		
		String cadena = "";

		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce una cadena por teclado: ");
        cadena = br.readLine();

  		
  		ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio3.Hijo");
  	    pb.directory(path);
  	    pb.redirectErrorStream(true); 
  	    Process procesoHijo = pb.start();
  			
  			
  			
  	    OutputStream os = procesoHijo.getOutputStream();
  	    OutputStreamWriter osw = new OutputStreamWriter(os);
  	    BufferedWriter bw = new BufferedWriter(osw);
  	    bw.write(cadena);
  	    bw.newLine();
  	    bw.flush();
  	    bw.close();
  	    
		
	}
}



    