package matrices;

public class sumarMatrices {

	public static void main(String[] args) {
		
		int[][] matriz = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}

		};
		
		 int suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				
				System.out.print(matriz[i][j] + "\t");
				suma += matriz[i][j];
			}
			
			System.out.println();
			
		}

		System.out.println("La suma de los elementos de la matriz es: " + suma);
	}

}
