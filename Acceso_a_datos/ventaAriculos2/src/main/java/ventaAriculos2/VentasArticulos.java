package ventaAriculos2;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "ventasarticulos")
public class VentasArticulos {

	private ArrayList<Articulo> articulo;

	public VentasArticulos(ArrayList<Articulo> articulo) {
		super();
		this.articulo = articulo;
	}

	public VentasArticulos() {

	}

	public ArrayList<Articulo> getArticulo() {
		return articulo;
	}

	public void setArticulo(ArrayList<Articulo> articulo) {
		this.articulo = articulo;
	}
}