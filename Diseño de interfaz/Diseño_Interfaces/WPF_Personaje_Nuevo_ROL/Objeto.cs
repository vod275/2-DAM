using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPF23_Personaje_Nuevo_ROL
{
    internal class Objeto
    {
     

        public string NombreObjeto { get; set; }
        public string TipoObjeto { get; set; }

        public int FuerzaObjeto { get; set; }
        public int InteligenciaObjeto { get; set; }
        public int DestrezaObjeto { get; set; }
        public int ResistenciaObjeto { get; set; }
        public bool Equipado { get; set; }


        public Objeto(string nombreObjeto, string tipoObjeto, int fuerzaObjeto, int inteligenciaObjeto, int destrezaObjeto, int resistenciaObjeto, bool equipado)
        {
            NombreObjeto = nombreObjeto;
            TipoObjeto = tipoObjeto;
            FuerzaObjeto = fuerzaObjeto;
            InteligenciaObjeto = inteligenciaObjeto;
            DestrezaObjeto = destrezaObjeto;
            ResistenciaObjeto = resistenciaObjeto;
            Equipado = equipado;
        }

        public void Equipar()
        {
            Equipado = true;
        }

        public void Desequipar()
        {
            Equipado = false;
        }

        public override string ToString()
        {
            return $"{NombreObjeto} - {TipoObjeto} - " +
                   $"Fuerza: {FuerzaObjeto}, Inteligencia: {InteligenciaObjeto}, " +
                   $"Destreza: {DestrezaObjeto}, Resistencia: {ResistenciaObjeto} - " +
                   $"{(Equipado ? "Equipado" : "No Equipado")}";
        }

    }
}
