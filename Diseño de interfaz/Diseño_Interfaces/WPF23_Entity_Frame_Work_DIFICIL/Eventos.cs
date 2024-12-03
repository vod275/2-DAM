using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPF23_Entity_Frame_Work_DIFICIL
{
    public class Eventos
    {
        public int id {  get; set; }

        public string nombre { get; set; } = string.Empty;

        public List<Persona> Personas { get; } = new List<Persona>();

        //public ICollection<Persona> Mascotas { get; } = new List<Persona>();
        public List<PersonaEvento> PersonasEventos { get; } = new List<PersonaEvento>();


    }
}
