
public class Alumnos {
	
	private int codigoAlumno;
	private String nombreAlumno;
	private String curso;
	private float notaMedia;
	
	public Alumnos(int codigoAlumno, String nombreAlumno, String curso, float notaMedia) {
		super();
		this.codigoAlumno = codigoAlumno;
		this.nombreAlumno = nombreAlumno;
		this.curso = curso;
		this.notaMedia = notaMedia;
	}
	
	public Alumnos() {
		
	}
	
	
	public int getCodigoAlumno() {
		return codigoAlumno;
	}
	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}
	public String getNombre() {
		return nombreAlumno;
	}
	public void setNombre(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public float getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(float notaMedia) {
		this.notaMedia = notaMedia;
	}

	

}
