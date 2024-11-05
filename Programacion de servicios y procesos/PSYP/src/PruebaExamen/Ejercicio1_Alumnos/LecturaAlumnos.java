package PruebaExamen.Ejercicio1_Alumnos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LecturaAlumnos {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String nombre = "", edad;
		int Iedad = -1, numAlumnos = 0;
		String[] alumno = new String[2];
		String[] mayor = {"","0"};
		String[] menor = {"","99"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String[]> alumnos = new ArrayList<String[]>(); 
		do {
			Iedad = -1; nombre = "";
			System.out.println("Introduce el nombre: ");
			nombre = br.readLine();	
			while (nombre.trim().length()==0){
				System.out.println("Vuelve a introducir un nombre de longitud mayor a 0 y no vacio: ");
				nombre = br.readLine();	
			}
			if (!nombre.equals("*")) {
				System.out.println("Introduce la edad: ");
				edad = br.readLine();
				if (esNumero(edad)) Iedad = Integer.parseInt(edad);
				while (Iedad<1 || Iedad>99 || !esNumero(edad)) {
					System.out.println("Vuelve a introducir una edad entre 1 y 99: ");
					edad = br.readLine();
					if (esNumero(edad)) Iedad = Integer.parseInt(edad);
				}
				alumno[0] = nombre;
				alumno[1] = edad;
				alumnos.add(alumno);
				numAlumnos++;
				if (Iedad > Integer.parseInt(mayor[1])) {
					mayor[0] = alumno[0];
					mayor[1] = alumno[1];
				}
				if (Iedad < Integer.parseInt(menor[1])) {
					menor[0] = alumno[0];
					menor[1] = alumno[1];
				}
			}
		} while (!nombre.equals("*"));
		
		System.out.println ("fin");
		System.out.println("Se han introducido "+ numAlumnos +" alumnos.\nEl alumno con más edad es: "+mayor[0]+" con "+mayor[1]+" años.\nEl alumno con menos edad es: "+menor[0]+" con "+menor[1]+" años.");
	}

	public static boolean esNumero(String num) {
        boolean res = true;
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException excepcion) {
            res = false;
        }
        return res;
    }
	
}
