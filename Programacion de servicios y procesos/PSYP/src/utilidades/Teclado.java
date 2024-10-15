package utilidades;

import java.util.Scanner;

public class Teclado {

	static Scanner teclado;
	
	public static String leerCadena(String mensaje) {
		teclado = new Scanner(System.in);
		System.out.println(mensaje);
		String cad = teclado.nextLine();
		return cad;
	}
	public static char leerCaracter(String mensaje) {
		teclado = new Scanner(System.in);
		System.out.println(mensaje);
		String cad = teclado.nextLine();
		char car=cad.charAt(0);
		return car;
	}
	public static int leerEntero(String mensaje) {
		teclado = new Scanner(System.in);
		System.out.println(mensaje);
		int entero = teclado.nextInt();
		return entero;
	}
	
	public static double leerDouble(String mensaje) {
		teclado = new Scanner(System.in);
		System.out.println(mensaje);
		double doble = teclado.nextDouble();
		return doble;
	}
	public static void cerrarTeclado(){
		teclado.close();
	}
}