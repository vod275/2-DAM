using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio3
{
    internal class NumeroImpar
    {

        static void Main(string[] args)
        {
            int numero;
            Console.WriteLine("Dime un numero");
            numero = int.Parse(Console.ReadLine());
            

            if (numero % 2 == 0)
            {
                Console.WriteLine("PASS");
            }
            else
            {
                Console.WriteLine("FAIL");
            }
        }
    }
}
