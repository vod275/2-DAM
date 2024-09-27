using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda
{
    internal class Producto
    {
       
        public String nombre { get; set; }
        public double precio { get; set; }
        public int cantidad { get; set; }

        public Producto(string nombre, double precio, int cantidad)
        {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }




    }
}
