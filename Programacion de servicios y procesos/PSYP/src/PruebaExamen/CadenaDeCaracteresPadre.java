package PruebaExamen;

import java.io.IOException;
import java.util.Scanner;

public class CadenaDeCaracteresPadre {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduzca una cadena: ");
        String cadena = scanner.nextLine(); 


        try {

            ProcessBuilder pb = new ProcessBuilder("java", "PruebaExamen.CadenaDeCaracteresHijo");
            pb.redirectErrorStream(true); 
            Process procesoHijo = pb.start();
            
          //BufferedReader reader = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            //String linea;
            //while ((linea = reader.readLine()) != null) {
              //  System.out.println(linea);
            //}
            
            int exitCode = procesoHijo.waitFor();
            switch (exitCode) {
                case 0:
                    System.out.println("La longitud es 0");
                    break;
                case 1:
                    System.out.println("La cadena del hijo no es un palíndromo");
                    break;
                case 2:
                    System.out.println("Es un palíndromo");
                    break;
                default:
                    System.out.println("Error Raro");
                    break;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
