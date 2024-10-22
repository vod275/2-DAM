using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WTF16
{
    public class Persona
    {
        

        public string nombre { get; set; }
        public string apellidos { get; set; }
        public int edad { get; set; }


       

  

        public Persona(string nombre, string apellidos, int edad)
        {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.edad = edad;
        }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Apellidos
        {
            get => apellidos; set => apellidos =
        value;
        }
        public int Edad { get => edad; set => edad = value; }
    }
}
