package PruebaExamen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CadenaDeCaracteresHijo {
	
	public static void main(String[] args){
		//Scanner sc = new Scanner(System.in);
		String cadena = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//cadena = sc.nextLine();
		//cadena = br.readLine();
		
		 
		 if(cadena.isEmpty()) {
			 System.exit(0);
		 }
		 else {
			 
			 esPalindromo(cadena);
			 
		 } 
		
	}
	
	
	public static void esPalindromo(String cadena) {
		
        if (cadena.equalsIgnoreCase(new StringBuilder(cadena).reverse().toString())) {
        	System.exit(1);
        } else {
        	System.exit(2);
        }
    }

}