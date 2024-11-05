package Ejercicio1_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HijoPrimos {

	public static void main(String[] args) {
		
		int numero  = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer.parseInt(args[0]);
		
		if(numero==0) {
			System.exit(0);
		}
		
			DivisibleEntre5(numero);	
		

	}
	
	
	
	
	public static void DivisibleEntre5(int numero) {

		  if (numero < 5) {
	        	System.exit(1);
	        } else {
	        	System.exit(2);
	        }
	}

}
