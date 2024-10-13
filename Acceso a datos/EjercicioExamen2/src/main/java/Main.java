import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.bind.JAXBException;

public class Main {

	public static void main(String[] args) {

		try {
			Empresas empresas = LeerXML.leerEmpresasXML(
					"D:\\Usuario\\Documents\\GitHub\\2-DAM\\Acceso a datos\\EjercicioExamen2\\empresas.xml");

			try (RandomAccessFile archivo = new RandomAccessFile("Empresas.dat", "rw")) {
				for (Empresa empresa : empresas.getEmpresa()) {
					ActualizadorEmpresas.actualizarEmpresa(archivo, empresa);
				}
			}

			mostrarFicheroActualizado();

		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void mostrarFicheroActualizado() throws IOException {
	    try (RandomAccessFile archivo = new RandomAccessFile("Empresas.dat", "r")) {

	        // Imprimir encabezados
	        System.out.printf("%-10s %-30s %-30s %-10s %-10s %-30s%n", "CÓDIGO", "NOMBRE", "DIRECCIÓN", "EMPLEADOS", "SALARIO", "DIRECTOR");
	        System.out.println("-------------------------------------------------------------------------------------------------------------");

	        while (archivo.getFilePointer() < archivo.length()) { // Verifica si hay más datos por leer

	            int codigo = archivo.readInt();

	            char[] nombreChars = new char[30];
	            for (int i = 0; i < nombreChars.length; i++) {
	                nombreChars[i] = archivo.readChar();
	            }
	            String nombre = new String(nombreChars).trim();

	            char[] direccionChars = new char[30];
	            for (int i = 0; i < direccionChars.length; i++) {
	                direccionChars[i] = archivo.readChar();
	            }
	            String direccion = new String(direccionChars).trim();

	            int numEmpleados = archivo.readInt();

	            float mediaSalario = archivo.readFloat();

	            char[] nombreDirectorChars = new char[30];
	            for (int i = 0; i < nombreDirectorChars.length; i++) {
	                nombreDirectorChars[i] = archivo.readChar();
	            }
	            String nombreDirector = new String(nombreDirectorChars).trim();

	            // Imprimir los datos de cada empresa
	            System.out.printf("%-10d %-30s %-30s %-10d %-10.2f %-30s%n", codigo, nombre, direccion, numEmpleados, mediaSalario, nombreDirector);
	        }

	    } catch (EOFException e) {
	        System.out.println("Se alcanzó el final del archivo.");
	    }
	}


}
