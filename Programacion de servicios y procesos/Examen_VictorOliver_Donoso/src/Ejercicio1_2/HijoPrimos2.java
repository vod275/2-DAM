package Ejercicio1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HijoPrimos2 {

	public static void main(String[] args) throws IOException {
		
		int numero  = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(args[0]);
		
		if(HijoPrimos.DivisibleEntre5(numero)) {
			System.out.println("PARiendo primos");
		}
		else {
			System.out.print("“sIMPARticos primos tengo");
		}

	}
}


