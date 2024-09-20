import java.util.Scanner;

public class Clase_12 {

	public static void main(String[] args) {
		// Crea una aplicaciones que pida un dia de la semana y nos diga si es laboral o no. usa switch
		
		
		System.out.println("Dime un dia de la semana: ");
		Scanner scanner = new Scanner(System.in);
		String dia = scanner.next();
		
		switch (dia) {
			case "lunes", "martes", "miercoles", "jueves", "viernes":{
				System.out.println("Este dia es laboral");
				break;
			}
			case "sabado", "domingo":{
				System.out.println("Este dia es festivo");
				break;
			}
		}
	}
}


