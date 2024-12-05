using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntityFrameWorkEventos
{
    public class PersonaEvento
    {
        public int personasId {  get; set; }
        public int eventosId { get; set; }
        public Persona persona { get; set; } = null!;
        public Evento evento { get; set; } = null!;
    }
}
