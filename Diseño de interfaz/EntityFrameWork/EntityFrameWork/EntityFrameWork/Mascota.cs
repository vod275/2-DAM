using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntityFrameWork
{
    public class Mascota
    {

        public int Id { get; set; }
        public string Nombre { get; set; } = null! ;
        public string Tipo { get; set; } = null!;
        public int personaId { get; set; }
        public Persona persona { get; set; } = null!;


    }
}
