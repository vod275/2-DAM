//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.15 a las 03:54:11 PM CEST 
//


package ClasesDatos;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Reserva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Reserva"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombrecliente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plazasreservadas" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reserva", propOrder = {
    "nombrecliente",
    "plazasreservadas"
})
public class Reserva {

    @XmlElement(required = true)
    protected String nombrecliente;
    @XmlElement(required = true)
    protected BigInteger plazasreservadas;

    /**
     * Obtiene el valor de la propiedad nombrecliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrecliente() {
        return nombrecliente;
    }

    /**
     * Define el valor de la propiedad nombrecliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrecliente(String value) {
        this.nombrecliente = value;
    }

    /**
     * Obtiene el valor de la propiedad plazasreservadas.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPlazasreservadas() {
        return plazasreservadas;
    }

    /**
     * Define el valor de la propiedad plazasreservadas.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPlazasreservadas(BigInteger value) {
        this.plazasreservadas = value;
    }

}
