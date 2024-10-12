package Tema1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContarVocales {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Debe proporcionar: archivo de texto, vocal a buscar, y archivo de resultado.");
            return;
        }

        String archivoTexto = args[0];
        char vocal = args[1].toLowerCase().charAt(0);
        String archivoResultado = args[2];
        int conteo = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {
            int c;
            while ((c = br.read()) != -1) {
            	
                // Convertir a minúscula y verificar si es la vocal buscada
                if (Character.toLowerCase((char) c) == vocal) {
                    conteo++;
                }
            }

           
            try (FileWriter fw = new FileWriter(archivoResultado)) {
                fw.write("La vocal '" + vocal + "' aparece " + conteo + " veces.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
