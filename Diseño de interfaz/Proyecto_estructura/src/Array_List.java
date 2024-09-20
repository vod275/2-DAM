import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Array_List {

	public static void main(String[] args) {
		
		// lo mismo pero con array list
		
			
		ArrayList<Cliente> cola = new ArrayList<>();
		
		Random random = new Random();
		
		int numeroPersonas = random.nextInt(51); 
		
		for (int i = 0; i < numeroPersonas; i++) {
			
			int edad = random.nextInt(56) + 5;
			Cliente persona = new Cliente(edad);
			cola.add(persona);
			
		}
				
		
		double recaudacionTotal = colaCine.calcularRecaudacion(cola);
        System.out.println("Número de personas en la cola: " + numeroPersonas);
        System.out.println("Recaudación total: " + recaudacionTotal + " euros");
	
	}
}
	
	class Cliente {
	    int edad;

	    public Cliente(int edad) {
	        this.edad = edad;
	    }

	    public int getEdad() {
	        return edad;
	    }
	}
	
	
	
	 class colaCine {

	    
	    public static double calcularRecaudacion(ArrayList<Cliente> cola) {
	        double recaudacion = 0;
	        
	         

	        while (!cola.isEmpty()) {
	        	Cliente persona = cola.removeFirst(); 
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
	 
