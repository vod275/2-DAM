package ventaAriculos2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {

	private static final String MIARCHIVO_XML = "C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso a datos\\ventaAriculos2\\ventasarticulos.xml";

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		try {
			JAXBContext context = JAXBContext.newInstance(VentasArticulos.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			VentasArticulos ventasArticulos = (VentasArticulos) unmarshaller.unmarshal(new File(MIARCHIVO_XML));

			ArrayList<Articulo> articulos = ventasArticulos.getArticulos();
			System.out.println("Número de artículos: " + articulos.size());

			System.out.println(articulos.size());
			for (Articulo articulo : articulos) {
				Artic artic = articulo.getArtic();
				String codigo = artic.getCodigo();
				String denominacion = artic.getDenominacion();
				double precio = artic.getPrecio();

				System.out.printf("Código: %s      Nombre: %s      PVP: %.1f\n", codigo, denominacion, precio);
				System.out.println("NUM VENTA  FECHA VENTA  NOM-CLIENTE                UNIDADES     IMPORTE");
				System.out.println("---------  -----------  ------------------         --------  ----------");

				int totalUnidades = 0;
				double totalImporte = 0.0;

				ArrayList<Venta> Ventas = articulo.getVentas().getListaVenta();

				for (Venta venta : Ventas) {
					int unidades = venta.getUnidades();
					double importe = unidades * precio;
					totalUnidades += unidades;
					totalImporte += importe;

					System.out.printf("%9d  %11s  %-25s  %8d  %10.1f\n", venta.getNumventa(), venta.getFecha(),
							venta.getNombrecliente(), unidades, importe);

				}

				System.out.println("---------  -----------  ------------------         --------  ----------");
				System.out.printf("  TOTALES                                             %8d  %10.1f\n", totalUnidades,
						totalImporte);
				System.out.println();
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
