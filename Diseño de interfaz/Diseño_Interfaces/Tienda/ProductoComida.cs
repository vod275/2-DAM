using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda
{
    internal class ProductoComida : Producto
    {

        public DateTime fechaCaducidad { get; set; }
        public ProductoComida(string nombre, double precio, int cantidad,  DateTime fechaCaducidad) : base(nombre, precio, cantidad)
        {
            this.fechaCaducidad = fechaCaducidad;
        }

       



    }
}
