import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) throws IOException {
		 
		mostrarNotas("notas.dat", "alumnos.dat", "asignaturas.dat");
	}

	
	 public static void mostrarNotas(String notasFile, String alumnosFile, String asignaturasFile) throws IOException {
	        RandomAccessFile archivo = new RandomAccessFile(notasFile, "r");

	        System.out.printf("%-10s %-20s %-10s %-20s %-10s\n", "COD ALUM", "NOMBRE ALUM", "COD ASIG", "NOMBRE ASIG", "NOTA");
	        System.out.println("---------------------------------------------------------------------");

	        while (archivo.getFilePointer() < archivo.length()) {
	            int codAlumno = archivo.readInt();
	            int codAsignatura = archivo.readInt();
	            float nota = archivo.readFloat();

	            String nombreAlumno = LeerAlumno(alumnosFile, codAlumno);
	            String nombreAsignatura = LeerAsignatura(asignaturasFile, codAsignatura);

	            System.out.printf("%-10d %-20s %-10d %-20s %-10.2f\n", codAlumno, nombreAlumno, codAsignatura, nombreAsignatura, nota);
	        }

	        archivo.close();
	    }
	 
	 
	 public static String LeerAlumno(String alumnosFile, int codAlumno) throws IOException {
	        RandomAccessFile alumnos = new RandomAccessFile(alumnosFile, "r");

	        while (alumnos.getFilePointer() < alumnos.length()) {
	            int codigo = alumnos.readInt();
	           
	            
	            char[] nombreAlumnoChars = new char[20];
	            for (int i = 0; i < nombreAlumnoChars.length; i++) {
	            	nombreAlumnoChars[i] = alumnos.readChar();
	            }
	            String nombreAlumnos = new String(nombreAlumnoChars).trim();
	            
	            
	            // Leer y descartar el curso (10 caracteres)
	            for (int i = 0; i < 10; i++) {
	                alumnos.readChar(); // leer 10 chars para el curso y descartar
	            }

	            // Leer y descartar la nota media (float)
	            alumnos.readFloat(); // leer float para la nota media y descartar

	            if (codigo == codAlumno) {
	                alumnos.close();
	                return nombreAlumnos;
	            }
	        }

	        alumnos.close();
	        return "SIN ALUMNO";
	    }
	 
	 public static String LeerAsignatura(String asignaturasFile, int codAsignatura) throws IOException {
	        RandomAccessFile asignaturas = new RandomAccessFile(asignaturasFile, "r");

	        while (asignaturas.getFilePointer() < asignaturas.length()) {
	            int codigo = asignaturas.readInt();
	            
	            
	            char[] nombreAsignaturaChars = new char[15];
	            for (int i = 0; i < nombreAsignaturaChars.length; i++) {
	            	nombreAsignaturaChars[i] = asignaturas.readChar();
	            }
	            String nombreAsignaturas = new String(nombreAsignaturaChars).trim();
	            
	          
	            asignaturas.readInt(); 

	           
	            asignaturas.readFloat(); 
	         

	            if (codigo == codAsignatura) {
	                asignaturas.close();
	                return nombreAsignaturas;
	            }
	        }

	        asignaturas.close();
	        return "SIN ASIGNATURA";
	    }
	 
	
}
