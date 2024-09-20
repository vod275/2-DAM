import java.util.Scanner;

public class Clase_15 {

    public static void main(String[] args) {
        // Pide un número por teclado e indica si es un número primo o no
    	
    	
        System.out.println("Introduce un número entero: ");
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();

        if (esPrimo(numero)) {
            System.out.println("El número " + numero + " es primo.");
        } else {
            System.out.println("El número " + numero + " no es primo.");
        }

     
    }

  
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false; 
        }

      
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; 
            }
        }

        return true;  
    }
}