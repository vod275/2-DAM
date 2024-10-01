package Tema1;

public class Sumador {

	
	
	public static void main(String[] args) {
		 int numero1 = Integer.parseInt(args[0]);
         int numero2 = Integer.parseInt(args[1]);
         
         int resultado = sumar(numero1, numero2);
         System.out.println("La suma de " + numero1 + " y " + numero2 + " es: " + resultado);
	}
	
	  public static int sumar(int a, int b) {
	        return a + b;
	    }
}
