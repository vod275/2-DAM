
public class Nodo<T> {

	
	//Atributos
	private T elemento;
	private Nodo<T> siguiente;
	
	public Nodo(T elemento, Nodo<T> siguiente) {
		super();
		this.elemento = elemento;
		this.siguiente = siguiente;
	}
	
	public Nodo(T t) {
		siguiente = null;
		elemento = t;
	}
	
	public Nodo() {
		siguiente = null;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
	
	

	
}
