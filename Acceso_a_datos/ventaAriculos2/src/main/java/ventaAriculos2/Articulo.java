package ventaAriculos2;
import javax.xml.bind.annotation.XmlElement;


public class Articulo {

	private Artic artic;
	private Ventas ventas;
	public Articulo(Artic artic, Ventas ventas) {
		super();
		this.artic = artic;
		this.ventas = ventas;
	}
	public Articulo() {
		
	}
	@XmlElement(name="artic")
	public Artic getArtic() {
		return artic;
	}
	public void setArtic(Artic artic) {
		this.artic = artic;
	}
	@XmlElement(name="ventas")
	public Ventas getVentas() {
		return ventas;
	}
	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}
	@Override
	public String toString() {
		return "Articulo [artic=" + artic + ", ventas=" + ventas + "]";
	}
}
