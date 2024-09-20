using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio2
{
    internal class EjercicioSumas
    {
        static void Main(string[] args)
        {

            double cotaSuperior = 100;

         
            double suma = 0;
            double media;
           

           
            for (int i = 1; i <= cotaSuperior; i++)
            {
                suma += i;
            }
            

            media = suma  / cotaSuperior;

            Console.WriteLine(media);
        }
    }
}
