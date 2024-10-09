package ventaAriculos2;

import javax.xml.bind.annotation.XmlElement;

public class Venta {
	private int numventa;
	private int unidades;
	private String nombre;
	private String fecha;

	public Venta(int numventa, int unidades, String nombre, String fecha) {
		super();
		this.numventa = numventa;
		this.unidades = unidades;
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public Venta() {

	}

	@XmlElement(name = "numventa")
	public int getNumventa() {
		return numventa;
	}

	public void setNumventa(int numventa) {
		this.numventa = numventa;
	}

	@XmlElement(name = "unidades")
	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	@XmlElement(name = "nombrecliente")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name = "fecha")
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
