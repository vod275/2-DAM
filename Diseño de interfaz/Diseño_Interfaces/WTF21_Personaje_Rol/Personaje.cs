using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WTF21_Personaje_Rol
{
    public class Personaje
    {
     

        public string Nombre { get; set; }
        public string Genero { get; set; }
        public string Clase { get; set; }
        public int Fuerza { get; set; }
        public int Destreza { get; set; }
        public int Constitución { get; set; }
        public int Inteligencia { get; set; }
        public int Sabiduría { get; set; }
        public int Carisma {  get; set; }
        public ObservableCollection<Inventario> Objetos { get; set; }

        public string ImagenRuta { get; set; }
        public Personaje(string nombre, string genero, string clase, int fuerza, int destreza, string imagenRuta, int constitucion, int inteligencia, int sabiduria, int carisma)
        {
            Nombre = nombre;
            Genero = genero;
            Clase = clase;
            Fuerza = fuerza;
            Destreza = destreza;
            Constitución = constitucion;
            Inteligencia = inteligencia;
            Sabiduría = sabiduria;
            Carisma = carisma;
            ImagenRuta = imagenRuta;
            Objetos = new ObservableCollection<Inventario>();
        }

        public Personaje()
        {
        }
    }
}
