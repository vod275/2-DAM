using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ViewModel
{
    public class Persona
    {

        public string Nombre { get; set; }
        public int Edad { get; set; }


        public override string ToString()
        {
            return $"{Nombre}: {Edad}";
        }

    }
}
