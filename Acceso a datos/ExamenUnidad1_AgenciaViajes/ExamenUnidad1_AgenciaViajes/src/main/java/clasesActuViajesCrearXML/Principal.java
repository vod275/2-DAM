package clasesActuViajesCrearXML;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Principal {
	static Scanner teclado = new Scanner(System.in);

	static String viajesfile = "./Viajes.dat";
	static String reservasfile = "./Reservas.dat";

	static int lonviajes = 76;
	static int lonreservas = 48;

	public static void main(String[] args) throws IOException {
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

	private static void actualizarViajesyCrearXML() {

		File ficheroViajes = new File(viajesfile);
		File ficheroReservas = new File(reservasfile);

		try {

			ArrayList<Viajes> listaViajes = new ArrayList<>();
			try (RandomAccessFile file = new RandomAccessFile(ficheroViajes, "rw")) {
				while (file.getFilePointer() < file.length()) {
					Viajes viaje = new Viajes();

					viaje.setCodviaje(file.readInt());
					byte[] nombreBytes = new byte[20];
					file.read(nombreBytes);
					viaje.setNombre(new String(nombreBytes).trim());
					viaje.setPvp(file.readInt());
					viaje.setNumplazas(file.readInt());
					viaje.setNumreservas(file.readInt());
					viaje.setTotalimporte(file.readInt());

					listaViajes.add(viaje);
				}
			} catch (IOException e) {
				System.err.println("Error al leer Viajes.dat: " + e.getMessage());
			}

			for (Viajes viaje : listaViajes) {
				int totalReservas = 0;
				int totalImporte = 0;

				try (RandomAccessFile rafReservas = new RandomAccessFile(ficheroReservas, "r")) {
					while (rafReservas.getFilePointer() < rafReservas.length()) {
						Reservas reserva = new Reservas();

						int codViajeReserva = rafReservas.readInt();
						if (codViajeReserva == viaje.getCodviaje()) {
							int cantidadReserva = rafReservas.readInt();
							totalReservas += cantidadReserva;
						} else {
							rafReservas.skipBytes(lonreservas - 8);
						}
					}
				} catch (IOException e) {
					System.err.println("Error al leer Reservas.dat: " + e.getMessage());
				}

				totalImporte = totalReservas * viaje.getPvp();

				viaje.setNumreservas(totalReservas);
				viaje.setTotalimporte(totalImporte);
			}

			try {
				JAXBContext context = JAXBContext.newInstance(Listaviajes.class);
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

				Listaviajes listaViajesWrapper = new Listaviajes();
				listaViajesWrapper.setLista(listaViajes);

				marshaller.marshal(listaViajesWrapper, new File("viajes.xml"));
				System.out.println("Archivo ViajesActualizados.xml creado correctamente.");

			} catch (JAXBException e) {
				System.err.println("Error al crear el archivo XML: " + e.getMessage());
			}

		} catch (Exception e) {
			System.err.println("Error general: " + e.getMessage());
		}

	}

	public static void visualizarViajes() throws IOException {
		try (RandomAccessFile fileViajes = new RandomAccessFile("Viajes.dat", "rw");
				RandomAccessFile fileReservas = new RandomAccessFile("Reservas.dat", "r")) {

			System.out.printf("%-10s %-30s %-10s %-10s %-10s %-10s%n", "CODVIAJE", "NOMBRE", "PVP", "PLAZAS",
					"RESERVAS", "IMPORTE TOTAL");
			System.out.println(
					"------------------------------------------------------------------------------------------");

			while (fileViajes.getFilePointer() < fileViajes.length()) {
				int codViaje = fileViajes.readInt();
				char[] nombreChars = new char[30];
				for (int i = 0; i < nombreChars.length; i++) {
					nombreChars[i] = fileViajes.readChar();
				}
				String nombre = new String(nombreChars).trim();

				int pvp = fileViajes.readInt();
				int numplazas = fileViajes.readInt();
				int numreservas = 0;
				float totalImporte = 0;

				
				fileReservas.seek(0);
				while (fileReservas.getFilePointer() < fileReservas.length()) {
					int codViajeReserva = fileReservas.readInt();
					char[] clienteChars = new char[20];
					for (int i = 0; i < clienteChars.length; i++) {
						clienteChars[i] = fileReservas.readChar();
					}
					String nombreCliente = new String(clienteChars).trim();
					int plazasReservadas = fileReservas.readInt();

					// Verifica si la reserva pertenece al viaje actual
					if (codViajeReserva == codViaje) {
						numreservas += plazasReservadas;
						totalImporte += plazasReservadas * pvp; 
					}
				}

				// Muestra la información del viaje
				System.out.printf("%-10d %-30s %-10d %-10d %-10d %-10.2f%n", codViaje, nombre, pvp, numplazas,
						numreservas, totalImporte);

				// Actualiza el registro de viajes
				long currentPos = fileViajes.getFilePointer();
				fileViajes.seek(currentPos - 8); 
				fileViajes.writeInt(numreservas); 
				fileViajes.writeFloat(totalImporte); 
			}

		} catch (EOFException e) {
			System.out.println("Se alcanzó el final del archivo.");
		}
	}
}
