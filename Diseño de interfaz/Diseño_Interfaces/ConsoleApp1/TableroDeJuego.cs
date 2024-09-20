using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio11
{
    internal class TableroDeJuego
    {

         static void Main(String[] args)
        {

            int[,] matriz =  {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

        };

            int suma = 0;
            for (int i = 0; i < matriz.GetLength(0); i++)
            {
                for (int j = 0; j < matriz.GetLength(1); j++)
                {

                    Console.WriteLine($"{matriz[i, j],4}");
                    suma += matriz[i, j];
                }

                Console.WriteLine();

            }

            Console.WriteLine("La suma de los elementos de la matriz es: " + suma);
        }

    }
}
