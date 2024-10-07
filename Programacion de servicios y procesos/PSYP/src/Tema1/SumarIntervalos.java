package Tema1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SumarIntervalos {

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

	            
	            int sum = 0;
	            for (int j = numMin; j <= numMax; j++) {
	                sum += j;
	            }

	            
	            String fileName = "fich" + i + ".txt";
	            GuardarArchivo(fileName, sum);

	            System.out.println("Intervalo " + i + ": " + numMin + " - " + numMax + " | Suma: " + sum);

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

	  
	    private static void GuardarArchivo(String fileNombre, int sum) {
	        try (FileWriter writer = new FileWriter(fileNombre)) {
	            writer.write("Suma del intervalo: " + sum);
	            System.out.println("Resultado guardado en " + fileNombre);
	        } catch (IOException e) {
	            System.out.println("Error al guardar el archivo " + fileNombre);
	            e.printStackTrace();
	        }

	}

}
