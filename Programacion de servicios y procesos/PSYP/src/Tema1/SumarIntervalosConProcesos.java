package Tema1;
import java.io.IOException;
import java.util.Scanner;

public class SumarIntervalosConProcesos  {

	public static void main(String[] args) {
		
		
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Introduce el número mínimo del rango: ");
	        int min = IntroduceNumeroValido(scanner);

	        System.out.print("Introduce el número máximo del rango: ");
	        int max = IntroduceNumeroValido(scanner);
	        while (max <= min) {
	            System.out.println("El número máximo debe ser mayor que el mínimo. Intenta de nuevo.");
	            max = IntroduceNumeroValido(scanner);
	        }

	        System.out.print("Introduce el número de intervalos: ");
	        int numIntervals = IntroduceNumeroValido(scanner);
	        while (numIntervals <= 0 || numIntervals > (max - min)) {
	            System.out.println("El número de intervalos debe ser mayor que 0 y menor o igual que la diferencia entre el máximo y el mínimo.");
	            numIntervals = IntroduceNumeroValido(scanner);
	        }

	        int intervalSize = (max - min + 1) / numIntervals;
	        int remainder = (max - min + 1) % numIntervals;

	        int numMin = min;

	        for (int i = 1; i <= numIntervals; i++) {
	            int numMax = numMin + intervalSize - 1;
	            if (i == numIntervals) { 
	                numMax += remainder;
	            }

	           
	            crearProceso(numMin, numMax, i);

	            numMin = numMax + 1;
	        }

	        scanner.close();
	    }

	    private static int IntroduceNumeroValido(Scanner scanner) {
	        while (!scanner.hasNextInt()) {
	            System.out.println("Por favor, introduce un número válido.");
	            scanner.next();
	        }
	        return scanner.nextInt();
	    }

	    private static void crearProceso(int numMin, int numMax, int intervalId) {
	        ProcessBuilder pb = new ProcessBuilder(
	                "java", "-cp", "C:\\Users\\Alumno\\Desktop\\2-DAM\\Programacion de servicios y procesos\\PSYP\\src", 
	                "Tema1.SumarIntervaloProceso", // Nombre completo de la clase
	                String.valueOf(numMin), 
	                String.valueOf(numMax), 
	                String.valueOf(intervalId)
	        );
	        pb.inheritIO(); // Para que el proceso hijo herede la salida del proceso padre

	        try {
	            Process process = pb.start();
	            process.waitFor(); // Esperar a que el proceso termine
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	    }


}
