import java.util.Scanner;

public class Clase_09 {

	public static void main(String[] args) {
		// realiza una aplicacion que nos pida un numero de ventas a introducir,
		//despues nos pedira tantas ventas por teclado, como numero de ventas se hayan indicado.
		// al final mostrara la suma de todas las ventas, piensa que es lo que se repite y que es lo que no.
		
		System.out.println("Dime un numero de ventas: ");
		Scanner scanner = new Scanner(System.in);
		int ventasNumero = scanner.nextInt();
					
		 double sumaVentas = 0;
		 
			for (int i = 1; i <= ventasNumero; i++) {
					            
	            	System.out.println("Introduce la venta: ");
	            	double venta = scanner.nextDouble();
	            	
	            	sumaVentas = sumaVentas + venta;
	            
	        }
			
			  System.out.println("La suma total de las ventas es: " + sumaVentas);
		}

	}


