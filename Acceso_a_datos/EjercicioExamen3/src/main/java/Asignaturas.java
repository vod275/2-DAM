
public class Asignaturas {
	
	private int codigoAsignatura;
	private String nombreAsignatura;
	private int numeroAlumnos;
	private float sumaNotas;

	
	public Asignaturas(int codigoAsignatura, String nombreAsignatura, int numeroAlumnos, float sumaNotas) {
		super();
		this.codigoAsignatura = codigoAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.numeroAlumnos = numeroAlumnos;
		this.sumaNotas = sumaNotas;
	}
	public Asignaturas() {
		
	}
	
	
	public int getCodigoAsignatura() {
		return codigoAsignatura;
	}
	public void setCodigoAsignatura(int codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	public int getNumeroAlumnos() {
		return numeroAlumnos;
	}
	public void setNumeroAlumnos(int numeroAlumnos) {
		this.numeroAlumnos = numeroAlumnos;
	}
	public float getSumaNotas() {
		return sumaNotas;
	}
	public void setSumaNotas(float sumaNotas) {
		this.sumaNotas = sumaNotas;
	}
	
}
