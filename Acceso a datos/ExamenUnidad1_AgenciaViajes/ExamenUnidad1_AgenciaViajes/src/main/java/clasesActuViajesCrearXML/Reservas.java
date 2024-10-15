package clasesActuViajesCrearXML;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "nombrecliente", "plazasreservadas"})
public class Reservas {
	String nombrecliente;
	int plazasreservadas;

	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public int getPlazasreservadas() {
		return plazasreservadas;
	}

	public void setPlazasreservadas(int plazasreservadas) {
		this.plazasreservadas = plazasreservadas;
	}

	public Reservas() {
	}

	public Reservas(String nombrecliente, int plazasreservadas) {
		super();
		this.nombrecliente = nombrecliente;
		this.plazasreservadas = plazasreservadas;
	}

}
