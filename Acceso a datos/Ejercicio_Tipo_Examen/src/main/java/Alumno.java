
public class Alumno {
	
	
	    private int codAlumno;
	    private String nombre;
	    private String localidad;
	    private int numAsignaturas;
	    private float notaMedia;

	    public Alumno(int codAlumno, String nombre, String localidad, int numAsignaturas, float notaMedia) {
	        this.codAlumno = codAlumno;
	        this.nombre = nombre;
	        this.localidad = localidad;
	        this.numAsignaturas = numAsignaturas;
	        this.notaMedia = notaMedia;
	    }

	    // Getters para acceder a los datos
	    public int getCodAlumno() {
	        return codAlumno;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getLocalidad() {
	        return localidad;
	    }

	    public int getNumAsignaturas() {
	        return numAsignaturas;
	    }

	    public float getNotaMedia() {
	        return notaMedia;
	    }
}



