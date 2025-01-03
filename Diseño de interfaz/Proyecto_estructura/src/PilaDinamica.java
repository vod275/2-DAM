
public class PilaDinamica<T> {
	
	private Nodo<T> top;
	private int tamanio;
	

	public PilaDinamica() {
		top = null;
		this.tamanio = 0;
		
	}
	
	
	public boolean isEmpty() {
		
		return top == null;
		
	}
	
	
	
	
	public int size() {
		return this.tamanio;
	}
	
	
	
	public T top() {
		if(isEmpty()) {
			return null;
		}
		else {
			return top.getElemento();
		}
			
	}
	
	
	
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		else {
			T elemento = top.getElemento();
			Nodo<T> aux = top.getSiguiente();	
			top = null;
			top = aux;
			this.tamanio--;
			return elemento;
		}
	}
	
	
	public T push(T elemento) {
		if(isEmpty()) {
			return null;
		}
		else {
			Nodo<T> aux = new Nodo<>(elemento, top);
			top = aux;
			this.tamanio++;
			return aux.getElemento();
			
		}
	}
	
	
	public String toString() {
		if(isEmpty()) {
			return null;
		}
		else {
			String resultado = "";
			Nodo<T> aux = top;
			while (aux !=null) {
				resultado += aux.toString();
				aux = aux.getSiguiente();
			}
			return resultado;
		}
	}
	
	
		
}
