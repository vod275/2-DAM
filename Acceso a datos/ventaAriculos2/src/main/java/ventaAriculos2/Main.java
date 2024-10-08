package ventaAriculos2;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {

	public static void main(String[] args) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(VentasArticulos.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		VentasArticulos ventasArticulos = (VentasArticulos) unmarshaller.unmarshal(new File("ventasarticulosdos.xml"));
		generarSalida(ventasArticulos);

	}

	private static void generarSalida(VentasArticulos ventasArticulos) {

		for (Articulo articulo : ventasArticulos.getArticulos()) {
			Artic datosArticulo = articulo.getArtic();
			Ventas ventas = articulo.getVentas();
			List<Venta> listaVentas = ventas.getListaVentas();

			System.out.printf("Código: %s      Nombre: %s      PVP: %.1f\n", datosArticulo.getCodigo(),
					datosArticulo.getDenominacion(), datosArticulo.getPrecio());
			System.out.println("NUM VENTA  FECHA VENTA  NOM-CLIENTE                UNIDADES     IMPORTE");
			System.out.println("---------  -----------  ------------------         --------  ----------");

			int totalUnidades = 0;
			double totalImporte = 0.0;

			for (Venta venta : listaVentas) {
				int unidades = venta.getUnidades();
				double importe = unidades * datosArticulo.getPrecio();
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
	}
}
