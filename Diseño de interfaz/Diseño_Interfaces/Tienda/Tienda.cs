using Proyecto01;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda
{
    internal class Tienda
    {
    

        public List<Producto> Productos { get; set; }

        public List<Orden> Ordenes { get; set; }


        public Tienda(List<Producto> productos, List<Orden> ordenes)
        {
            Productos = productos;
            Ordenes = ordenes;
        }


    }
}
