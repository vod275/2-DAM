package ventaAriculos2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;



@XmlAccessorType(XmlAccessType.FIELD)
public class Articulo {
    @XmlElement(name = "artic")
    private Artic artic;
    
    @XmlElement(name = "ventas")
    private Ventas ventas;
    
    public Articulo(Artic artic, Ventas ventas) {
		super();
		this.artic = artic;
		this.ventas = ventas;
	}
    public Articulo() {
		;
	}

    public Artic getArtic() {
        return artic;
    }

    public void setArtic(Artic artic) {
        this.artic = artic;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }
}