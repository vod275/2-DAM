using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace WTF03
{
    internal class Unidades
    {


        public string Unidad {  get; set; }

        public Unidades(string unidad)
        {
            this.Unidad = unidad;
        }

        public override string ToString()
        {
            return this.Unidad;
        }

    }
}
