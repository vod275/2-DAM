using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio12
{
    internal class Class1
    {
        //Tiene que que hacer que en la fila 0 columna 0 se dibujeun circulo y luego viendo las variables
        // ir moviendo ese cero y que se imprima otra vez las x pero en la fila que antes habia un 0 ahora una x y asi 
        // dependendo de donde nos queramos mover con el 0

        static void Main(String[] args)
        {
            int size = 4;
            int posX = 0; // Posición inicial del círculo
            int posY = 0;
            string w;
            string a;
            string s;
            string d;

            char[,] matriz = new char[4, 4];
            for (int i = 0; i < size;  i++)
            {
                
                for (int j = 0; j < size; j++)
                {

                    Console.Write(" X ");
                    
                   
                }
                Console.Write("|");
                Console.WriteLine();
            }
            matriz[0, 0] = 'O';

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

                matriz[posX, posY] = 'O'; // Colocar el círculo en la nueva posición
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
