import java.util.Scanner;

public class Clase_14 {

	public static void main(String[] args) {
		// pide por teclado un entero positivo, (debemos controlarlo) y muestra el numero de cifras que tiene
		// por ejemplo: 1250 serian 4 cifras, 
		// tenemos que controlar sii tiene una o mas cifras al mostrar el mensaje
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime un numero: ");
		int numero = scanner.nextInt();
		
		
		int numeroCifras = Integer.toString(numero).length();
		

		System.out.println("Tiene: " + numeroCifras + " cifras");

	}

}
