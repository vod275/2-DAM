//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.03 a las 07:43:56 PM CEST 
//


package clasesdatos.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para VentasType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="VentasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articulo" type="{}DatosArtic"/&gt;
 *         &lt;element name="ventas" type="{}Ventas"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VentasType", propOrder = {
    "articulo",
    "ventas"
})
public class VentasType {

    @XmlElement(required = true)
    protected DatosArtic articulo;
    @XmlElement(required = true)
    protected Ventas ventas;

    /**
     * Obtiene el valor de la propiedad articulo.
     * 
     * @return
     *     possible object is
     *     {@link DatosArtic }
     *     
     */
    public DatosArtic getArticulo() {
        return articulo;
    }

    /**
     * Define el valor de la propiedad articulo.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosArtic }
     *     
     */
    public void setArticulo(DatosArtic value) {
        this.articulo = value;
    }

    /**
     * Obtiene el valor de la propiedad ventas.
     * 
     * @return
     *     possible object is
     *     {@link Ventas }
     *     
     */
    public Ventas getVentas() {
        return ventas;
    }

    /**
     * Define el valor de la propiedad ventas.
     * 
     * @param value
     *     allowed object is
     *     {@link Ventas }
     *     
     */
    public void setVentas(Ventas value) {
        this.ventas = value;
    }

}
