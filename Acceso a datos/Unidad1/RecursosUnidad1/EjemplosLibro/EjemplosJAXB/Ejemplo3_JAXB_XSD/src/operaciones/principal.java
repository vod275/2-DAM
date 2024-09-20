package operaciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import clasesdatos.ObjectFactory;
import clasesdatos.Ventas.Venta;
import clasesdatos.*;

public class principal {

	public static void main(String[] args) {
		
		crearnuevoventasxml();
		
	}
	public static void crearnuevoventasxml() {

		// Crear el objeto DatosArtic
		DatosArtic articulo = new DatosArtic();
		articulo.setCodigo("Arti 1");
		articulo.setDenominacion("Bicicleta Plegable");
		BigInteger stv = BigInteger.valueOf(10);
		BigDecimal pvv = BigDecimal.valueOf(200);
		articulo.setPrecio(pvv);
		articulo.setStock(stv);

		// Creamos el objeto Ventas
		Ventas ventas = new Ventas();
		// Creao la primera venta y la a�ado a ventas
		Ventas.Venta ven = new Ventas.Venta();
		ven.setNombrecliente("Alicia Ramos");
		ven.setNumventa(BigInteger.valueOf(1));
		ven.setUnidades(2);
		ven.setFecha("10-02-2016");
		ventas.getVenta().add(ven);
		// Creo la segunda venta y la a�ado a ventas
		ven = new Ventas.Venta();
		ven.setNombrecliente("Dori Mart�n");
		ven.setNumventa(BigInteger.valueOf(2));
		ven.setUnidades(1);
		ven.setFecha("21-02-2016");
		ventas.getVenta().add(ven);

		// Creo un VentasType y asigno los datos
		VentasType miventaarticulo = new VentasType();
		miventaarticulo.setArticulo(articulo);
		miventaarticulo.setVentas(ventas);

		// Creo el ObjectFactory
		ObjectFactory miarticulo = new ObjectFactory();
		// Creo El JAXBElement lo obtenemos del ObjectFactory y del VentasType
		JAXBElement<VentasType> element = miarticulo.createVentasarticulos(miventaarticulo);
		// Creo el contexto y el Marshaller
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			String fiche = "./nuevo_ventasarticulos.xml";
			m.marshal(element, new FileOutputStream(fiche));
			System.out.println("Venta creada. ");
			// Visualizamos por por consola
			m.marshal(element, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}


	}


