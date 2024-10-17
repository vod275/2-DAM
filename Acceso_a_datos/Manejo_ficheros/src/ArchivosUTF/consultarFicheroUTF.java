package ArchivosUTF;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class consultarFicheroUTF {

    public static void main(String[] args) throws IOException {

        File fichero = new File("C:\\Users\\Alumno\\eclipse-workspace\\holaBuenasUTF.dat"); 
        RandomAccessFile file = new RandomAccessFile(fichero, "r"); 
        int id, dep = 0; 
        Double salario; 

        // Aquí empieza la consulta
        int identificador = 7; 
        int posicion = (identificador - 1 ) * 36; // Calculo aproximado de la posición del registro

        if(posicion >= file.length()) {
            System.out.println("ID: " + identificador + ", NO EXISTE EMPLEADO...");
        } else {
            file.seek(posicion); // Nos posicionamos
            id = file.readInt(); // Obtengo ID del empleado

            if (id == identificador) {
                // Obtener el resto de los datos
                String apellidoS = file.readUTF(); 
                dep = file.readInt(); 
                salario = file.readDouble();

                System.out.println("ID: " + id + ", Apellido: " + apellidoS  
                        + ", Departamento: " + dep + ", Salario: " + salario);
            } else {
                System.out.println("ID: " + identificador + ", NO EXISTE EMPLEADO...");
            }
        }

        file.close(); // Cerrar archivo
        // Aquí termina la consulta
    }
}
