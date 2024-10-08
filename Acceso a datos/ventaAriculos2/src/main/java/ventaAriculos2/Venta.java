package ventaAriculos2;

import java.sql.Date;
import javax.xml.bind.annotation.XmlElement;

public class Venta {

    int unidades;
    String nombrecliente;
    Date fecha;
    int numventa;

    public Venta(int numventa, int unidades, String nombrecliente, Date fecha) {
        super();
        this.numventa = numventa;
        this.unidades = unidades;
        this.nombrecliente = nombrecliente;
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
    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    @XmlElement(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
