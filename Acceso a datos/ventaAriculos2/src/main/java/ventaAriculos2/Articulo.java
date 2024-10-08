package ventaAriculos2;

import javax.xml.bind.annotation.XmlElement;



public class Articulo {

    private Artic artic;  // Este campo corresponde a <artic>
    private Ventas ventas;  // Este campo corresponde a <ventas>

    public Articulo() {
    }

    @XmlElement(name = "artic")  // Mapea el elemento <artic> en el XML
    public Artic getArtic() {
        return artic;
    }

    public void setArtic(Artic artic) {
        this.artic = artic;
    }

    @XmlElement(name = "ventas")  // Mapea el elemento <ventas> en el XML
    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }
}
