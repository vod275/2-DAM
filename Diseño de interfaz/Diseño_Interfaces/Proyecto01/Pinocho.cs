using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto01
{
    internal class Pinocho
    {

        public int Peces { get;  set; }
        public (int x, int y) Posición { get;  set; }


        public Pinocho()
        {
            Peces = 0;
            Posición = (0, 0);
        }

        public void Mover(int x, int y, Rio rio)
        {

            if (x < 0 || x > 5 || y < 0 || y > 5) return;

            Posición = (x, y);

            ObjetoRío objeto = rio.ObtenerElemento(x, y);

            switch (objeto)
            {
                case ObjetoRío.Pez:
                    Peces++;
                    break;
                case ObjetoRío.ÑPiraña:
                    Peces = 0; 
                    break;
            }

        }
    }
}
