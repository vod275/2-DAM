
public class ListaEnlazada<T> {

	
	private Nodo<T> primero;
	
	public ListaEnlazada() {
		listaVacia();
	}
	
	private void listaVacia() {
		primero = null;
	}
	
	public boolean estaVacia() {
		return primero == null;
	}
	
	
	public void  insertarPrimero(T t) {
		Nodo<T> nuevo = new Nodo<>(t);
		if(!estaVacia()) {
			nuevo.setSiguiente(primero);
		}
		//el primero apunta al nodo nuevo
		primero = nuevo;
	}
	
	public void insertarUltimo(T t) {
		Nodo<T> aux = new Nodo<>(t);
		Nodo<T> rec_aux;
		if(estaVacia()) {
			insertarPrimero(t);
		} else {
			rec_aux = primero;
			
			while(rec_aux.getSiguiente() != null) {
				rec_aux = rec_aux.getSiguiente();
			}
			
			rec_aux.setSiguiente(aux);
		}
	
	}
	
	public void quitarPrimero() {
		
		Nodo<T> aux;
		if(!estaVacia()) {
			aux = primero;
			primero = primero.getSiguiente();
			aux = null; //mandamos el elemento a la basura
			
		}
		
	}
	
	
	public void quitarUltimo() {
	
			Nodo<T> aux = primero;
			
			//Aqui entra si la lista esta vacia
			if(aux.getSiguiente() == null) {
				
				listaVacia();
				
			}
			
			if(!estaVacia()) {
				aux = primero;
			//Buscamos el penultimo por eso hay dos get siguientes
				while(aux.getSiguiente().getSiguiente() != null) {
					aux = aux.getSiguiente();
				}
			
				aux.setSiguiente(null);
			
		
			}
	}
	
	
	public T devolverUltimo() {
		T elemento = null;
		Nodo<T> aux;

		if(!estaVacia()) {
			aux = primero;
	
			while(aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
		
			elemento = aux.getElemento();
		
	
		}
		
		return elemento;
		
		
	}
	
	public T devolverPrimero() {
		
		T elemento = null;
		
		if(!estaVacia()) {
			elemento = primero.getElemento();		
			}
		return elemento;
		
	}
	
	public int cuantosElementos() {
		Nodo<T> aux;
		int elementosContados = 1;
		aux = primero;
		
		while (aux != null) {
			elementosContados ++;
			aux.getSiguiente();
			}
		
		return elementosContados;
	}
	
	
	public T devolverDato(int pos) {
		
		Nodo<T> aux = primero;
		int cont = 0;
		T elemento = null;
		if(pos < 0 || pos >= cuantosElementos()) {
			System.out.println("La posicion no es correcta");
		} else {
			while (aux != null) {
				elemento = aux.getElemento();
				
			}
			
			aux = aux.getSiguiente();			
			cont++;
			}
		return elemento;
	}
	
	
	public Nodo<T> devolverNodo(int pos) {
		Nodo<T> aux  = primero;
		int cont = 0;
		
		if(pos < 0 || pos >= cuantosElementos()) {
			System.out.println("La posicion no es correcta");
			
		} else {
			while (aux != null) {
				if(pos == cont) {
					return aux;
				}
				
				aux = aux.getSiguiente();			
				cont++;
			}
			
			
		}
		return aux;
	}
	
	
	public void introducirDato(int pos, T elemento) {
		Nodo<T> aux  = primero;
		Nodo<T> auxElemento  = null;
		Nodo<T> anterio = primero;
		
		
		
	}
	
	
	public void modificardato(int pos, T elemento) {
		Nodo<T> aux  = primero;
		int cont = 0;
		
		
		if(pos < 0 || pos >= cuantosElementos()) {
			System.out.println("La posicion no es correcta");
			
		} else {
			while (aux != null) {
				if(pos == cont) {
					aux.setElemento(elemento);
				}
				
				aux = aux.getSiguiente();			
				cont++;
			}
	
		
		
	}
	
 }
	
	
	public void borrarPosicion(int pos) {
		Nodo<T> aux  = primero;
		Nodo<T> anterior = null;
		int cont = 0;
		
		if(pos < 0 || pos >= cuantosElementos()) {
			System.out.println("La posicion no es correcta");
		} else {
			
		}
	}
	
	
	public T devolverYBorrarPrimero() {
		T dato = devolverPrimero();
		quitarPrimero();
		
	}
	
	public int indexOf(T t) {
		
	}
	
	public boolean elementoExistente(T t) {
		
	}
	
	public void mostar() {
		
	}
	
	public String toString() {
		
	}
}
