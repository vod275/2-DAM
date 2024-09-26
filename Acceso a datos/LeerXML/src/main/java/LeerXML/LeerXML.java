package LeerXML;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LeerXML {

    public static void main(String[] args) {
        try {
            // Crear el contexto JAXB
            JAXBContext context = JAXBContext.newInstance(VentaArticulos.class);

            // Unmarshalling: Leer XML y convertirlo en un objeto Java
            Unmarshaller unmarshaller = context.createUnmarshaller();
            VentaArticulos ventasArticulos = (VentaArticulos) unmarshaller.unmarshal(new File("ventasarticulos.xml"));

            // Mostrar el artículo
            Articulo articulo = ventasArticulos.getArticulo();
            System.out.println("Artículo:");
            System.out.println("Código: " + articulo.getCodigo());
            System.out.println("Denominación: " + articulo.getDenominacion());
            System.out.println("Stock: " + articulo.getStock());
            System.out.println("Precio: " + articulo.getPrecio());
            System.out.println();

            // Mostrar todas las ventas
            Ventas ventas = ventasArticulos.getVentas();
            System.out.println("Ventas:");
            for (Venta venta : ventas.getVenta()) {
                System.out.println("Número de Venta: " + venta.getNumVenta());
                System.out.println("Unidades: " + venta.getUnidades());
                System.out.println("Nombre del Cliente: " + venta.getNombreCliente());
                System.out.println("Fecha: " + venta.getFecha());
                System.out.println("__________________________");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}