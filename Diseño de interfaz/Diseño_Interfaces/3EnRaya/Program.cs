using System;

class TresEnRaya
{
    static char[,] tablero = new char[3, 3];
    static char jugadorActual = 'X';

    static void Main()
    {
        InicializarTablero();
        bool juegoTerminado = false;

        while (!juegoTerminado)
        {
            Console.Clear();
            MostrarTablero();

            Console.WriteLine($"Turno del jugador: {jugadorActual}");
            Console.Write("Introduce la fila (1-3): ");
            int fila = int.Parse(Console.ReadLine()) - 1;

            Console.Write("Introduce la columna (1-3): ");
            int columna = int.Parse(Console.ReadLine()) - 1;

            if (EsMovimientoValido(fila, columna))
            {
                tablero[fila, columna] = jugadorActual;
                if (HayGanador())
                {
                    Console.Clear();
                    MostrarTablero();
                    Console.WriteLine($"¡Jugador {jugadorActual} ha ganado!");
                    juegoTerminado = true;
                }
                else if (TableroLleno())
                {
                    Console.Clear();
                    MostrarTablero();
                    Console.WriteLine("¡Es un empate!");
                    juegoTerminado = true;
                }
                else
                {
                    CambiarTurno();
                }
            }
            else
            {
                Console.WriteLine("Movimiento no válido. Intenta de nuevo.");
                Console.ReadKey();
            }
        }
    }

    static void InicializarTablero()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                tablero[i, j] = '-';
            }
        }
    }

    static void MostrarTablero()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Console.Write(tablero[i, j] + " ");
            }
            Console.WriteLine();
        }
    }

    static bool EsMovimientoValido(int fila, int columna)
    {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila, columna] == '-';
    }

    static void CambiarTurno()
    {
        jugadorActual = jugadorActual == 'X' ? 'O' : 'X';
    }

    static bool HayGanador()
    {
        // Comprobar filas y columnas
        for (int i = 0; i < 3; i++)
        {
            if ((tablero[i, 0] == jugadorActual && tablero[i, 1] == jugadorActual && tablero[i, 2] == jugadorActual) ||
                (tablero[0, i] == jugadorActual && tablero[1, i] == jugadorActual && tablero[2, i] == jugadorActual))
            {
                return true;
            }
        }

        // Comprobar diagonales
        if ((tablero[0, 0] == jugadorActual && tablero[1, 1] == jugadorActual && tablero[2, 2] == jugadorActual) ||
            (tablero[0, 2] == jugadorActual && tablero[1, 1] == jugadorActual && tablero[2, 0] == jugadorActual))
        {
            return true;
        }

        return false;
    }

    static bool TableroLleno()
    {
        foreach (char casilla in tablero)
        {
            if (casilla == '-')
                return false;
        }
        return true;
    }
}
