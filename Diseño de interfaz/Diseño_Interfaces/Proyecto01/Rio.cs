using Proyecto01;

public class Rio
{
    private ObjetoRio[,] matriz;
    private bool[,] revelado; // Matriz de revelado para controlar qué se muestra
    private int size;
    private Random random;

    public Rio(int size)
    {
        this.size = size;
        matriz = new ObjetoRio[size, size];
        revelado = new bool[size, size];
        random = new Random();
        GenerarRío();
    }

    // Método para generar el río
    private void GenerarRío()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                int prob = random.Next(100);
                if (prob < 50)
                    matriz[i, j] = ObjetoRio.Pez;
                else if (prob < 70)
                    matriz[i, j] = ObjetoRio.Agua;
                else if (prob < 80)
                    matriz[i, j] = ObjetoRio.XPiedra;
                else
                    matriz[i, j] = ObjetoRio.RPiraña;

                revelado[i, j] = false; // Inicialmente todas las casillas están ocultas
            }
        }
    }

    //este metodo hace que cuando pasas por un espacio, lo convierta en agua para que no puntue doble
    //Tambien cambia la letra de P a A para saber cuantos peces llevas hay que mirar el contador de abajo
    public void MarcarVisitado(int x, int y)
    {
        revelado[x, y] = true; // Marcar la celda como revelada
    }

    // Obtener el elemento en la posición dada
    public ObjetoRio ObtenerElemento(int x, int y)
    {
        return matriz[x, y];
    }

    // Verificar si una celda ha sido revelada
    public bool EsRevelado(int x, int y)
    {
        return revelado[x, y];
    }

    // Método para imprimir el estado del río
    public void ImprimirRio(int posX, int posY)
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (i == posX && j == posY)
                {
                    Console.Write(" O "); 
                }
                else if (revelado[i, j])
                {
                    Console.Write($" {ObtenerObjeto(matriz[i, j])} ");
                }
                else
                {
                    Console.Write(" ? "); 
                }
            }
            Console.WriteLine();
        }
    }

    private char ObtenerObjeto(ObjetoRio objeto)
    {
        switch (objeto)
        {
            case ObjetoRio.Agua:
                return 'A';
            case ObjetoRio.XPiedra:
                return 'X';
            case ObjetoRio.Pez:
                return 'P'; 
            case ObjetoRio.RPiraña:
                return 'R'; 
            default:
                return '?';
        }
    }
}



