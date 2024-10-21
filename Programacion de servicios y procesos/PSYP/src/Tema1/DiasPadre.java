package Tema1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class DiasPadre {

    public static void main(String[] args) {

     
        String rutaArchivoFecha = "D:\\Usuario\\Documents\\GitHub\\2-DAM\\Programacion de servicios y procesos\\PSYP\\Fecha.txt";

        String fecha = null;


        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoFecha))) {
            fecha = br.readLine();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo Fecha.txt: " + e.getMessage());
            return;
        }


        if (fecha == null || fecha.trim().isEmpty()) {
            System.out.println("El archivo Fecha.txt está vacío o no contiene una fecha válida.");
            return;
        }

        try {

            String rutaEjecutableHijo = "D:\\Usuario\\Documents\\GitHub\\2-DAM\\Programacion de servicios y procesos\\PSYP\\bin";


            ProcessBuilder pb = new ProcessBuilder("java", "-cp", rutaEjecutableHijo, "Tema1.DiasHijo");
            Process procesoHijo = pb.start();


            OutputStream os = procesoHijo.getOutputStream();
            os.write((fecha + "\n").getBytes());
            os.flush();
            os.close();


            BufferedReader br = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            String resultado = br.readLine();

            System.out.println("Días restantes para ir a prácticas: " + resultado);

            procesoHijo.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
