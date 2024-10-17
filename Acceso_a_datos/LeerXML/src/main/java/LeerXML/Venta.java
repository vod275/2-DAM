package LeerXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "venta")
public class Venta {

    private int numVenta;
    private int unidades;
    private String nombreCliente;
    private String fecha;

    public Venta() {}

    public Venta(int numVenta, int unidades, String nombreCliente, String fecha) {
        this.numVenta = numVenta;
        this.unidades = unidades;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
    }

    @XmlElement(name = "numventa")
    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    @XmlElement(name = "unidades")
    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @XmlElement(name = "nombrecliente")
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @XmlElement(name = "fecha")
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}