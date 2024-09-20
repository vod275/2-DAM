using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio7
{
    internal class multiplicacionDel1al9
    {
        //escribe un programa que muestre multiplicacion por consola con las tablas de multiplicar del 1 al 9 usando bubles anidados
        static void Main(string[] args)
        {
            // Bucle externo para recorrer los números del 1 al 9
            for (int i = 1; i <= 9; i++)
            {
                // Bucle (i) por los números del 1 al 9
                for (int j = 1; j <= 9; j++)
                {

                    Console.Write($"{i * j,4}");
                }

                Console.WriteLine();
            }
        }
    }
}
