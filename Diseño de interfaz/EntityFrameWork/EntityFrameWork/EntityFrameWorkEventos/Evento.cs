using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntityFrameWorkEventos
{
    public class Evento
    {
        public int Id { get; set; }
        public string Nombre { get; set; } = null!;
        public List<Persona> Personas { get; set; } = new List<Persona>();

        public override string ToString()
        {
            return Nombre;
        }

    }

    
}
