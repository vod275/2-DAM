package hibernateClases2;
// Generated 17 dic 2024, 17:16:18 by Hibernate Tools 5.6.15.Final

/**
 * Lleva generated by hbm2java
 */
public class Lleva implements java.io.Serializable {

	private LlevaId id;
	private Camisetas camisetas;
	private Ciclistas ciclistas;
	private Etapas etapas;

	public Lleva() {
	}

	public Lleva(LlevaId id, Camisetas camisetas, Ciclistas ciclistas, Etapas etapas) {
		this.id = id;
		this.camisetas = camisetas;
		this.ciclistas = ciclistas;
		this.etapas = etapas;
	}

	public LlevaId getId() {
		return this.id;
	}

	public void setId(LlevaId id) {
		this.id = id;
	}

	public Camisetas getCamisetas() {
		return this.camisetas;
	}

	public void setCamisetas(Camisetas camisetas) {
		this.camisetas = camisetas;
	}

	public Ciclistas getCiclistas() {
		return this.ciclistas;
	}

	public void setCiclistas(Ciclistas ciclistas) {
		this.ciclistas = ciclistas;
	}

	public Etapas getEtapas() {
		return this.etapas;
	}

	public void setEtapas(Etapas etapas) {
		this.etapas = etapas;
	}

}