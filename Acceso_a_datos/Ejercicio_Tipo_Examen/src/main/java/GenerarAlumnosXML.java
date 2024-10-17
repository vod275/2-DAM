import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class GenerarAlumnosXML {
	
	
	public static void generarXMLAlumnos(String rutaAlumnos, String rutaNotas, String rutaSalidaXML) throws IOException, ParserConfigurationException, TransformerException {

		File ficheroAlumnos = new File(rutaAlumnos);
        File ficheroNotas = new File(rutaNotas);

        RandomAccessFile fileAlumnos = new RandomAccessFile(ficheroAlumnos, "r");
        RandomAccessFile fileNotas = new RandomAccessFile(ficheroNotas, "r");

        // Configuración del parser de XML
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // Crear la estructura XML
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("ListaAlumnos");
        doc.appendChild(rootElement);

        for (int pos = 0; pos < fileAlumnos.length(); pos += 92) {
            fileAlumnos.seek(pos);
            int codAlumno = fileAlumnos.readInt();

            char[] nombreChars = new char[20];
            for (int i = 0; i < nombreChars.length; i++) {
                nombreChars[i] = fileAlumnos.readChar();
            }
            String nombre = new String(nombreChars).trim();

            char[] localidadChars = new char[20];
            for (int i = 0; i < localidadChars.length; i++) {
                localidadChars[i] = fileAlumnos.readChar();
            }
            String localidad = new String(localidadChars).trim();

            int numAsignaturas = fileAlumnos.readInt();
            float notaMedia = fileAlumnos.readFloat();

            // Crear nodo Alum
            Element alumElement = doc.createElement("Alum");
            rootElement.appendChild(alumElement);

            // Añadir los datos del alumno
            Element numAlumnoElement = doc.createElement("numalumno");
            numAlumnoElement.appendChild(doc.createTextNode(String.valueOf(codAlumno)));
            alumElement.appendChild(numAlumnoElement);

            Element nombreElement = doc.createElement("nombre");
            nombreElement.appendChild(doc.createTextNode(nombre));
            alumElement.appendChild(nombreElement);

            Element localidadElement = doc.createElement("localidad");
            localidadElement.appendChild(doc.createTextNode(localidad));
            alumElement.appendChild(localidadElement);

            Element numAsigElement = doc.createElement("numasig");
            numAsigElement.appendChild(doc.createTextNode(String.valueOf(numAsignaturas)));
            alumElement.appendChild(numAsigElement);

            Element notaMediaElement = doc.createElement("notamedia");
            notaMediaElement.appendChild(doc.createTextNode(String.format("%.2f", notaMedia)));
            alumElement.appendChild(notaMediaElement);

            // Crear nodo ListaNotas
            Element listaNotasElement = doc.createElement("ListaNotas");
            alumElement.appendChild(listaNotasElement);

            // Recorremos las notas del alumno
            for (int posNotas = 0; posNotas < fileNotas.length(); posNotas += 48) {
                fileNotas.seek(posNotas);
                int numAlumnoNota = fileNotas.readInt();

                if (numAlumnoNota == codAlumno) {
                    char[] asignaturaChars = new char[20];
                    for (int i = 0; i < asignaturaChars.length; i++) {
                        asignaturaChars[i] = fileNotas.readChar();
                    }
                    String asignatura = new String(asignaturaChars).trim();

                    float nota = fileNotas.readFloat();

                    // Crear nodo notaAsig
                    Element notaAsigElement = doc.createElement("notaasig");
                    listaNotasElement.appendChild(notaAsigElement);

                    Element asignaturaElement = doc.createElement("asignatura");
                    asignaturaElement.appendChild(doc.createTextNode(asignatura));
                    notaAsigElement.appendChild(asignaturaElement);

                    Element notaElement = doc.createElement("nota");
                    notaElement.appendChild(doc.createTextNode(String.format("%.2f", nota)));
                    notaAsigElement.appendChild(notaElement);
                }
            }
        }

        // Escribir el archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(rutaSalidaXML));
        transformer.transform(source, result);

        fileAlumnos.close();
        fileNotas.close();

        System.out.println("Fichero XML generado correctamente.");
    }

}
