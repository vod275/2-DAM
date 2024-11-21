using System;

namespace MultiplicarMatrices
{
    internal class MultiplicarMatrices
    {
        static void Main(String[] args)
        {
            int[,] matriz = {
                {5, 6, 2},
                {0, 3, 4},
                {1, 8, 1}
            };

            int[,] matriz2 = {
                {0, 3, 6},
                {1, 4, 0},
                {8, 9, 1}
            };
            


            int[,] resultado = new int[matriz.GetLength(0), matriz2.GetLength(1)];

       
            for (int i = 0; i < matriz.GetLength(0); i++)
            {
                for (int j = 0; j < matriz2.GetLength(1); j++)
                {
                    for (int k = 0; k < matriz.GetLength(1); k++)
                    {
                        resultado[i, j] += matriz[i, k] * matriz2[k, j];
                    }
                }
            }

          
            Console.WriteLine("La multiplicacion es:");
            for (int i = 0; i < matriz.GetLength(0); i++)
            {
                for (int j = 0; j < matriz.GetLength(1); j++)
                {
                    Console.Write($"{resultado[i, j],4}");
                }
                Console.WriteLine();
            }
        }
    }
}
