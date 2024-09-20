using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio9
{
    internal class Class1
    {
        static void Main(string[] args)
        {
            // Lista para almacenar los objetos Dia correspondientes a los días de la semana
            List<Dia> diasSemana = new List<Dia>()
        {
            new Dia("Lunes"),
            new Dia("Martes"),
            new Dia("Miércoles"),
            new Dia("Jueves"),
            new Dia("Viernes"),
            new Dia("Sábado"),
            new Dia("Domingo")
        };

            // Pedir la temperatura para cada día
            foreach (Dia dia in diasSemana)
            {
                dia.EstablecerTemperatura(); // Llamar al método para introducir la temperatura
            }

            // Mostrar todas las temperaturas ingresadas
            Console.WriteLine("\nTemperaturas ingresadas:");
            foreach (Dia dia in diasSemana)
            {
                Console.WriteLine($"{dia.Nombre}: {dia.Temperatura}°C");
            }
        }
    }  
}
