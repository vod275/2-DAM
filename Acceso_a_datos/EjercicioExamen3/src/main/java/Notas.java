
public class Notas {

	Alumnos alumnos;
	Asignaturas asignaturas;
	Notas notas;

	public Notas(Alumnos alumnos, Asignaturas asignaturas, Notas notas) {
		super();
		this.alumnos = alumnos;
		this.asignaturas = asignaturas;
		this.notas = notas;
	}

	public Notas() {

	}

	public Alumnos getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumnos alumnos) {
		this.alumnos = alumnos;
	}

	public Asignaturas getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Asignaturas asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Notas getNotas() {
		return notas;
	}

	public void setNotas(Notas notas) {
		this.notas = notas;
	}

}
