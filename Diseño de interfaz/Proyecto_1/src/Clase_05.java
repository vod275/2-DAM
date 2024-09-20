import java.util.Scanner;

public class Clase_05 {

	public static void main(String[] args) {
		// lee un numero por teclado que pida el precio de un producto, y calcule el precio final con IVA 21%
		
		final double iva = 0.21;
		
		System.out.println("Introduce el precio de un producto: ");
		Scanner scanner = new Scanner(System.in);
		double precio = scanner.nextDouble();
		
		
		double precioFinal = (precio * iva) + precio;
		
		System.out.println("Precio sin IVA: " + precio);
		System.out.println("El precio con IVA es: " + precioFinal);

	}

}
