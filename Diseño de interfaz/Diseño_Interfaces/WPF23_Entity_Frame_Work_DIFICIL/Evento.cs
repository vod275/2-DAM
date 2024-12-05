using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace WPF23_Entity_Frame_Work_DIFICIL
{
    public class Evento
    {
        public int id {  get; set; }

        public string nombre { get; set; } = string.Empty;

        public List<Persona> Personas { get; } = new List<Persona>();

        public override string ToString()
        {
            return nombre;
        }


    }
}
