using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio6
{
    internal class ClasesArmonicas
    {
        static void Main(string[] args)
        {
            int n;
            Console.WriteLine("Introduce un numero");
            n = int.Parse(Console.ReadLine());
            

            double piAprox = 0.0;

            for (int i = 0; i < n; i++)
            {
                double termino = Math.Pow(-1, i) / (2 * i + 1);
                piAprox += termino;

            }

            piAprox *= 4;

            Console.WriteLine(piAprox);



        }
    }
}
