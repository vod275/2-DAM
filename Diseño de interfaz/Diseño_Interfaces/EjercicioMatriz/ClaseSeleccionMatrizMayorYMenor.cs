using System;

namespace EjercicioMatriz
{
    internal class ClaseSeleccionMatrizMayorYMenor
    {
        static void Main(String[] args)
        {
            int[,] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };

        
            int max = int.MinValue;
            int min = int.MaxValue;
            (int, int) posMax = (0, 0);
            (int, int) posMin = (0, 0);


            for (int i = 0; i < matriz.GetLength(0); i++)
            {
                for (int j = 0; j < matriz.GetLength(1); j++)
                {

                    if (matriz[i, j] > max)
                    {
                        max = matriz[i, j];
                        posMax = (i, j);
                    }

                    if (matriz[i, j] < min)
                    {
                        min = matriz[i, j];
                        posMin = (i, j);
                    }
                }
            }


            Console.WriteLine($"\nNúmero mayor: {max} en posicion ({posMax.Item1}, {posMax.Item2})");
            Console.WriteLine($"Número menor: {min} en posicion ({posMin.Item2}, {posMin.Item2})");
        }
    }
}
