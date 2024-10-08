package ventaAriculos2;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class VentasArticulos {

	
	private List<Articulo> articulos;

	public VentasArticulos(List<Articulo> articulos) {
		super();
		this.articulos = articulos;
	}
	
	public VentasArticulos() {
		
	}


	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
}