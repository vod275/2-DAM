/**
 * 
 */

import java.util.Scanner;

/**
 * 
 */
public class Clase_1 {

	
	public static void main(String[] args) {
		
		
		
		System.out.println("Introduce el radio");
		Scanner scanner = new Scanner(System.in);
		Double radio = scanner.nextDouble();
		
		double area = Math.PI * Math.pow(radio, 2);
	
	
		System.out.println("El area es: " + area);
		
		
	}

}
