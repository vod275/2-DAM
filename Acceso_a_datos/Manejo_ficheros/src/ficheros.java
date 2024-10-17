import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ficheros {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int opcion = 0;
		
		
		switch (opcion) {
		case 1: {
			
			CrearArchivo();
			break;
			
		}
		case 2: {
			
				break;
			}
		case 3: {
			CrearArchivo3();
			break;
		}

	}
}
	
	private static void CrearArchivo() {
		File ficheroEjemplo = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.txt");
		try {
			if(ficheroEjemplo.createNewFile()) {
				
				System.out.println("ArchivoCreado " + ficheroEjemplo.getName());
				
			}else {
				
				System.out.println("El archivo ya existe");
			}
			
		}catch (Exception e) {
			
			System.out.println("Ocurrio un error");
			e.printStackTrace();
		}
	}
	
	
	private static void CrearArchivo3() {
		File direc = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.txt");
		
			if(direc.mkdir()) {
				
				System.out.println("ArchivoCreado " + direc.getPath());
				
			}else {
				
				System.out.println("El archivo ya existe o no se pudo crear");
			}
			File fichero3 = new File(direc, "fichero3.txt"); 
		try {
				if(fichero3.createNewFile()) {
					System.out.println("ArchivoCreado " + fichero3.getName());
				}else {
					System.out.println("El archivo ya existe");
				}
				
		}catch (Exception e) {
			
			System.out.println("Ocurrio un error");
			e.printStackTrace();
		}
	
	}
	
	private static void Verdir() {
		String dir = "C:\\Users\\Alumno\\eclipse-workspace\\Tema1";
		File f = new File(dir);
		String[] archivos = f.list();
		System.out.printf("Elementos en el directorio: %d %n", archivos.length);
		
		for (int i = 0; i < archivos.length; i++) {
			
			File f2 = new File(f, archivos[i]);
			
			if(f2.isFile()) {
				
				System.out.printf("Nombre: %s, es fichero %n", archivos[i]);
				
			}else {
				
				if(f2.isDirectory()) {
					
					System.out.printf("Nombre: %s, es directorio %n", archivos[i]);
					
				}		
			}			
		}
		
	}		
		
	private static void EscribirArchivo() {
			
		try(FileWriter fw = new FileWriter("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.txt")){
			
			fw.write("Hola Mundo! \n");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}		
	}
		
	
	private static void LeerArchivo() {
		
		try(FileReader fr = new FileReader("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.txt")){
			
			int charLeido;
			while((charLeido = fr.read())	!= -1) {
				System.out.print((char) charLeido);
			}
				
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}		
	}
	
	
	
	private static void LeerArchivoYcrearlo()  {
		
		 String rutaArchivo = "C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.txt";
	        File archivo = new File(rutaArchivo);

	        // Verificar si el archivo existe
	        if (!archivo.exists()) {
	            try {
	                // Crear el archivo si no existe
	                archivo.createNewFile();
	                
	                // Escribir algo en el archivo
	                try (FileWriter fw = new FileWriter(archivo)) {
	                    fw.write("Hola, este archivo ha sido creado porque no existía.\n");
	                }
	            } catch (IOException e) {
	                System.out.println("Error al crear el archivo: " + e.getMessage());
	            }
	        }
	       

	        // Leer el archivo
	        try (FileReader fr = new FileReader(archivo)) {
	            int charLeido;
	            while ((charLeido = fr.read()) != -1) {
	                System.out.print((char) charLeido);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }	
	}
		
		
		
		
		
	
}
