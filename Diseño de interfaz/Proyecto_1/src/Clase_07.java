
public class Clase_07 {

	public static void main(String[] args) {
		// lo mismo que el anterior pero con for
		

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
				 for (int i = 2; i <= Math.sqrt(numero); i++) {
			            if (numero % i == 0) {
			            	primo = false;  
			            }
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
