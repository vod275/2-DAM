using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPF23_Entity_Frame_Work_DIFICIL
{
    public class Persona
    {
        public int Id { get; set; }
        public string Nombre { get; set; } = string.Empty;
        public int Edad { get; set; }
        public ICollection<Eventos> Eventos { get; } = new List<Eventos>();
        //public ICollection<PersonaEvento> PersonasEventos { get; } = new List<PersonaEvento>();

    }
}
