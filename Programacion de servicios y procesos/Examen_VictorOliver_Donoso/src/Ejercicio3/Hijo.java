package Ejercicio3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hijo {

	public static void main(String[] args) {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer.parseInt(args[0]);
		
		
	   numerosAleatorios();


	}
	
	
	
	public static int  numerosAleatorios() {
		 int numero1 =  (int) Math.random() ;
		 
	       return numero1;
	}
		
}


