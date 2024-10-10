
public class emple {

	private String nombre;
	private double salario;
	private String puesto;

	public emple(String nombre, double salario, String puesto) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.puesto = puesto;
	}

	public emple() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

}
