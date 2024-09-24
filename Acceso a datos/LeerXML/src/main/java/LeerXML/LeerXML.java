package LeerXML;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class LeerXML {

    public static void main(String[] args) {
        try {
            // Crear el contexto JAXB
            JAXBContext context = JAXBContext.newInstance(VentaArticulos.class);

            // Unmarshalling: Leer XML y convertirlo en un objeto Java
            Unmarshaller unmarshaller = context.createUnmarshaller();
            VentaArticulos ventasArticulos = (VentaArticulos) unmarshaller.unmarshal(new File("ventasarticulos.xml"));
            
            // Manipular los datos si es necesario

            // Marshalling: Convertir el objeto Java de nuevo a XML
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  // Para formatear el XML de salida
            marshaller.marshal(ventasArticulos, System.out);  // Mostrar el XML en consola

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
