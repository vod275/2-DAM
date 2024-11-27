using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPF22_EntityFrameWork
{
    public class Mascotas
    {
        public int id { get; set; }
        public string nombre { get; set; }
        public string tipo { get; set; }

        public int personaid {get; set; }

        public Persona persona { get; set; } = null;

    }
}
