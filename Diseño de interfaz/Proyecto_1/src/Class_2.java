/**
 * 
 */

import java.util.Scanner;

/**
 * 
 */
public class Class_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//hacer si un numero es divisible entre 2
		
		System.out.println("Introduce un numero");
		Scanner scanner = new Scanner(System.in);
		Double numero = scanner.nextDouble();
		
		if(numero%2 == 0)
		{
			System.out.println("El numero es divisible entre 2");
		}
		else
		{
			System.out.println("El numero no es divisible entre 2");
		}
		

	}

}
