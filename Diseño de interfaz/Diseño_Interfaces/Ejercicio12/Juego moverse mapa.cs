using System;

namespace Ejercicio12
{
    internal class Class1
    {
        static void Main(String[] args)
        {
            int size = 4;
            int posX = 0; 
            int posY = 0;

            // Inicializar la matriz
            char[,] matriz = new char[size, size];

            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    matriz[i, j] = 'X'; // Llenar la matriz con 'X'
                }
            }

            matriz[posX, posY] = 'O'; // Colocar 'O' en la posición inicial

            while (true)
            {
                Console.Clear();
                ImprimirMatriz(matriz);
                Console.WriteLine("W = Arriba");
                Console.WriteLine("A = Izquierda");
                Console.WriteLine("D = Derecha");
                Console.WriteLine("S = Abajo");
                Console.WriteLine("Esc = Salir");

                var key = Console.ReadKey(true).Key;

                //guardamos la pesicion de la x
                matriz[posX, posY] = 'X';

                switch (key)
                {
                    case ConsoleKey.W:
                        if (posX > 0) posX--;
                        break;
                    case ConsoleKey.A:
                        if (posY > 0) posY--;
                        break;
                    case ConsoleKey.D:
                        if (posY < size - 1) posY++;
                        break;
                    case ConsoleKey.S:
                        if (posX < size - 1) posX++;
                        break;
                    case ConsoleKey.Escape:
                        return;
                }

                // O en la nueva posicion
                matriz[posX, posY] = 'O';
            }
        }

        static void ImprimirMatriz(char[,] matriz)
        {
            for (int i = 0; i < matriz.GetLength(0); i++)
            {
                for (int j = 0; j < matriz.GetLength(1); j++)
                {
                    Console.Write(" " + matriz[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
    }
}