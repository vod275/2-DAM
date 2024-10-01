import java.io.Serializable;

public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;

    private int codAlumno;          // Código del alumno
    private int numAlumno;          // Número del alumno
    private String nombreAsignatura; // Nombre de la asignatura
    private float notaAsignatura;    // Nota de la asignatura

    public Nota(int codAlumno, int numAlumno, String nombreAsignatura, float notaAsignatura) {
        this.codAlumno = codAlumno;
        this.numAlumno = numAlumno;
        this.nombreAsignatura = nombreAsignatura;
        this.notaAsignatura = notaAsignatura;
    }

    // Getters y Setters
    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno) {
        this.codAlumno = codAlumno;
    }

    public int getNumAlumno() {
        return numAlumno;
    }

    public void setNumAlumno(int numAlumno) {
        this.numAlumno = numAlumno;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public float getNotaAsignatura() {
        return notaAsignatura;
    }

    public void setNotaAsignatura(float notaAsignatura) {
        this.notaAsignatura = notaAsignatura;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-10d %-20s %.2f", codAlumno, numAlumno, nombreAsignatura, notaAsignatura);
    }
}

