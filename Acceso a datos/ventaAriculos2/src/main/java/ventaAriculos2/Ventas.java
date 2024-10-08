package ventaAriculos2;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;



public class Ventas {
	
	
	private ArrayList<Venta> listaVentas;

    public Ventas(ArrayList<Venta> listaVentas) {
		super();
		this.listaVentas = listaVentas;
	}

	
    public Ventas() {
    }

    
    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
}
