
public class Clase_16 {

	public static void main(String[] args) {
		// Del siguiente frase "La lluvia de sevilla es una maravilla" cuenta cuantas vocales hay en total
		// recorre el string con charAt
		
		        
		        String frase = "La lluvia de sevilla es una maravilla";		        
		     
		        int contarVocales = 0;
		        		       
		        frase = frase.toLowerCase();
		        		        
		        for (int i = 0; i < frase.length(); i++) {
		            char caracter = frase.charAt(i);
		            
		            
		            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
		            	contarVocales++;
		            }
		        }
		        		        
		        System.out.println("Número total de vocales: " + contarVocales);
		    }

}
