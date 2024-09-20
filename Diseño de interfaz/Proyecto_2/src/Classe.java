import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

public class Classe {

	public static void main(String[] args) {
		// repasar push pop que es
		// enlace youtube pila https://www.youtube.com/watch?v=xPjdXbrdVhk
		// importar lista y probar a crear un metodo y que lo busque
		
		ArrayList<String> colors = new ArrayList<>();
        colors.add("blue");
        colors.add("red");
        colors.add("green");
        System.out.println("ArrayList: " + colors);
				
     // Crear un ArrayList de Element
        ArrayList<Element> arrayList = new ArrayList<>();
        
        // Crear un array de Element
        Element[] array = {new Element(1), new Element(2), new Element(3)};
        
        // Añadir los elementos del array al ArrayList
        for (Element element : array) {
            arrayList.add(element);
        }
        
        // Mostrar los elementos del ArrayList
        for (Element element : arrayList) {
            System.out.println(element);
        }
		
		
	}

}
