
    
 using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio10
{
        internal class JuegoAdivinar
        {

            static void Main(string[] args)
            {
                Random random = new Random();
                int numeroAleatorio = random.Next(1, 101);

                //LIsta para guardar los números que el usuario introduce
                List<(int numero, bool esCorrecto)> intentos = new List<(int, bool)>();

                int intentosRealizados = 0;
                bool acertado = false;

                Console.WriteLine("Bienvenido al juego");
                Console.WriteLine("Tienes 10 intentos para adivinar el numero");


                while (!acertado && intentos.Count() < 10)
                {

                    Console.Write($"Intento {intentosRealizados + 1}: Ingresa tu número: ");
                    int intento;
                    bool esNumero = int.TryParse(Console.ReadLine(), out intento);

                    if (esNumero && intento >= 1 && intentosRealizados <= 100)
                    {

                        intentosRealizados++;

                        if (intento == numeroAleatorio)
                        {
                            Console.WriteLine("Enhorabuenaaaaaaa");
                            acertado = true;
                            intentos.Add((intento, true));
                        }
                        else
                        {
                            if (intento < numeroAleatorio)
                            {
                                Console.WriteLine("El numero es mayor");
                            }
                            else
                            {
                                Console.WriteLine("El numero es menor");
                            }
                            intentos.Add((intento, false));
                        }

                    }
                    Console.WriteLine("Por favor, ingresa un número válido entre 1 y 100.");

                }

                Console.WriteLine("\n--- Resultados del juego ---");
                foreach (var intento in intentos)
                {
                    string resultado = intento.esCorrecto ? "Correcto" : "Incorrecto";
                    Console.WriteLine($"Número dicho: {intento.numero} - {resultado}");
                }


                if (!acertado)
                {
                    Console.WriteLine($"Lo siento, has agotado tus 10 intentos. El número era {numeroAleatorio}.");
                }
                else
                {
                    Console.WriteLine($"¡Lo lograste en {intentosRealizados} intentos!");
                }
            }
        }
    }

