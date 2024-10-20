package Tema1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class PrimosPadre {

    public static void main(String[] args) {
       // if (args.length < 2) {
         //   System.out.println("Debes proporcionar los valores de N y M.");
           // return;
        //}

        String rutaEjecutableHijo = "D:\\Usuario\\Documents\\GitHub\\2-DAM\\Programacion de servicios y procesos\\PSYP\\bin";  
        int N = 3;
        int M = 10;

        if (N < 0 || M >= 1000 || N > M) {
            System.out.println("Los valores de N y M no son válidos. N >= 0, M < 1000, y N <= M.");
            return;
        }

        try {
         
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", rutaEjecutableHijo, "Tema1.PrimosHijo");
            Process procesoHijo = pb.start();

     
            OutputStream os = procesoHijo.getOutputStream();
            os.write((N + " " + M + "\n").getBytes());
            os.flush();
            os.close();

  
            BufferedReader br = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            String linea;
            boolean hayPrimos = false;


            System.out.println("N: " + N);
            System.out.println("M: " + M);

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                hayPrimos = true;
            }

            if (!hayPrimos) {
                System.out.println("Ten primos 'pa' esto");
            }

            procesoHijo.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
