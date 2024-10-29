package PruebaExamen;

import java.util.Scanner;

public class CadenaDeCaracteresHijo {
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		
		String cadena= args[0];
		
		 
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
