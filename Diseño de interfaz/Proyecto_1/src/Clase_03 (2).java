/**
 * 
 */

import java.util.Scanner;

/**
 * 
 */
public class Clase_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        
        try {
           
            System.out.print("Introduce un número (0-127): ");
            int numero = scanner.nextInt();

           
            if (numero < 0 || numero > 127) {
                System.out.println("Número fuera del rango ASCII (0-127).");
            } else {
               
                char caracterASCII = (char) numero;
                
               
                System.out.println("Número introducido: " + numero);
                System.out.println("Carácter ASCII correspondiente: " + caracterASCII);
            }
        } catch (Exception e) {
           
            System.out.println("Entrada inválida. Por favor, introduce un número entero válido.");
        } finally {
           
            scanner.close();
        }
    }

}