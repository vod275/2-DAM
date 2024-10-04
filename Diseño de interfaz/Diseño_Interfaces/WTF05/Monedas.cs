using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WTF05
{
    internal class Monedas
    {


        public string Moneda { get; set; }

        public Monedas(string unidad)
        {
            this.Moneda = unidad;
        }

        public override string ToString()
        {
            return this.Moneda;
        }
    }
}
