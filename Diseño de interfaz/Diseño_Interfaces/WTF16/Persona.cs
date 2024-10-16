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
        public int DeporteQuePractica { get; set; }
        public int Compra { get; set; }
        public int Tele { get; set; }
        public int Cine { get; set; }

        public Persona(string profesion, int numeroHermanos, string sexo, string edad, int deporteQuePractica, int compra, int tele, int cine)
        {
            Edad = edad;
            Profesion = profesion;
            NumeroHermanos = numeroHermanos;
            Sexo = sexo;
            DeporteQuePractica = deporteQuePractica;
            Compra = compra;
            Tele = tele;
            Cine = cine;
        }
    }
}
