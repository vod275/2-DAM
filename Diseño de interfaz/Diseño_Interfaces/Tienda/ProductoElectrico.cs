using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda
{
    internal class ProductoElectrico : Producto
    {

        public int garantia { get; set; } 
    
        public ProductoElectrico(string nombre, double precio, int cantidad, int garantia) : base(nombre, precio, cantidad)
        {
             this.garantia = garantia;
        }

        

    }
}
