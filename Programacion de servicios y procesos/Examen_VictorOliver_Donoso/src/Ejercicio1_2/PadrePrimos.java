package Ejercicio1_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;



public class PadrePrimos {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		File path = new File(".\\bin\\");
		
		  int numero = Integer.parseInt(args[0]);

		
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    		
    		ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio1.HijoPrimos",  String.valueOf(numero));
    	    pb.directory(path);
    	    pb.redirectErrorStream(true); 
    	    Process procesoHijo = pb.start();
    			
    			
    			
    	    OutputStream os = procesoHijo.getOutputStream();
    	    OutputStreamWriter osw = new OutputStreamWriter(os);
    	    BufferedWriter bw = new BufferedWriter(osw);
    	    bw.write(numero);
    	    bw.newLine();
    	    bw.flush();
    	    bw.close();

      
         int exitValue = procesoHijo.waitFor();
			
         if (exitValue == 0) 
             System.out.println("");
         else if (exitValue == 1) 
             System.out.println("SI");
         else if (exitValue == 2)
        	 System.out.print("NO");


	}

}
