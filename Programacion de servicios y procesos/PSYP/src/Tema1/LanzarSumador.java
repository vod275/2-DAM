package Tema1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LanzarSumador {
    public void LanzarSumadorM(Integer n1, Integer n2, String fichResul) throws IOException {
    
    	String clase1 = "Tema1.Sumador.java";
    
       ProcessBuilder pb;
       //File path = new File("C:\\Users\\Alumno\\Desktop\\2-DAM\\Programacion de servicios y procesos\\PSYP\\bin\\Tema1");
	   
       try {
    	   pb = new ProcessBuilder("java", clase1, n1.toString(), n2.toString());
    	   pb.redirectErrorStream(true);
    	   pb.redirectOutput(new File(fichResul));
    	   pb.start();
    	   
       }catch (Exception e) {
    	   e.printStackTrace();
    	   
    	   
       }
 
    }
    
    public static void main(String[] args) throws IOException {
    	LanzarSumador lanzar = new LanzarSumador();
    	lanzar.LanzarSumadorM(1, 51, "res.txt");
    	lanzar.LanzarSumadorM(51, 100, "res2.txt");
    	System.out.println("OK");
    	
    	
    	InputStream inputStream1 = lanzar.getInputStream();
    	
    }
}