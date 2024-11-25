using System;

class CineReservas
{
    static void Main(String[] args)
    {

        Console.Write("Ingrese el numero de filas de la sala: ");
        int filas = int.Parse(Console.ReadLine());

        Console.Write("Ingrese el numero de columnas de la sala: ");
        int columnas = int.Parse(Console.ReadLine());

        char[,] sala = new char[filas, columnas];
        InicializarSala(sala);

        bool continuar = true;

        while (continuar)
        { 
            Console.WriteLine("\n--- Menú de opciones ---");
            Console.WriteLine("1. Reservar un asiento");
            Console.WriteLine("2. Cancelar una reserva");
            Console.WriteLine("3. Mostrar los asientos disponibles");
            Console.WriteLine("4. Reservar una fila completa");
            Console.WriteLine("5. Buscar las áreas más libres");
            Console.WriteLine("6. Salir");
            Console.Write("Seleccione una opción: ");
            int opcion = int.Parse(Console.ReadLine());

            switch (opcion)
            {
                case 1:
                    ReservarAsiento(sala);
                    break;
                case 2:
                    CancelarReserva(sala);
                    break;
                case 3:
                    MostrarSala(sala);
                    break;
                case 4:
                    ReservarFilaCompleta(sala);
                    break;
                case 5:
                    BuscarAreasLibres(sala);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    Console.WriteLine("Opcion no válida. Intentelo de nuevo");
                    break;
            }
        }

        Console.WriteLine("Adios");
    }

    static void InicializarSala(char[,] sala)
    {
        for (int i = 0; i < sala.GetLength(0); i++)
        {
            for (int j = 0; j < sala.GetLength(1); j++)
            {
                sala[i, j] = 'V';
            }
        }
    }

    static void ReservarAsiento(char[,] sala)
    {
        Console.Write("Ingrese el numero de fila: ");
        int fila = int.Parse(Console.ReadLine()) - 1;
        Console.Write("Ingrese el numero de columna: ");
        int columna = int.Parse(Console.ReadLine()) - 1;

        if (EsValido(sala, fila, columna))
        {
            if (sala[fila, columna] == 'V')
            {
                sala[fila, columna] = 'O';
                Console.WriteLine("Asiento reservado con exito.");
            }
            else
            {
                Console.WriteLine("El asiento ya está ocupado.");
            }
        }
    }

    static void CancelarReserva(char[,] sala)
    {
        Console.Write("Ingrese el numero de fila: ");
        int fila = int.Parse(Console.ReadLine()) - 1;
        Console.Write("Ingrese el numero de columna: ");
        int columna = int.Parse(Console.ReadLine()) - 1;

        if (EsValido(sala, fila, columna))
        {
            if (sala[fila, columna] == 'O')
            {
                sala[fila, columna] = 'V';
                Console.WriteLine("Reserva cancelada con éxito.");
            }
            else
            {
                Console.WriteLine("El asiento ya está vacio.");
            }
        }
    }

    static void MostrarSala(char[,] sala)
    {
        Console.WriteLine("Estado actual de la sala:");
        for (int i = 0; i < sala.GetLength(0); i++)
        {
            for (int j = 0; j < sala.GetLength(1); j++)
            {
                Console.Write(sala[i, j] + " ");
            }
            Console.WriteLine();
        }
    }

    static void ReservarFilaCompleta(char[,] sala)
    {
        Console.Write("numero de fila a reservar: ");
        int fila = int.Parse(Console.ReadLine()) - 1;

        if (fila >= 0 && fila < sala.GetLength(0))
        {
            bool filaLibre = true;
            for (int j = 0; j < sala.GetLength(1); j++)
            {
                if (sala[fila, j] != 'V')
                {
                    filaLibre = false;
                    break;
                }
            }

            if (filaLibre)
            {
                for (int j = 0; j < sala.GetLength(1); j++)
                {
                    sala[fila, j] = 'O';
                }
                Console.WriteLine("Fila reservada con exito.");
            }
            else
            {
                Console.WriteLine("La fila no esta completamente libre");
            }
        }
        else
        {
            Console.WriteLine("Fila invalida.");
        }
    }

    static void BuscarAreasLibres(char[,] sala)
    {
        int maxVacios = 0;
        int filaMax = -1;

        for (int i = 0; i < sala.GetLength(0); i++)
        {
            int vacios = 0;
            for (int j = 0; j < sala.GetLength(1); j++)
            {
                if (sala[i, j] == 'V')
                {
                    vacios++;
                }
            }

            if (vacios > maxVacios)
            {
                maxVacios = vacios;
                filaMax = i;
            }
        }

        if (filaMax >= 0)
        {
            Console.WriteLine($"La fila con más asientos vacíos es la fila {filaMax + 1} con {maxVacios} asientos libres");
        }
        else
        {
            Console.WriteLine("No hay asientos vacios");
        }
    }

    static bool EsValido(char[,] sala, int fila, int columna)
    {
        if (fila >= 0 && fila < sala.GetLength(0) && columna >= 0 && columna < sala.GetLength(1))
        {
            return true;
        }
        else
        {
            Console.WriteLine("Posición inválida. Inténtelo de nuevo");
            return false;
        }
    }
}
