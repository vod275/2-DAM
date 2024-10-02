package Tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class LanzarSumador {
    
	
	public void LanzarSumadorM(Integer n1, Integer n2, String fichResul) throws IOException {
    
		
      	
    	  
	}
    	   
    
    
    public static void main(String[] args) throws IOException, InterruptedException {
    	int n1 = 10;
		int n2 = 10;
		Process p;
    	String clase1 = "Tema1.Sumador";
    
        ProcessBuilder pb;
        // File path = new File("C:\\Users\\Alumno\\Desktop\\2-DAM\\Programacion de servicios y procesos\\PSYP\\bin\\Tema1");
        File directorioSumador = new File(".\\bin");
	   
       
        pb = new ProcessBuilder("java", clase1, String.valueOf(n1),String.valueOf(n2));
        pb.directory(directorioSumador);
        p = pb.redirectErrorStream(true).start();
    	 
        System.out.println("Suma lanzada....");
    	  
        Thread.sleep(5000);
        InputStream inputStream = p.getInputStream();
    	  
    	BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    	  
    	var lines = br.lines();
    	  
    	String sumaTotal = lines.collect(Collectors.joining("\n"));
    	System.out.println("La suma total es" + sumaTotal);
    	
    	
    }
}