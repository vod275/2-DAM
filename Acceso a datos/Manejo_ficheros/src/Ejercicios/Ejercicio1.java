package Ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		  Scanner scanner = new Scanner(System.in);
		 
		  System.out.println("\n--- Menú de opciones ---");
          System.out.println("1. Crear un fichero");
          System.out.println("2. Consultar un registro");
          System.out.println("3. Insertar un Registro");
          System.out.println("4. Visualizar Registro");
          System.out.println("5. Modificar Registro");
          System.out.println("6. Borrar Registro");
          System.out.println("7. Salir");
          System.out.print("Seleccione una opción: ");
          int opcion = scanner.nextInt();
          
         
		
		
		
		
		switch (opcion) {
			case 1: {
			
				crearFichero();
				break;
			
			}
			case 2: {
				consultaRegistro(8);
				break;
			}
			
			case 3: {
				insertarRegistro();
				break;
			}
			case 4: {
				visualizaRegistro();;
				break;
			}
		
			case 5: {
				modificarRegistro();
				break;
			}
		
			case 6: {
				borrarRegistro();
				break;
			}
		
			case 7: {
				System.out.println("Saliendo del programa...");
				break;
			}



		}
		
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
	 		   

	            System.out.println("Registro agregado correctamente.");

	        } catch (IOException e) {
	            System.out.println("Ocurrió un error al escribir en el archivo.");
	            e.printStackTrace();
	        } 
	        
		
	}
	
	
	
	
	
	
	
	public static boolean consultaRegistro(int numd) throws IOException { 
		  
	    
		 File fichero = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenas.dat"); 

	        // Verificar si el archivo existe
	        if (!fichero.exists()) {
	        	 System.out.println("DEPARTAMENTO NO EXISTE");
	            return false;
	        }
	        else
	        {
	        	 System.out.println("DEPARTAMENTO SÍ EXISTE");
		        RandomAccessFile file = new RandomAccessFile(fichero, "r");

		     
		    
		  
		    
		    // Calcular el tamaño del registro y la posición
		    int tamRegistro = 4 + (15 * 2) + (15 * 2) + 4 + 8 + 4; // tamaño de cada registro en bytes
		    long pos = (numd - 1) * tamRegistro; // posición del registro a consultar

		   
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

	        // Si el ID es 0, significa que el registro es un hueco
	        return ID != 0;
	        	
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

	            // Calcular el tamaño del registro y la posición
	            int tamRegistro = 72;
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
	            
	        } else {
	            System.out.println("DEPARTAMENTO NO EXISTE");
	        }

	        scanner.close();
    }

   
	
	
	
	public static void modificarRegistro() throws IOException { 
		 
		
		
		

	}
	
	
	public static void borrarRegistro() throws IOException { 
		 
		
		
		

	}
	
	
	

}
