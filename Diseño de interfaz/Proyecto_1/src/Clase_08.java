
public class Clase_08 {

	public static void main(String[] args) {
		// muestra los numeros del 1 al 100 ambos incluidos divisibles entre 2 y 3, el bucle que desees
		int numero = 1;
		while(numero <= 100)
		{
			
			if(numero % 2 == 0 && numero % 3 == 0)
			{
				System.out.println(numero);
			}
					
			numero++;
			
		}
	}

}
