using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tienda;

namespace Proyecto01
{
    class Orden
    {
       

        public List<Producto> ordenList {  get; set; }
        public decimal total { get; set;}

        public Cliente cliente { get; set; }

        public Orden(List<Producto> ordenList, decimal total, Cliente cliente)
        {
            this.ordenList = ordenList;
            this.total = total;
            this.cliente = cliente;
        }
    }
}
