using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media.Imaging;

namespace WPF23_Personaje_Nuevo_ROL
{
    public class Personaje
    {

        public string NombrePersonaje { get; set; }
        public string Clase { get; set; }
        public string Genero { get; set; }
        public int Fuerza { get; set; }
        public int Inteligencia { get; set; }
        public int Destreza { get; set; }
        public int Resistencia { get; set; }
        public string Foto { get; set; }

        public Personaje(string nombrePersonaje, string clase, string genero, int fuerza, int inteligencia, int destreza, int resistencia, string foto)
        {
            NombrePersonaje = nombrePersonaje;
            Clase = clase;
            Genero = genero;
            Fuerza = fuerza;
            Inteligencia = inteligencia;
            Destreza = destreza;
            Resistencia = resistencia;
            Foto = foto;
        }

        public Personaje() { }
            
    }
}
