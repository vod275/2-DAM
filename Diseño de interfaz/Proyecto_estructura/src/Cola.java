import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Cola {

	public static void main(String[] args) {
		
		// conjunto de personas que esperan en la cola, paraa sacar una entrada edad entre entre 0 y 50 personas
		// la edad es aleatoria entre 5 y 60
		//debemos mostrar la cantidad recaudada entre el numero de personas aleatorias
		// entre 5 y 10 años = 1
		// entre 11 y 17 = 2.5
		//mayor de 18 = 3.5
		//debemos utilizarlo como si fuera una cola pero con una lista enlazada
			
		Queue<Persona> cola = new LinkedList<>();
		
		Random random = new Random();
		
		int numeroPersonas = random.nextInt(51); 
		
		for (int i = 0; i < numeroPersonas; i++) {
			
			int edad = random.nextInt(56) + 5;
			Persona persona = new Persona(edad);
			cola.add(persona);
			
		}
				
		
		double recaudacionTotal = SimulacionCola.calcularRecaudacion(cola);
        System.out.println("Número de personas en la cola: " + numeroPersonas);
        System.out.println("Recaudación total: " + recaudacionTotal + " euros");
	
	}
}
	
	class Persona {
	    int edad;

	    public Persona(int edad) {
	        this.edad = edad;
	    }

	    public int getEdad() {
	        return edad;
	    }
	}
	
	
	
	 class SimulacionCola {

	    
	    public static double calcularRecaudacion(Queue<Persona> cola) {
	        double recaudacion = 0;
	        
	         

	        while (!cola.isEmpty()) {
	        	Persona persona = cola.poll(); 
	            int edad = persona.getEdad();
	            double pago = 0;
	                        
	            if (edad >= 5 && edad <= 10) {
	            	pago += 1;
	            } else if (edad >= 11 && edad <= 17) {
	            	pago += 2.5;
	            } else if (edad >= 18) {
	            	pago += 3.5;
	            }
	            System.out.println("Persona de " + edad + " años paga: " + pago + " euros");
	            
	            recaudacion += pago;
	        }
	        return recaudacion;
	    }
	}
	 

