package Tema1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrimosHijo {

	   public static void main(String[] args) {
	        try {
	            
	            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	            String[] valores = br.readLine().split(" ");
	            int N = Integer.parseInt(valores[0]);
	            int M = Integer.parseInt(valores[1]);

	            
	            for (int i = N; i <= M; i++) {
	                if (esPrimo(i)) {
	                    System.out.println(i);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static boolean esPrimo(int num) {
	        if (num < 2) return false;
	        for (int i = 2; i <= Math.sqrt(num); i++) {
	            if (num % i != 0) {
	                return false;
	            }
	        }
	        return true;
	    }

}
