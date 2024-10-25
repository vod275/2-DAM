using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WTF21_Personaje_Rol
{
    public class Inventario
    {
        public string NombreObjeto { get; set; }

        public int Fuerza { get; set; }

        public int Destreza { get; set; }

        public int Constitución { get; set; }

        public int Inteligencia { get; set; }

        public int Sabiduría { get; set; }

        public int Carisma { get; set; }

        public Inventario(string nombre, int fuerza, int destreza, int constitucion, int inteligencia, int sabiduria, int carisma)
        {
            NombreObjeto = nombre;
            Fuerza = fuerza;
            Destreza = destreza;
            Constitución = constitucion;
            Inteligencia = inteligencia;
            Sabiduría = sabiduria;
            Carisma = carisma;
        }

        public Inventario()
        {
        }
    }
}
