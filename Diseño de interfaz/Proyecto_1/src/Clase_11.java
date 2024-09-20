import java.util.Iterator;
import java.util.Scanner;

public class Clase_11 {

	public static void main(String[] args) {
		// Escribe una aplicacion con un string  que contengs una contraseña con 3 intentos, cuando aciertes
		// ya no pedira mas la contraseña, y mostrara un mensaje diciendo enhorabuena, 
		// (3 intentos y si acierta sale aunque le queden intentos)
		
		int oportunidades = 3;
		
		for (int i = 1; i <= oportunidades; i++) {
		int solucion = 1234;
		
			System.out.println("Dime la contraseña: ");
			Scanner scanner = new Scanner(System.in);
			int contraseña = scanner.nextInt();
			
			if(solucion == contraseña)
			{
				System.out.println("Acertaste enhorabuena");
				break;
			}
		}
		

	}

}
