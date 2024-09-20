using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio4
{
    internal class SeriesArmonicas
    {

        static void Main(string[] args)
        {
            const int n = 5000;

            double sumaIzquierdaADerecha = 0.0;
            for (int i = 1; i <= n; i++)
            {
                sumaIzquierdaADerecha += 1.0 / i;
            }


            double sumaDerechaAizquierda = 0.0;
            for (int i = n; i >= 1; i--)
            {
                sumaDerechaAizquierda += 1.0 / i;
            }

            double diferencia = Math.Abs(sumaIzquierdaADerecha - sumaDerechaAizquierda);

            Console.WriteLine($"La suma de izquierda a derecha es {sumaIzquierdaADerecha}");
            Console.WriteLine($"La suma de derecha a izquierda es {sumaDerechaAizquierda}");
            Console.WriteLine($"La diferencia es: {diferencia}");
        }

    }
}
