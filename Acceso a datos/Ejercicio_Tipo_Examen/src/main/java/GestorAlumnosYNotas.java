import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GestorAlumnosYNotas {

    public static void actualizarAlumnos() throws IOException {
        String rutaAlumnos = "C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso a datos\\Ejercicio_Tipo_Examen\\src\\main\\resources\\Alumnos.dat";
        String rutaNotas = "C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso a datos\\Ejercicio_Tipo_Examen\\src\\main\\resources\\Notas.dat";

        File ficheroAlumnos = new File(rutaAlumnos);
        File ficheroNotas = new File(rutaNotas);

        RandomAccessFile fileAlumnos = new RandomAccessFile(ficheroAlumnos, "rw");
        RandomAccessFile fileNotas = new RandomAccessFile(ficheroNotas, "r");

        int cod, num_asig, cont;
        double suma;
        char aux;
        float media;

        // Imprimir encabezados
        System.out.printf("%-10s %-20s %-20s %-10s %-10s%n", "NUMALUM", "NOMBRE", "LOCALIDAD", "NUMASIG", "NOTA MEDIA");
        System.out.println("--------------------------------------------------------------");

        // Recorremos el archivo de alumnos
        for (int pos = 0; pos < fileAlumnos.length(); pos += 92) {
            fileAlumnos.seek(pos);
            cod = fileAlumnos.readInt(); // Leer código de alumno

            // Leer el nombre del alumno
            char[] nombreChars = new char[20];
            for (int i = 0; i < nombreChars.length; i++) {
                nombreChars[i] = fileAlumnos.readChar();
            }
            String nombre = new String(nombreChars).trim();

            // Leer la localidad del alumno
            char[] localidadChars = new char[20];
            for (int i = 0; i < localidadChars.length; i++) {
                localidadChars[i] = fileAlumnos.readChar();
            }
            String localidad = new String(localidadChars).trim();

            // Inicializamos contadores
            cont = 0;
            suma = 0.0;

            // Recorremos el archivo de notas para el alumno actual
            for (int posNotas = 0; posNotas < fileNotas.length(); posNotas += 48) {
                fileNotas.seek(posNotas);
                int codNota = fileNotas.readInt(); // Leer código de alumno en las notas

                // Leer la asignatura (no es necesario para el cálculo, pero seguimos el formato)
                char[] asignaturaChars = new char[20];
                for (int i = 0; i < asignaturaChars.length; i++) {
                    aux = fileNotas.readChar();
                    asignaturaChars[i] = aux;
                }

                float notaAsignatura = fileNotas.readFloat(); // Leer la nota

                // Si el código de la nota coincide con el código del alumno, acumulamos
                if (codNota == cod) {
                    cont++;
                    suma += notaAsignatura;
                }
            }

            // Calcular número de asignaturas y la media
            if (cont == 0) {
                num_asig = 0;
                media = 0;
            } else {
                num_asig = cont;
                media = (float) (suma / cont);
            }

            // Mostrar los datos del alumno con la nota media calculada
            System.out.printf("%-10d %-20s %-20s %-10d %-10.2f%n", cod, nombre, localidad, num_asig, media);

            // Volvemos a posicionar el puntero para actualizar la nota media en el fichero de alumnos
            fileAlumnos.seek(pos + 84); // Nos posicionamos justo en donde se guarda la nota media
            fileAlumnos.writeInt(num_asig); // Actualizamos el número de asignaturas
            fileAlumnos.writeFloat(media); // Actualizamos la nota media
        }

        // Cerramos los ficheros
        fileAlumnos.close();
        fileNotas.close();
    }
}

