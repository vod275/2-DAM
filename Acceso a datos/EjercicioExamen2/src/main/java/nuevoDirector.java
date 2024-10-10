
public class nuevoDirector {

	private String nombreDirector;
	private double salarioDirector;
	private String puestoDirector;

	public nuevoDirector(String nombreDirector, double salarioDirector, String puestoDirector) {
		super();
		this.nombreDirector = nombreDirector;
		this.salarioDirector = salarioDirector;
		this.puestoDirector = puestoDirector;
	}

	public nuevoDirector() {

	}

	public String getNombreDirector() {
		return nombreDirector;
	}

	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}

	public double getSalarioDirector() {
		return salarioDirector;
	}

	public void setSalarioDirector(double salarioDirector) {
		this.salarioDirector = salarioDirector;
	}

	public String getPuestoDirector() {
		return puestoDirector;
	}

	public void setPuestoDirector(String puestoDirector) {
		this.puestoDirector = puestoDirector;
	}

}
