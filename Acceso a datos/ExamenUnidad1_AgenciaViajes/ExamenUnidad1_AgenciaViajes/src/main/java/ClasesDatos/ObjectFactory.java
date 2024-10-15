//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.15 a las 03:54:11 PM CEST 
//


package ClasesDatos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListaViajes_QNAME = new QName("", "ListaViajes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListaViajesType }
     * 
     */
    public ListaViajesType createListaViajesType() {
        return new ListaViajesType();
    }

    /**
     * Create an instance of {@link Viaje }
     * 
     */
    public Viaje createViaje() {
        return new Viaje();
    }

    /**
     * Create an instance of {@link ListaReservasType }
     * 
     */
    public ListaReservasType createListaReservasType() {
        return new ListaReservasType();
    }

    /**
     * Create an instance of {@link Reserva }
     * 
     */
    public Reserva createReserva() {
        return new Reserva();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaViajesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListaViajesType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ListaViajes")
    public JAXBElement<ListaViajesType> createListaViajes(ListaViajesType value) {
        return new JAXBElement<ListaViajesType>(_ListaViajes_QNAME, ListaViajesType.class, null, value);
    }

}
