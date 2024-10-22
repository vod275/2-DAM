package Tema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class PadrePipe {

	 public static void main(String[] args) {
	        if (args.length < 3) {
	            System.out.println("Error: Se requieren al menos dos comandos y un archivo.");
	            System.out.println("Ejemplo: cat miLista.txt | wc -l -c");
	            System.exit(1);
	        }

	        // Extraer el primer comando antes de la pipe '|'
	        List<String> comando1 = new ArrayList<>();
	        int indicePipe = 0;
	        while (indicePipe < args.length && !args[indicePipe].equals("|")) {
	            comando1.add(args[indicePipe]);
	            indicePipe++;
	        }

	        // Validar la existencia de la pipe
	        if (indicePipe == args.length || !args[indicePipe].equals("|")) {
	            System.out.println("Error: Falta la pipe '|'.");
	            System.exit(1);
	        }

	        // Extraer el segundo comando después de la pipe '|'
	        List<String> comando2 = new ArrayList<>();
	        indicePipe++; // Saltamos la pipe
	        while (indicePipe < args.length) {
	            comando2.add(args[indicePipe]);
	            indicePipe++;
	        }

	        // Verificar si el archivo especificado existe
	        if (comando1.size() > 1) {
	            String archivoEntrada = comando1.get(1); // El archivo debería estar en la segunda posición
	            verificarArchivo(archivoEntrada);
	        }

	        // Ajustar comandos si estamos en Windows
	        if (esSistemaWindows()) {
	            if (comando1.get(0).equals("cat")) {
	                comando1 = new ArrayList<>();
	                comando1.add("cmd.exe");
	                comando1.add("/c");
	                comando1.add("type " + comando1.get(1));
	            }
	            if (comando2.get(0).equals("wc")) {
	                comando2 = new ArrayList<>();
	                comando2.add("powershell");
	                comando2.add("-Command");
	                comando2.add("Get-Content " + comando1.get(1) + " | Measure-Object -Line -Character");
	            }
	        }

	        try {
	            // Crear el primer proceso hijo
	        	HijoPipe ph1 = new HijoPipe(comando1);
	            Process proceso1 = ph1.iniciarProceso();

	            // Crear el segundo proceso hijo
	            HijoPipe ph2 = new HijoPipe(comando2);
	            Process proceso2 = ph2.iniciarProceso();

	            // Conectar la salida del primer proceso a la entrada del segundo
	            OutputStream osPH2 = proceso2.getOutputStream();
	            InputStream isPH1 = proceso1.getInputStream();

	            // Redirigir la salida de PH1 a PH2
	            byte[] buffer = new byte[1024];
	            int bytesLeidos;
	            while ((bytesLeidos = isPH1.read(buffer)) != -1) {
	                osPH2.write(buffer, 0, bytesLeidos);
	            }
	            osPH2.close(); // Importante: cerrar el stream para que PH2 continúe

	            // Mostrar la salida del segundo proceso
	            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                System.out.println(linea);
	            }

	            // Esperar a que los procesos terminen
	            proceso1.waitFor();
	            proceso2.waitFor();

	            System.out.println("Los procesos finalizaron exitosamente.");

	        } catch (IOException | InterruptedException e) {
	            System.out.println("Error al ejecutar los procesos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    // Verifica la existencia del archivo y lo crea si no existe
	    private static void verificarArchivo(String nombreArchivo) {
	        File archivo = new File(nombreArchivo);

	        if (!archivo.exists()) {
	            System.out.println("El archivo " + nombreArchivo + " no existe. Creando archivo...");
	            try {
	                if (archivo.createNewFile()) {
	                    System.out.println("Archivo " + nombreArchivo + " creado exitosamente.");
	                    // Opcional: agregar contenido predeterminado al archivo
	                    agregarContenidoPredeterminado(archivo);
	                } else {
	                    System.out.println("No se pudo crear el archivo " + nombreArchivo);
	                }
	            } catch (IOException e) {
	                System.out.println("Error al crear el archivo: " + e.getMessage());
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("El archivo " + nombreArchivo + " ya existe.");
	        }
	    }

	    // Método para agregar contenido predeterminado al archivo (opcional)
	    private static void agregarContenidoPredeterminado(File archivo) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
	            // Escribe el contenido predeterminado aquí, si es necesario
	            writer.write("Contenido de ejemplo en el archivo.\n");
	            writer.write("Modifícalo como desees.\n");
	            System.out.println("Contenido predeterminado agregado al archivo.");
	        } catch (IOException e) {
	            System.out.println("Error al escribir en el archivo: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    // Método para detectar si el sistema operativo es Windows
	    private static boolean esSistemaWindows() {
	        return System.getProperty("os.name").toLowerCase().contains("win");
	    }
}