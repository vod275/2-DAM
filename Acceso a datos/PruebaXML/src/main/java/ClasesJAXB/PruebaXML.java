package ClasesJAXB;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext; 
import javax.xml.bind.JAXBException; 
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller; 

public class PruebaXML {
	
	private static final String MIARCHIVO_XML = "./unlibro.xml"; 

	public static void main(String[] args) throws JAXBException {
		
		 ArrayList<Libro> libroLista = new ArrayList<Libro>(); 
	        // Creamos dos libros y los añadimos 
	        Libro libro1 = new Libro("Entornos de Desarrollo",  
	                 "Alicia Ramos","Garceta","978-84-1545-297-3" ); 
	        libroLista.add(libro1); 
	        Libro libro2 = new Libro("Acceso a Datos","Maria Jesús Ramos", "Garceta","978-84-1545-228-7" ); 
	        libroLista.add(libro2);
		
	        // Se crea La libreria y se le asigna la lista de libros 
	        Libreria milibreria = new Libreria(); 
	        milibreria.setNombre("Prueba de libreria JAXB"); 
	        milibreria.setLugar("Talavera, como no"); 
	        milibreria.setListaLibro(libroLista);
	        
		JAXBContext context = JAXBContext.newInstance(Libreria.class); 
		

        Marshaller m = context.createMarshaller(); 
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
		 
		
		m.marshal(milibreria, System.out); 
	    m.marshal(milibreria, new File(MIARCHIVO_XML)); //salida en archivo 
	    
	    
	    
	    // Visualizamos ahora los datos del documento XML creado 
	     System.out.println("------------ Leo el XML ---------"); 
	     //Se crea Unmarshaller en el cotexto de la clase Libreria 
	     Unmarshaller un = context.createUnmarshaller(); 
	         
	     //Utilizamos el método unmarshal, para obtener datos de un Reader 
	     Libreria libreria2 = (Libreria) 
	     un.unmarshal(new File(MIARCHIVO_XML)); 
	         
	     //Recuperamos los datos y visualizamos 
	     System.out.println("Nombre de libreria: "+ libreria2.getNombre()); 
	     System.out.println("Lugar de la libreria: "+ 
	        libreria2.getLugar()); 
	     System.out.println("Libros de la librería: "); 
	         
	     ArrayList<Libro> lista = libreria2.getListaLibro(); 
	     for (Libro libro : lista) { 
	           System.out.println("\tTítulo del libro: "  + libro.getNombre() + " , autora: " + libro.getAutor()); 
	}

 }
}
