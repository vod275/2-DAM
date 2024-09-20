/**
 * 
 */
import java.util.Scanner;
/**
 * 
 */
public class Clase_04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// lo mismo que el anterior pero hay que meter un caracter char

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce un caracter: ");
		String caracter = scanner.next();
		
		char caracterASCII = caracter.charAt(0);
				
				
		int numero = (int) caracterASCII;
		
		
		System.out.println("Caracter introducido: " + caracterASCII);
		System.out.println("Numero  correspondiente: " + numero);
	}

}
