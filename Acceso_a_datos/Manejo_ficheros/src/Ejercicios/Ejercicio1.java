package Ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		  Scanner scanner = new Scanner(System.in);
		 
		 
		  

		
		int opcion;
		do {
			  dibujaMenu(); // Muestra el menú al usuario
			    System.out.print("Seleccione una opción: ");

			    opcion = scanner.nextInt(); // Lee la opción
			    scanner.nextLine(); // Limpiar el buffer

			    switch (opcion) {
			        case 1: {
			            crearFichero();
			            break;
			        }
			        case 2: {
			            insertarRegistro();
			            break;
			        }
			        case 3: {
			            visualizaRegistro();
			            break;
			        }
			        case 4: {
			            int COD_DEP = pedirdepartamento();
			            if (consultaRegistro(COD_DEP)) {
			                System.out.print("Teclea la localidad: ");
			                String LOCALIDAD = scanner.nextLine(); // Cambié a nextLine
			                System.out.print("Teclea la media de salario del departamento: ");
			                float MEDIA_SALARIO_DEP = scanner.nextFloat();
			                scanner.nextLine(); // Limpiar el buffer
			                modificarRegistro(COD_DEP, LOCALIDAD, MEDIA_SALARIO_DEP);
			            }
			            break;
			        }
			        case 5: {
			            int numDep = pedirdepartamento();
			            if (consultaRegistro(numDep)) {
			                borrarRegistro(numDep);
			            }
			            break;
			        }
			        case 6: {
			            System.out.println("Saliendo del programa...");
			            break;
			        }
			        default: {
			            System.out.println("Opción no válida. Por favor, seleccione de nuevo.");
			            break; // Importante para evitar que se ejecute el siguiente caso por accidente
			        }
			    }

		
		} while(opcion  != 6);
	}
	
	
	
	private static void dibujaMenu() {
		 System.out.println("\n--- Menú de opciones ---");
         System.out.println("1. Crear un fichero");
         System.out.println("2. Insertar un Registro");
         System.out.println("3. Visualizar Registro");
         System.out.println("4. Modificar Registro");
         System.out.println("5. Borrar Registro");
         System.out.println("6. Salir");
	}
	
	
	public static void crearFichero()  throws IOException {
		
		File fichero = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.dat"); 
		   

	        try {
	        	RandomAccessFile file = new RandomAccessFile(fichero, "rw"); 

	        	int COD_DEP[] = {1, 2, 3, 4, 5, 6, 7};
	        	int NUME_EMPLEADOS[] = {10, 20, 10, 10, 30, 30, 20};       
    			//departamentos 
	        	String NOMBRE[] = {"VICTOR","GIL","GENTIX","IRENE", 
	        			"PEDRO","PILAR", "JOAQUIN"}; //apellidos  
	        	
	        	String LOCALIDAD[] = {"CIUDAD REAL", "CIUDAD REAL", "MADRID", "ALMADEN", "MIGUELTURRA", "MADRID", "DUBLIN"};
	        	
	        	float MEDIA_SALARIO_DEP[]={1000, 2400, 3000, 1500,  
	        			2200, 1435, 2000};//salarios 
	        	StringBuffer buffer = null;//buffer para almacenar nombre y localidad 
	          
	        	int n = NOMBRE.length;//numero de elementos del array 

	            for (int i=0;i<n; i++){ //recorro los arrays              
	 			   file.writeInt(i+1); //uso i+1 para identificar empleado 
	 		        
	 		       buffer = new StringBuffer(NOMBRE[i] );       
	 		       buffer.setLength(15); //15 caracteres para el nombre 
	 		       file.writeChars(buffer.toString());//insertar nombre 
	 		      
	 		       buffer = new StringBuffer(LOCALIDAD[i] );       
	 		       buffer.setLength(15); //15 caracteres para el localidad 
	 		       file.writeChars(buffer.toString());//insertar localidad 
	 		 
	 		       file.writeInt(COD_DEP[i]);       //insertar departamento 
	 		       file.writeDouble(MEDIA_SALARIO_DEP[i]);//insertar salario 
	 		       file.writeInt(NUME_EMPLEADOS[i]);
	 		    }   
	            
	 		   		file.close();  //cerrar fichero  
	 		   

	            System.out.println("Fichero agregado correctamente.");

	        } catch (IOException e) {
	            System.out.println("Ocurrió un error al escribir en el archivo.");
	            e.printStackTrace();
	        } 
	        
		
	}
	
	
	
	
	
	
	
	public static boolean consultaRegistro(int COD_DEP) throws IOException { 
		  
	    
		 File fichero = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.dat"); 

	        // Verificar si el archivo existe
		 if (!fichero.exists()) {
		        System.out.println("DEPARTAMENTO NO EXISTE");
		        return false;
		 }
		 else
			 
	     {
		        RandomAccessFile file = new RandomAccessFile(fichero, "r");

		     
		    
		  
		    
			    // Calcular el tamaño del registro y la posición
			    int tamRegistro = 4 + (15 * 2) + (15 * 2) + 4 + 8 + 4; // tamaño de cada registro en bytes
			    long pos = (COD_DEP - 1) * tamRegistro; // posición del registro a consultar
	
			   
			    // Verificar si la posición del registro es válida dentro del archivo
		        if (pos >= file.length()) {
		            file.close();
		            return false;
		        }
	
		        // Posicionar el puntero en el archivo
		        file.seek(pos);
	
		        // Leer el código de departamento
		        int ID = file.readInt();
		        file.close();
	
		        // Verificar si el ID leído coincide con el COD_DEP
		        if (ID == COD_DEP) {
		            System.out.println("DEPARTAMENTO SÍ EXISTE");
		            return true;
		        } else {
		            System.out.println("DEPARTAMENTO NO EXISTE");
		            return false;
		        }
	        
	       }



	}
	
	public static void insertarRegistro() throws IOException{
		 Scanner scanner = new Scanner(System.in);
		 
		File fichero = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.dat"); 
		//declara el fichero de acceso aleatorio 
		RandomAccessFile file = new RandomAccessFile(fichero, "rw"); 
		
		
		System.out.println("Dime el numero del departamento: ");
		int COD_DEP = scanner.nextInt();
		
		
		System.out.println("Dime el numero del Numero de empleados: ");
		int NUME_EMPLEADOS = scanner.nextInt();
		
		System.out.println("Dime el Nombre: ");
		String NOMBRE = scanner.next();
		
		System.out.println("Dime la localidad: ");
		String LOCALIDAD = scanner.next();
		
		System.out.println("Dime la media de salario: ");
		float MEDIA_SALARIO_DEP = scanner.nextFloat();
		
		
	 	StringBuffer buffer = null;//buffer para almacenar nombre y localidad 
		
		 
	        
	       buffer = new StringBuffer(NOMBRE);       
	       buffer.setLength(15); //15 caracteres para el nombre 
	       file.writeChars(buffer.toString());//insertar nombre 
	      
	       buffer = new StringBuffer(LOCALIDAD);       
	       buffer.setLength(15); //15 caracteres para el localidad 
	       file.writeChars(buffer.toString());//insertar localidad 
	 
	       file.writeInt(COD_DEP);       //insertar departamento 
	       file.writeDouble(MEDIA_SALARIO_DEP);//insertar salario 
	       file.writeInt(NUME_EMPLEADOS);
		
	       file.close();  //cerrar fichero  
 		   

           System.out.println("Registro agregado correctamente.");
	
				 scanner.close();
	}
	
	public static void visualizaRegistro() throws IOException { 
		 Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Introduce el número del departamento que deseas visualizar: ");
	        int numd = scanner.nextInt();
	        
	        if (consultaRegistro(numd)) {
	           
	            
	            File fichero = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.dat");
	            RandomAccessFile file = new RandomAccessFile(fichero, "r");

	            // Calcular el tamaño del registro y la posición en su lugar
	            int tamRegistro = 4 + (15 * 2) + (15 * 2) + 4 + 8 + 4;
	            long pos = (numd - 1) * tamRegistro;

	            // Posicionar el puntero en el archivo
	            file.seek(pos);

	            // Leer los datos del registro
	            int ID = file.readInt();

	            char[] nombreChars = new char[15];
	            for (int i = 0; i < nombreChars.length; i++) {
	                nombreChars[i] = file.readChar();
	            }
	            String NOMBRE = new String(nombreChars).trim();

	            char[] localidadChars = new char[15];
	            for (int i = 0; i < localidadChars.length; i++) {
	                localidadChars[i] = file.readChar();
	            }
	            String LOCALIDAD = new String(localidadChars).trim();

	            int COD_DEP = file.readInt();
	            double MEDIA_SALARIO_DEP = file.readDouble();
	            int NUME_EMPLEADOS = file.readInt();

	            // Mostrar la información del registro
	            System.out.println("Código de Departamento: " + COD_DEP);
	            System.out.println("Nombre: " + NOMBRE);
	            System.out.println("Localidad: " + LOCALIDAD);
	            System.out.println("Salario Medio: " + MEDIA_SALARIO_DEP);
	            System.out.println("Número de Empleados: " + NUME_EMPLEADOS);

	            // Cerrar el archivo
	            file.close();
	            
	        } 
	        scanner.close();
    }

   
	
	
	
	public static void modificarRegistro(int COD_DEP, String LOCALIDAD, float MEDIA_SALARIO_DEP) throws IOException { 
		 
		 File fichero = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.dat");
		    RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		    
		    int tamRegistro = 4 + (15 * 2) + (15 * 2) + 4 + 8 + 4; 
		    long pos = (COD_DEP - 1) * tamRegistro; 
		    file.seek(pos);
  
		    file.readInt();
		    
		    for (int i = 0; i < 15; i++) {
		        file.readChar();
		    }
		    
		    // Escribir la nueva localidad
		    StringBuffer buffer = new StringBuffer(LOCALIDAD);
		    buffer.setLength(15); // Asegurarse de que tiene 15 caracteres
		    file.writeChars(buffer.toString());
		    
		    // Saltar el departamento (4 bytes)
		    file.readInt();
		    
		    // Escribir la nueva media salarial
		    file.writeDouble(MEDIA_SALARIO_DEP);
		    
		    System.out.println("---------------------------------------------------------");
		    System.out.println("------------ DEPARTAMENTO MODIFICADO  " + COD_DEP + " -----------------");
		    file.close();
	   	 
	}
		
		

	
	
	
	public static void borrarRegistro(int COD_DEP) throws IOException { 
		 
		File fichero = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.dat");
		RandomAccessFile file;
		
		try {
			file = new RandomAccessFile(fichero, "rw");
			int tamRegistro = 4 + (15 * 2) + (15 * 2) + 4 + 8 + 4;
			int pos;
			pos=(COD_DEP-1)*tamRegistro;
			file.seek(pos);
			file.writeInt(0);
			String nombreD = "               ";
			StringBuffer buffer = new StringBuffer(nombreD);
			buffer.setLength(15);
			file.writeChars(buffer.toString());
			String localidadD = "               ";
			buffer = new StringBuffer(localidadD);
			buffer.setLength(15);
			file.writeChars(buffer.toString());
			file.writeInt(0);
			file.writeFloat(0f);
			System.out.println("---------------------------------------------------------");
			System.out.println("------------ DEPARTAMENTO BORRADO  " + COD_DEP + " -----------------");
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println(" ERROR NO ENCONTRADO EL FICHERO. ");
		} catch (IOException e) {
			System.out.println("ERROR DE E/S ");
		}
		
		

	}
	
	
	public static int pedirdepartamento() throws IOException {
		Scanner scanner = new Scanner(System.in);
		int numeroD;
		do {
			System.out.println(" Teclea el numero de departamento (entre 1 y 100): ");
			try {
				numeroD = scanner.nextInt();
			} catch (InputMismatchException e) {
				numeroD = -1;
				System.out.println("El departamento debe ser numerico.\n ");
			}
			scanner.nextLine();
		} while ((numeroD > 100) || (numeroD < 1));

		return numeroD;
	}// fin pedirdepartamento
	
	
	

}
