package Tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;



public class PrimosPadre {
	 static File rutaEjecutableHijo = new File(".\\bin\\"); 
    public static void main(String[] args) {
        // Puedes habilitar esto si quieres pasar N y M como argumentos
        // if (args.length < 2) {
        //     System.out.println("Debes proporcionar los valores de N y M.");
        //     return;
        // }


        
        System.out.println(rutaEjecutableHijo.getAbsolutePath());
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);


        if (N < 0 || M >= 1000 || N > M) {
            System.out.println("Los valores de N y M no son válidos. N >= 0, M < 1000, y N <= M.");
            return;
        }

        try {

            ProcessBuilder pb = new ProcessBuilder("java", "Tema1.PrimosHijo", String.valueOf(N), String.valueOf(M));
            pb.redirectErrorStream(true);
            pb.directory(rutaEjecutableHijo);
            Process procesoHijo = pb.start();


            

            
            BufferedReader br = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            String linea;
            boolean hayPrimos = false;


            System.out.println("N: " + N);
            System.out.println("M: " + M);


            while ( (linea = br.readLine())  != null) {
                System.out.println(linea);
                hayPrimos = true;
            }

            if (!hayPrimos) {
                System.out.println("Ten primos 'pa' esto");
            }
            

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
