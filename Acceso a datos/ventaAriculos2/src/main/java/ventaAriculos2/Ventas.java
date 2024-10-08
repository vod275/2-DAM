package ventaAriculos2;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Ventas {

	@XmlElement(name = "venta")
	private List<Venta> listaVentas;

	public Ventas(List<Venta> listaVentas) {
		super();
		this.listaVentas = listaVentas;
	}
	
	public Ventas() {
		
	}


	public List<Venta> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}

}
