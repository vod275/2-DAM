//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.15 a las 03:45:58 PM CEST 
//


package clasesdatos;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Viaje complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Viaje"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codviaje" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pvp" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="numplazas" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="numreservas" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="totalimporte" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="ListaReservas" type="{}ListaReservasType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Viaje", propOrder = {
    "codviaje",
    "nombre",
    "pvp",
    "numplazas",
    "numreservas",
    "totalimporte",
    "listaReservas"
})
public class Viaje {

    @XmlElement(required = true)
    protected BigInteger codviaje;
    @XmlElement(required = true)
    protected String nombre;
    protected float pvp;
    @XmlElement(required = true)
    protected BigInteger numplazas;
    @XmlElement(required = true)
    protected BigInteger numreservas;
    protected float totalimporte;
    @XmlElement(name = "ListaReservas", required = true)
    protected ListaReservasType listaReservas;

    /**
     * Obtiene el valor de la propiedad codviaje.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodviaje() {
        return codviaje;
    }

    /**
     * Define el valor de la propiedad codviaje.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodviaje(BigInteger value) {
        this.codviaje = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad pvp.
     * 
     */
    public float getPvp() {
        return pvp;
    }

    /**
     * Define el valor de la propiedad pvp.
     * 
     */
    public void setPvp(float value) {
        this.pvp = value;
    }

    /**
     * Obtiene el valor de la propiedad numplazas.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumplazas() {
        return numplazas;
    }

    /**
     * Define el valor de la propiedad numplazas.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumplazas(BigInteger value) {
        this.numplazas = value;
    }

    /**
     * Obtiene el valor de la propiedad numreservas.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumreservas() {
        return numreservas;
    }

    /**
     * Define el valor de la propiedad numreservas.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumreservas(BigInteger value) {
        this.numreservas = value;
    }

    /**
     * Obtiene el valor de la propiedad totalimporte.
     * 
     */
    public float getTotalimporte() {
        return totalimporte;
    }

    /**
     * Define el valor de la propiedad totalimporte.
     * 
     */
    public void setTotalimporte(float value) {
        this.totalimporte = value;
    }

    /**
     * Obtiene el valor de la propiedad listaReservas.
     * 
     * @return
     *     possible object is
     *     {@link ListaReservasType }
     *     
     */
    public ListaReservasType getListaReservas() {
        return listaReservas;
    }

    /**
     * Define el valor de la propiedad listaReservas.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaReservasType }
     *     
     */
    public void setListaReservas(ListaReservasType value) {
        this.listaReservas = value;
    }

}
