package clasesActuViajesCrearXML;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Principal {
	static Scanner teclado = new Scanner(System.in);

	static final int POSICION = 76;
	static final int POSICION1 = 48;
	static String viajes = "Viajes.dat";
	static String reservas = "Reservas.dat";
	static String archivo = "viajes.txt";

	static int lonviajes = 76;
	static int lonreservas = 48;

	public static void main(String[] args) throws IOException, JAXBException {
		try {
			int op = 0;
			do {
				System.out.println("............................................................\n"
						+ ".  1 Actualizar Viajes y Crear XML. \n" + ".  2 Visualizar Viajes  \n" + ".  0 SALIR.\n"
						+ "............................................................\n");
				System.out.println("TECLEA OPERACION: ");
				op = teclado.nextInt();
				switch (op) {
				case 1: // Actualizar el fichero Viajes.dat y Crear Viajes.xml
					actualizarViajesyCrearXML();
					break;
				case 2: // visualizar todo el fichero Viajes.dat de forma secuencial
					visualizarViajes();
					break;
				} // cierra Sub menu

			} while (op != 0);

		} catch (InputMismatchException e) {
			System.out.println("ERROR. LA OPCION DEBE SER NUMERICA.\n ");
		}

	}

	private static void actualizarViajesyCrearXML() throws IOException, JAXBException {
		File fichero = new File(viajes);
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		File fichero1 = new File(reservas);
		RandomAccessFile file1 = new RandomAccessFile(fichero1, "rw");
		Listaviajes listaviajes = new Listaviajes();
		System.out.println("CodViaje   Nombre                         PVP    PLAZAS    RESERVAS   IMPORTE   Situación");
		System.out
				.println("---------  --------------------------  -------  --------  ----------  --------  ----------");
		int codViaje, pvp, plazas, numreservas, codViaje1, plazas1, importe, ventasmax = 0;
		String mensajeString = "", maxString = "";
		char aux;
		for (int i = 0; i < file.length(); i += POSICION) {
			file.seek(i);
			codViaje = file.readInt();
			char nombre1[] = new char[30];
			for (int j = 0; j < nombre1.length; j++) {
				aux = file.readChar();
				nombre1[j] = aux;
			}
			String nombre = new String(nombre1).trim();
			pvp = file.readInt();
			plazas = file.readInt();
			int cont = 0, resta;
			for (int j = 0; j < file1.length(); j += POSICION1) {
				file1.seek(j);
				char nomcliente[] = new char[20];
				for (int z = 0; z < nomcliente.length; z++) {
					aux = file1.readChar();
					nomcliente[z] = aux;
				}
				String nomCliente = new String(nomcliente).trim();
				codViaje1 = file1.readInt();
				plazas1 = file1.readInt();
				if (codViaje == codViaje1) {
					cont += plazas1;
				}
			}
			numreservas = cont;
			importe = numreservas * pvp;
			resta = plazas - numreservas;
			if (resta < 0) {
				mensajeString = "Reservas excedidas en " + resta;
			} else {
				mensajeString = "Correcto";
			}
			if (ventasmax < numreservas) {
				ventasmax = numreservas;
				maxString = "Viaje con mas reservas: " + nombre;
			}

			if (codViaje != 0) {
				Viajes viaje = new Viajes(codViaje, nombre, pvp, plazas, numreservas, importe);
				viaje.toString();
				listaviajes.addViaje(viaje);
				System.out.printf("%-10d %-30s %-10d %-10d %-10d %-10d %-20s%n", codViaje, nombre, pvp, plazas,
						numreservas, importe, mensajeString);

				file.seek(i);
				file.writeInt(codViaje);
				for (int j = 0; j < 30; j++) {
					if (j < nombre.length()) {
						file.writeChar(nombre.charAt(j));
					} else {
						file.writeChar(' ');
					}
				}
				file.writeInt(pvp);
				file.writeInt(plazas);
				file.writeInt(numreservas);
				System.out.println("Reservas actualizadas");
			}
		}
		System.out
				.println("---------  --------------------------  -------  --------  ----------  --------  ----------");
		System.out.println(maxString);
		JAXBContext context = JAXBContext.newInstance(Listaviajes.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Escribir el archivo XML
		marshaller.marshal(listaviajes, new File("viajes.xml"));
		System.out.println("Archivo XML generado correctamente.");
	}

	public static void visualizarViajes() throws IOException {
		File fichero = new File(viajes);
		RandomAccessFile file = new RandomAccessFile(fichero, "r");

		System.out.println("CodViaje   Nombre                         PVP    PLAZAS    RESERVAS");
		System.out.println("---------  --------------------------  -------  --------  ----------");

		int codViaje, pvp, plazas, reservas;
		char aux;

		for (int i = 0; i < file.length(); i += POSICION) {
			file.seek(i);
			codViaje = file.readInt();
			char nombre1[] = new char[30];
			for (int j = 0; j < nombre1.length; j++) {
				aux = file.readChar();
				nombre1[j] = aux;
			}
			String nombre = new String(nombre1).trim();
			pvp = file.readInt();
			plazas = file.readInt();
			reservas = file.readInt();

			if (codViaje != 0) {
				System.out.printf("%-10d %-30s %-10d %-10d %-10d%n", codViaje, nombre, pvp, plazas, reservas);
			}
		}

		System.out.println("---------  --------------------------  -------  --------  ----------");

		file.close();
	}
}
