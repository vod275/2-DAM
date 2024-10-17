package LeerXML;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ventas")
public class Ventas {

    private List<Venta> venta;

    public Ventas() {}

    @XmlElement(name = "venta")
    public List<Venta> getVenta() {
        return venta;
    }

    public void setVenta(List<Venta> venta) {
        this.venta = venta;
    }
}