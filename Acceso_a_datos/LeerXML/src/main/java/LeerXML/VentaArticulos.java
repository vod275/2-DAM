package LeerXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ventasarticulos")
public class VentaArticulos {

    private Articulo articulo;
    private Ventas ventas;

    public VentaArticulos() {}

    @XmlElement(name = "articulo")
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @XmlElement(name = "ventas")
    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }
}