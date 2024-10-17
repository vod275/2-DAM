import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class LeerXML {
	
	public static Empresas leerEmpresasXML(String archivoXML) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Empresas.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        return (Empresas) unmarshaller.unmarshal(new File(archivoXML));
    }

}
