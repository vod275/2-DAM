using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio9
{
    class Dia
    {
        public string Nombre { get; set; }
        public double Temperatura { get; set; }

        public Dia(string nombre)
        {
            Nombre = nombre;
        }

        public void EstablecerTemperatura()
        {
            double temperatura;

            // Bucle que asegura que la temperatura esté en el rango adecuado
            while (true)
            {
                Console.Write($"Introduce la temperatura para {Nombre} (-50°C a 50°C): ");

                // Intentar convertir la entrada a un número double
                if (double.TryParse(Console.ReadLine(), out temperatura))
                {
                    // Verificar si la temperatura está dentro del rango permitido
                    if (temperatura >= -50 && temperatura <= 50)
                    {
                        Temperatura = temperatura; // Asignar la temperatura si es válida
                        break; // Salir del bucle
                    }
                    else
                    {
                        Console.WriteLine("Error: La temperatura debe estar entre -50°C y 50°C. Inténtalo de nuevo.");
                    }
                }
                else
                {
                    Console.WriteLine("Error: Entrada no válida. Introduce un número válido.");
                }
            }
        }
    }
}
