using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto01
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int size = 5; 
            Rio rio = new Rio(size);
            Pinocho pinocho = new Pinocho();


            while(pinocho.Peces < 10)
            {
                Console.Clear();
                rio.ImprimirRio(size, size);
                Console.WriteLine($"Contador de peces: {pinocho.Peces}");

                ObjetoRio objetoActual = rio.ObtenerElemento(pinocho.Posición.x, pinocho.Posición.y);
                Console.WriteLine($"El objeto es: {objetoActual}");

                Console.WriteLine("W = Arriba");
                Console.WriteLine("A = Izquierda");
                Console.WriteLine("D = Derecha");
                Console.WriteLine("S = Abajo");
                Console.WriteLine("Esc = Salir");
                var key = Console.ReadKey(true).Key;

                switch(key) 
                {
                    
                    case ConsoleKey.W:

                        pinocho.Mover(pinocho.Posición.x - 1, pinocho.Posición.y, rio);
                        break;

                    case ConsoleKey.A:

                        pinocho.Mover(pinocho.Posición.x, pinocho.Posición.y - 1, rio);
                        break;

                    case ConsoleKey.S:

                        pinocho.Mover(pinocho.Posición.x + 1, pinocho.Posición.y, rio);
                        break;

                    case ConsoleKey.D:

                        pinocho.Mover(pinocho.Posición.x, pinocho.Posición.y +1, rio);
                        break;

                    case ConsoleKey.Escape:

                        return;
                }
            }

            Console.WriteLine("HAS GANADO ERES EL PUTO AMO");
            pinocho = new Pinocho();


        }
    }
}
