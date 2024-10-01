import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class GestorNotas {
	private static final String FICHERO_NOTAS = "C:/Users/Alumno/Desktop/2-DAM/Acceso a datos/Ejercicio_Tipo_Examen/src/main/resources/Notas.dat";


    // Leer todas las notas del fichero Notas.dat
    public List<Nota> leerNotas() {
        List<Nota> notas = new ArrayList<>();
        File fichero = new File(FICHERO_NOTAS);

        try (RandomAccessFile file = new RandomAccessFile(fichero, "r")) {
            while (file.getFilePointer() < file.length()) {
                int codAlumno = file.readInt();
                int numAlumno = file.readInt();
                // Leer el nombre de la asignatura (20 caracteres)
                char[] nombreAsignaturaChars = new char[20];
                for (int i = 0; i < nombreAsignaturaChars.length; i++) {
                    nombreAsignaturaChars[i] = file.readChar();
                }
                String nombreAsignatura = new String(nombreAsignaturaChars).trim(); 

                float nota = file.readFloat(); // Leer la nota

                // Crear una nueva nota y añadirla a la lista
                notas.add(new Nota(codAlumno, numAlumno, nombreAsignatura, nota));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        // Mostrar informe de notas
        mostrarInformeNotas(notas);
        return notas;
    }

    private void mostrarInformeNotas(List<Nota> notas) {
        System.out.printf("%-6s %-10s %-20s %-5s%n", "REGIS", "NUMALUM", "ASIGNATURA", "NOTA");
        System.out.println("------------------------------------------");
        for (Nota nota : notas) {
            System.out.printf("%-6d %-10d %-20s %-5.1f%n", 
                nota.getCodAlumno(), 
                nota.getNumAlumno(), 
                nota.getNombreAsignatura(), 
                nota.getNotaAsignatura());
        }
        System.out.println("------------------------------------------");
    }
}