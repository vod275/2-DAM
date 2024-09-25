using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto01
{

    public class Rio
    {
        private ObjetoRío[,] matriz;
        private bool[,] revelado;
        private Random random;

        public Rio(int size)
        {
            
            matriz = new ObjetoRío[size, size];
            revelado = new bool[size, size];
            random = new Random();
            GenerarRío();
        }

        private void GenerarRío()
        {
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    matriz[i, j] = ObtenerElementoAleatorio();
                    revelado[i, j] = false;
                }
            }
        }

        private ObjetoRío ObtenerElementoAleatorio()
        {
            int valorAleatorio = random.Next(100);
            if (valorAleatorio < 50)
                return ObjetoRío.Pez; // 50% 
            else if (valorAleatorio < 75)
                return ObjetoRío.Agua; // 25% 
            else if (valorAleatorio < 93) 
                return ObjetoRío.RPiedra; // 18% 
            else
                return ObjetoRío.ÑPiraña; // 7% s
        }

        public ObjetoRío ObtenerElemento(int x, int y)
        {
            if (x < 0 || x >= 5 || y < 0 || y >= 5)
            {
                throw new IndexOutOfRangeException($"Te sales del 5 X 5");
            }
            revelado[x, y] = true;
            return matriz[x, y];
            
        }

        public void Reiniciar()
        {
            GenerarRío();
        }

        public void ImprimirRío()
        {
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    if (revelado[i, j])
                    {
                       
                        Console.Write($" {matriz[i, j].ToString()[0]} ");
                    }
                    else
                    {
                        Console.Write(" ? "); 
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
