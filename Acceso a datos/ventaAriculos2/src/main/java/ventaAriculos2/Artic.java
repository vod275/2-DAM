package ventaAriculos2;


public class Artic {

	String Denominacion;
	int stock;
	float precio;
	String codigo;

	public Artic(String denominacion, int stock, float precio, String codigo) {
		super();
		Denominacion = denominacion;
		this.stock = stock;
		this.precio = precio;
		this.codigo = codigo;
	}
	public Artic() {
		
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDenominacion() {
		return Denominacion;
	}

	public void setDenominacion(String denominacion) {
		Denominacion = denominacion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
