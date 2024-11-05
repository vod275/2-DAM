package PruebaExamen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class CadenaDeCaracteresPadre {
	    
    public static void main(String[] args) throws IOException {

        File path = new File(".\\bin\\");
        String cadena = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduce  una cadena por teclado: ");
		cadena = br.readLine();


        try {

            ProcessBuilder pb = new ProcessBuilder("java", "PruebaExamen.CadenaDeCaracteresHijo");
            pb.directory(path);
            pb.redirectErrorStream(true); 
            Process procesoHijo = pb.start();
            
            
            OutputStream os = procesoHijo.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(cadena);
			bw.flush();
            
            
            int exitValue = -1;
			if (exitValue == 1) 
				System.out.println("La cadena estaba vacía");
			else if (exitValue == 2) 
				System.out.println("La cadena es palíndroma");
			else if (exitValue == 3) 
				System.out.println("La cadena no es palíndroma");
			
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
