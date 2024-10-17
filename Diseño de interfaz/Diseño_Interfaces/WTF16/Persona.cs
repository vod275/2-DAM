using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WTF16
{
    internal class Persona
    {
        

        public string Profesion { get; set; }
        public int NumeroHermanos { get; set; }
        public string Sexo { get; set; }
        public string Edad { get; set; }
        public string DeporteQuePractica { get; set; }  
        public int Compra { get; set; }
        public int Tele { get; set; }
        public int Cine { get; set; }

       

        public Persona() { }

        public Persona(string profesion, int numeroHermanos, string sexo, string edad, string deporteQuePractica, int compra, int tele, int cine)
        {
            Profesion = profesion;
            NumeroHermanos = numeroHermanos;
            Sexo = sexo;
            Edad = edad;
            DeporteQuePractica = deporteQuePractica;
            Compra = compra;
            Tele = tele;
            Cine = cine;
        }

      
        public override string ToString()
        {
            return $"Profesión: {Profesion}, Hermanos: {NumeroHermanos}, Sexo: {Sexo}, Edad: {Edad}, " +
                   $"Deporte: {DeporteQuePractica}, Compra: {Compra}, Televisión: {Tele}, Cine: {Cine}";
        }

    }
}
