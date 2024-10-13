import java.io.IOException;
import java.io.RandomAccessFile;

public class ActualizadorEmpresas {

	private static void writeFixedLengthString(RandomAccessFile archivo, String str, int length) throws IOException {
		if (str == null) {
			str = ""; // Si la cadena es null, se reemplaza por una cadena vac�a
		}

		// Si la cadena es m�s corta que el tama�o requerido, se rellena con espacios
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() < length) {
			sb.append(' ');
		}

		// Si la cadena es m�s larga, se trunca
		archivo.writeChars(sb.substring(0, length));
	}

	public static void actualizarEmpresa(RandomAccessFile archivo, Empresa empresa) throws IOException {

		int posicion = (empresa.getCodempre() - 1) * 104; // 104 bytes por registro (ajusta esto seg�n tu formato)
		archivo.seek(posicion);

		int codigoExistente = archivo.readInt();
		if (codigoExistente > 0) {
			System.out.println("Actualizando empresa: " + codigoExistente);

			writeFixedLengthString(archivo, empresa.getDireccion(), 30);
			archivo.writeInt(empresa.getNuevosemples().getEmple().size());
			archivo.writeFloat(calcularMediaSalarial(empresa));
			writeFixedLengthString(archivo, empresa.getNuevodirector().getNombreDirector(), 30);

		} else {
			System.out.println("A�adiendo nueva empresa: " + empresa.getCodempre());
			archivo.seek(posicion);

			// A�adir nueva empresa
			archivo.writeInt(empresa.getCodempre());
			writeFixedLengthString(archivo, "NUEVA EMPRESA", 30);
			writeFixedLengthString(archivo, empresa.getDireccion(), 30);
			archivo.writeInt(empresa.getNuevosemples().getEmple().size());
			archivo.writeFloat(calcularMediaSalarial(empresa));
			writeFixedLengthString(archivo, empresa.getNuevodirector().getNombreDirector(), 30);

		}
	}

	// M�todo para calcular la media salarial de los empleados
	private static float calcularMediaSalarial(Empresa empresa) {
		float totalSalarios = 0;
		for (Emple e : empresa.getNuevosemples().getEmple()) {
			totalSalarios += e.getSalario();
		}
		return totalSalarios / empresa.getNuevosemples().getEmple().size();
	}

}
