import java.util.Scanner;

public class Clase_13 {

	public static void main(String[] args) {
		// Pide por teclado dos numeros y genera 10 numeros aleatorios entre esos numeros, usa el metodo Math.random
		// para generar un numero entero aleatorio(recuerda casting de double a int)

		Scanner scanner = new Scanner(System.in);
		System.out.println("Dime un numero: ");
		
		int numero1 = scanner.nextInt();
		
		System.out.println("Dime otro: ");
		int numero2 = scanner.nextInt();
		
		int min = Math.min(numero1, numero2);
		int max = Math.max(numero1, numero2);
		
		System.out.println("10 números aleatorios entre " + min + " y " + max + ":");
		
		  for (int i = 0; i < 10; i++) {
	            int numeroAleatorio = (int) (Math.random() * (max - min + 1)) + min;
	            System.out.println(numeroAleatorio);
	        }
	}

}
