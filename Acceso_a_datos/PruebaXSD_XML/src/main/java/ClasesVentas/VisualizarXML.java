package ClasesVentas;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class VisualizarXML {

	public static void main(String[] args) {
		
		//insertarventa(26, "Victor", 5, "27/05/1997");
		visualizarxml();
		//borrarventa(26);
		//modificarVenta(26, 10);

	}

	
	public static void visualizarxml() { 
		  System.out.println("------------------------------ "); 
		  System.out.println("-------VISUALIZAR XML--------- "); 
		  System.out.println("------------------------------ "); 
		  try { 
		      //Creamos el contexto 
		      JAXBContext jaxbContext =      
		          JAXBContext.newInstance(ObjectFactory.class); 
		 
		  Unmarshaller u = jaxbContext.createUnmarshaller();  
		 
		 JAXBElement jaxbElement = (JAXBElement) u.unmarshal 
		             (new FileInputStream("./ventasarticulos.xml")); 
		 
		 Marshaller m = jaxbContext.createMarshaller(); 
		 
		 m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
		 
		 // Visualiza por consola 
		 m.marshal(jaxbElement, System.out); 
		       
		      //Cargamos ahora el documento en los tipos 
		 VentasType miventa = (VentasType) jaxbElement.getValue(); 
		 
		 //Obtenemos una instancia para obtener todas las ventas 
		      Ventas vent = miventa.getVentas(); 
		 
		  // Guardamos las ventas en la lista 
		 List listaVentas = new ArrayList(); 
		 listaVentas = vent.getVenta(); 
		 
		 System.out.println("---------------------------- "); 
		 System.out.println("---VISUALIZAR LOS OBJETOS--- "); 
		 System.out.println("---------------------------- "); 
		 // Cargamos los datos del artículo 
		 DatosArtic miartic = (DatosArtic) miventa.getArticulo(); 
		 System.out.println("Nombre art: " +  
		               miartic.getDenominacion()); 
		 System.out.println("Coodigo art: " + miartic.getCodigo()); 
		 System.out.println("Ventas  del artículo , hay: " +  
		          listaVentas.size()); 
		      //Visualizamos las ventas del artículo 
		 for (int i = 0; i < listaVentas.size(); i++) { 
		  Ventas.Venta ve = (Ventas.Venta) listaVentas.get(i); 
		  System.out.println("Número de venta: " + 
		     ve.getNumventa() + ". Nombre cliente: " +  
		     ve.getNombrecliente() + ", unidades: " +  
		     ve.getUnidades() + ", fecha: " + ve.getFecha()); 
		       } 
		   } catch (JAXBException je) { 
		   System.out.println(je.getCause()); 
		   } catch (IOException ioe) { 
		   System.out.println(ioe.getMessage());} 
		}
	
	
	private static void insertarventa (int numeventa, String nomcli, int uni, String fecha) { 
	  System.out.println("---------------------------- "); 
	  System.out.println("-------AÑADIR VENTA--------- "); 
	  System.out.println("---------------------------- "); 
	  try { 
	     JAXBContext jaxbContext =    
	             JAXBContext.newInstance(ObjectFactory.class); 
	      Unmarshaller u = jaxbContext.createUnmarshaller(); 
	      JAXBElement jaxbElement = (JAXBElement)  
	     u.unmarshal(new FileInputStream("./ventasarticulos.xml")); 
	 
	      VentasType miventa = (VentasType) jaxbElement.getValue(); 
	 
	      Ventas vent = miventa.getVentas(); 
	 
	      List listaVentas = new ArrayList(); 
	      listaVentas = vent.getVenta(); 
	 
	      // comprobar si existe el número de venta,  
	     // reccorriendo el arraylist 
	      int existe = 0;  
	      for (int i = 0; i < listaVentas.size(); i++) { 
	    Ventas.Venta ve = (Ventas.Venta) listaVentas.get(i); 
	    if (ve.getNumventa().intValue() == numeventa) { 
	   existe = 1; break;} 
	      } 
	      if (existe == 0) { 
	        // Crear el objeto Ventas.Venta 
	        Ventas.Venta ve = new Ventas.Venta(); 
	        ve.setNombrecliente(nomcli); 
	        ve.setFecha(fecha); ve.setUnidades(uni); 
	        BigInteger nume = BigInteger.valueOf(numeventa); 
	        ve.setNumventa(nume); 
	       // Se añade la venta a la lista 
	       listaVentas.add(ve); 
	       //Se crea el Marshaller, volcar la lista al fichero XML 
	        Marshaller m = jaxbContext.createMarshaller(); 
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,  
	             Boolean.TRUE);  
	       m.marshal(jaxbElement, new  
	              FileOutputStream("./ventasarticulos.xml")); 
	       System.out.println("Venta añadida: " + numeventa); 
	    } else 
	        System.out.println("En número de venta ya existe: " +  
	           numeventa); 
	  } catch (JAXBException je) { 
	  System.out.println(je.getCause()); 
	  } catch (IOException ioe) { 
	  System.out.println(ioe.getMessage());} 
	 
	} 
	
	
	private static void borrarventa (int numeventa) {
		
		System.out.println("---------------------------- "); 
	    System.out.println("-------BORRAR VENTA--------- "); 
	    System.out.println("---------------------------- "); 
	    try { 
	        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class); 
	        Unmarshaller u = jaxbContext.createUnmarshaller(); 
	        JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml")); 
	        VentasType miventa = (VentasType) jaxbElement.getValue(); 
	        Ventas vent = miventa.getVentas(); 
	        List<Ventas.Venta> listaVentas = vent.getVenta(); 

	        boolean borrado = false;
	        for (int i = 0; i < listaVentas.size(); i++) {
	            Ventas.Venta ve = listaVentas.get(i);
	            if (ve.getNumventa().intValue() == numeventa) {
	                listaVentas.remove(i);
	                borrado = true;
	                break;
	            }
	        }

	        if (borrado) {
	            // guardamos la actualizacion de la lista xml
	            Marshaller m = jaxbContext.createMarshaller(); 
	            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);  
	            m.marshal(jaxbElement, new FileOutputStream("./ventasarticulos.xml")); 
	            System.out.println("Venta borrada: " + numeventa); 
	        } else {
	            System.out.println("Número de venta no encontrado: " + numeventa);
	        }
	    } catch (JAXBException je) { 
	        System.out.println(je.getCause()); 
	    } catch (IOException ioe) { 
	        System.out.println(ioe.getMessage());
	    } 
		
	}
	
	private static void modificarVenta (int numeventa, int unidades) {
		
		 System.out.println("---------------------------- "); 
		    System.out.println("-------MODIFICAR VENTA------ "); 
		    System.out.println("---------------------------- "); 
		    try {
		        // Cargar el contexto JAXB y leer el archivo XML
		        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		        Unmarshaller u = jaxbContext.createUnmarshaller();
		        JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml"));

		        // Obtener la lista de ventas
		        VentasType miventa = (VentasType) jaxbElement.getValue();
		        Ventas vent = miventa.getVentas();
		        List<Ventas.Venta> listaVentas = vent.getVenta();

		        boolean modificado = false;

		        // Buscar la venta por el número de venta
		        for (int i = 0; i < listaVentas.size(); i++) {
		            Ventas.Venta ve = listaVentas.get(i);
		            if (ve.getNumventa().intValue() == numeventa) {
		                // Modificar las unidades de la venta encontrada
		                ve.setUnidades(unidades);
		                modificado = true;
		                break;
		            }
		        }

		        if (modificado) {
		            // Guardar los cambios en el archivo XML
		            Marshaller m = jaxbContext.createMarshaller();
		            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		            m.marshal(jaxbElement, new FileOutputStream("./ventasarticulos.xml"));
		            System.out.println("Venta modificada: Número de venta " + numeventa + ", Nuevas unidades: " + unidades);
		        } else {
		            System.out.println("Número de venta no encontrado: " + numeventa);
		        }

		    } catch (JAXBException je) {
		        System.out.println(je.getCause());
		    } catch (IOException ioe) {
		        System.out.println(ioe.getMessage());
		    }
		
		
		
	}
}
	
	


