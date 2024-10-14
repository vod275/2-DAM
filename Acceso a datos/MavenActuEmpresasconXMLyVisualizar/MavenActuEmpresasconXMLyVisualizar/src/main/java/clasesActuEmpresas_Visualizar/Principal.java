package clasesActuEmpresas_Visualizar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Principal {
	static Scanner teclado = new Scanner(System.in);
	
	static int LON = 192;
	static String ficherodirecto = "Empresas.dat";
	static String ficheroxml = "empresas.xml";

	public static void main(String[] args) throws IOException {
		try {
			int op = 0;
			do {
				System.out.println("............................................................\n"
						+ ".  1 Actualizar Empresas y Crear XML. \n" 
						+ ".  2 Visualizar Empresas (Directo)  \n" 
						+ ".  3 Crear Fichero de Empresas (Directo)  \n" 
						+ ".  0 SALIR.\n"
						+ "............................................................\n");
				System.out.println("TECLEA OPERACION: ");
				op = teclado.nextInt();
				switch (op) {
				case 1: // Actualizar el fichero Empresas.dat con los datos de empresas.xml
					cargarxmlyactualizar();
					break;
				case 2: // visualizar todo el fichero Empresas.dat de forma secuencial
					visualizarfichero(ficherodirecto);
					break;
				case 3: // visualizar todo el fichero Empresas.dat de forma secuencial
					crearfichero(ficherodirecto);					break;
				} // cierra Sub menu

			} while (op != 0);

		} catch (InputMismatchException e) {
			System.out.println("ERROR. LA OPCION DEBE SER NUMERICA.\n ");
		}

	}

	private static void cargarxmlyactualizar() {

		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Empresas.class);
			Unmarshaller unmars = context.createUnmarshaller();

			try {
				Empresas empre = (Empresas) unmars.unmarshal(new FileReader(ficheroxml));
				ArrayList<Empresa> lista = empre.getEmpresa();
				System.out.println("Numero de Empresas: " + lista.size());
				for (Empresa emp : lista) {
					// Sacamos la empresa
					int code = emp.getCodempre();
					String direccion = emp.getDireccion();
					String director = emp.getNuevodirector().getNombre();

					// sacamos los nuevos emples
					ArrayList<Emple> listaem = emp.getNuevosemples();
					int num = listaem.size();
					float totsal = 0;

					for (Emple eemp : listaem) {
						float sal = eemp.getSalario();
						totsal = totsal + sal;
					} // fin for
					float media = 0;
					if (num > 0) {
						media = totsal / num;
					}

					System.out.println("Datos leidos: ");
					System.out.println("Cod: " + code + ", direccion: " + direccion + ", director: " + director
							+ ", num emples = " + num + ", media: " + media);

					// Actualizar el directo
					actualizardirecto(code, direccion, num, director, media);

				}

			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	private static void actualizardirecto(int code, String direccion, int num, String director, float media) {

		File fichero = new File(ficherodirecto);
		System.out.println("--------------------------");
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			long posi = (code - 1) * LON;
			if (posi < file.length()) {
				file.seek(posi);
				int cod = file.readInt();
				if (cod == code) { // se actualiza

					// actualiza direccion
					file.seek(posi + 64);
					StringBuffer buffer = null;
					buffer = new StringBuffer(direccion);
					buffer.setLength(30);
					file.writeChars(buffer.toString());

					// Actualizo num emple, los leo y los sumo
					file.seek(posi + 124);
					int nuu = file.readInt();
					int emples = num + nuu;
					file.seek(posi + 124);
					file.writeInt(emples);

					// actualizo el salario
					file.seek(posi + 128);
					float sall = file.readFloat();
					float medianue = (sall + media) / 2;
					file.seek(posi + 128);
					file.writeFloat(medianue);

					// Actualizo director
					file.seek(posi + 132);
					buffer = null;
					buffer = new StringBuffer(director);
					buffer.setLength(30);
					file.writeChars(buffer.toString());

					System.out.println("Actualizado " + code);

				} else {
					System.out.println("No se localiza hueco. Se agrega: " + code);
					//SE CREA NUEVA EMPRESA
					posi = (code - 1) * LON;
					file.seek(posi);

					file.writeInt(code);

					StringBuffer buffer = null;
					buffer = new StringBuffer("NUEVA EMPRESA");
					buffer.setLength(30);
					file.writeChars(buffer.toString());

					buffer = null;
					buffer = new StringBuffer(direccion);
					buffer.setLength(30);
					file.writeChars(buffer.toString());

					file.writeInt(num);

					file.writeFloat(media);

					buffer = null;
					buffer = new StringBuffer(director);
					buffer.setLength(30);
					file.writeChars(buffer.toString());

				}
			} else {
				System.out.println("No se localiza, sobrepasa, se agrega: " + code);
				//SE CREA NUEVA EMPRESA
				posi = (code - 1) * LON;
				file.seek(posi);

				file.writeInt(code);

				StringBuffer buffer = null;
				buffer = new StringBuffer("NUEVA EMPRESA");
				buffer.setLength(30);
				file.writeChars(buffer.toString());

				buffer = null;
				buffer = new StringBuffer(direccion);
				buffer.setLength(30);
				file.writeChars(buffer.toString());

				file.writeInt(num);

				file.writeFloat(media);

				buffer = null;
				buffer = new StringBuffer(director);
				buffer.setLength(30);
				file.writeChars(buffer.toString());
			}

			file.close();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	private static void visualizarfichero(String nombre) {
		File fichero = new File(nombre);
		System.out.println("--------------------------");
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "r");
			long posi = 0;
			System.out.printf("%3s %-30s %-30s %9s %13s %-30s%n", "COD", "NOMBRE EMPRESA", "DIRECCI�N EMPRESA",
					"NUMEMPLES", "MEDIA SALARIO", "NOMBRE DIRECTOR");
			System.out.printf("%3s %-30s %-30s %9s %13s %-30s%n", "---", "------------------------------",
					"------------------------------", "---------", "-------------", "------------------------------");
			for (;;) {
				String nombreempresa = "";
				String direccion = "";

				file.seek(posi);
				int cod = file.readInt();
				if (cod > 0) {

					char cad;
					for (int i = 0; i < 30; i++) {
						cad = file.readChar();
						nombreempresa = nombreempresa + cad;
					}

					for (int i = 0; i < 30; i++) {
						cad = file.readChar();
						direccion = direccion + cad;
					}

					int numemple = file.readInt();
					float mediasal = file.readFloat();

					cad = 0;
					String director = "";
					for (int i = 0; i < 30; i++) {
						cad = file.readChar();
						// System.out.printf("%2s ",cad);
						director = director + cad;
					}

					System.out.printf("%3s %-30s %-30s %9s %13s %30s%n", cod, nombreempresa, direccion, numemple,
							mediasal, director);

				}

				posi = posi + LON;
				if (file.getFilePointer() == file.length() || posi >= file.length())
					break;

			}

			System.out.printf("%3s %-30s %-30s %9s %13s %-30s%n", "---", "------------------------------",
					"------------------------------", "---------", "-------------", "------------------------------");
			file.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	public static void crearfichero(String nombre) {
		File fichero = new File(nombre);
		fichero.delete();
		fichero = new File(nombre);
		System.out.println("INSERCI�N DE DATOS");

		try {
			// declara el fichero de acceso aleatorio
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");

			// arrays con los datos
			int cod[] = { 1, 3, 5, 10, 11, 12, 16 };
			String nombreempresa[] = { "Legalitas S.L.", "Suministros Juan", "Lopez y CIA", "Ganader�a Ramos",
					"Papeler�as reunidas", "S.A. La Alameda", "S.A. Almacenes REY" };
			String direccion[] = { "C/Alta 3. Talavera", "C/Mayor 31. Talavera", "C/Avenidas 10. Toledo",
					"Avda Espartales 4. Madrid", "Pol�gono 12-A. Toledo.", "Pol�gono 102. Madrid",
					"C/Carpinteros 4. Talavera" }; // apellidos

			String director[] = { "Antonio Fern�ndez", "Juan Gil", "Sebasti�n L�pez", "Ana Ramos", "Pedro Sevilla",
					"Mar�a Casilla", "Antonio Rey" };

			int numemple[] = { 4, 3, 5, 10, 11, 8, 10 };

			float mediasal[] = { 1000.45f, 2400.60f, 3000.0f, 1570.56f, 2000.10f, 1435.87f, 2000.0f };// salarios

			StringBuffer buffer = null;// buffer para almacenar cadenas

			int n = cod.length;// numero de elementos del array 7
			long posi = 0;

			for (int i = 0; i < n; i++) { // recorro los arrays

				posi = (cod[i] - 1) * LON;
				file.seek(posi);

				file.writeInt(cod[i]);

				buffer = null;
				buffer = new StringBuffer(nombreempresa[i]);
				buffer.setLength(30);
				file.writeChars(buffer.toString());

				buffer = null;
				buffer = new StringBuffer(direccion[i]);
				buffer.setLength(30);
				file.writeChars(buffer.toString());

				file.writeInt(numemple[i]);

				file.writeFloat(mediasal[i]);// insertar salario

				buffer = null;
				buffer = new StringBuffer(director[i]);
				buffer.setLength(30);
				file.writeChars(buffer.toString());

				System.out.println("Reg insertado: " + cod[i] + " * " + nombreempresa[i] + ", director: "
						+ buffer.toString() + "**");
			}
			file.close(); // cerrar fichero

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
	
}
