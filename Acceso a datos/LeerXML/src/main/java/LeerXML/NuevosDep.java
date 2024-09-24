package LeerXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "departamento")
public class NuevosDep {

    private int deptno;     // Número de departamento
    private String dnombre; // Nombre del departamento
    private String localidad; // Localidad del departamento

    // Constructor vacío (necesario para JAXB)
    public NuevosDep() {}

    // Constructor con parámetros
    public NuevosDep(int deptno, String dnombre, String localidad) {
        this.deptno = deptno;
        this.dnombre = dnombre;
        this.localidad = localidad;
    }

    @XmlElement(name = "Departamento")
    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @XmlElement(name = "Nombre")
    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    @XmlElement(name = "Localidad")
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}