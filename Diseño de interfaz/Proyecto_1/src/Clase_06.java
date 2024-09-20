
public class Clase_06 {

	public static void main(String[] args) {
		// muestra numeros del 1 al 100 primos(ambos incluidos con bucle while)
		
		
		int numero = 1;
		while(numero <= 100)
		{
			boolean primo = true;
			if(numero < 1)
			{
				primo = false;
			}
			else
			{
				int i = 2;
				while(i <= Math.sqrt(numero))
				{
					if(numero % i == 0)
					{
						primo = false;
						break;
					}
					
					
					i++;
				}
	
			}
			
			if(primo)
			{
				System.out.println(numero);
			}
			
			numero++;
		}   
	}

}
