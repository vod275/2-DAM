package Tema1;

import java.io.FileWriter;
import java.io.IOException;

public class SumarIntervaloProceso {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso incorrecto. Se requieren 3 argumentos: numMin, numMax, intervalId.");
            return;
        }

        int numMin = Integer.parseInt(args[0]);
        int numMax = Integer.parseInt(args[1]);
        int intervalId = Integer.parseInt(args[2]);

        int sum = 0;
        for (int i = numMin; i <= numMax; i++) {
            sum += i;
        }

        String fileName = "fich" + intervalId + ".txt";
        guardarArchivo(fileName, sum);

        System.out.println("Proceso para intervalo " + intervalId + ": " + numMin + " - " + numMax + " | Suma: " + sum);
    }

    private static void guardarArchivo(String fileNombre, int sum) {
        try (FileWriter writer = new FileWriter(fileNombre)) {
            writer.write("Suma del intervalo: " + sum);
            System.out.println("Resultado guardado en " + fileNombre);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo " + fileNombre);
            e.printStackTrace();
        }
    }
}