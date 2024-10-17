package ventaAriculos2;

import java.util.ArrayList;

public class Ventas {

	private ArrayList<Venta> venta;

	public Ventas(ArrayList<Venta> venta) {
		super();
		this.venta = venta;
	}

	public Ventas() {

	}

	public ArrayList<Venta> getVenta() {
		return venta;
	}

	public void setVenta(ArrayList<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Ventas [venta=" + venta + "]";
	}
}
