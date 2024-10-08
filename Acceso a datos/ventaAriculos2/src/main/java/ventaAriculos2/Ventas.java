package ventaAriculos2;

import java.util.ArrayList;


import javax.xml.bind.annotation.XmlElement;

public class Ventas {

	private ArrayList<Venta> listaVenta;

	public Ventas(ArrayList<Venta> listaVenta) {
		super();
		this.listaVenta = listaVenta;
	}


	public ArrayList<Venta> getListaVenta() {
		return listaVenta;
	}

	public void setListaVenta(ArrayList<Venta> listaVenta) {
		this.listaVenta = listaVenta;
	}

	public Ventas() {
	}

}
