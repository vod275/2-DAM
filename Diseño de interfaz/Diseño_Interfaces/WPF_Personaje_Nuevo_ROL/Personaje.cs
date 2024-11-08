using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media.Imaging;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace WPF23_Personaje_Nuevo_ROL 
{


     
public class Personaje : INotifyPropertyChanged
    {

  

    private string nombrePersonaje, clase, genero, foto;
    private int fuerza, inteligencia, destreza, resistencia;

 
    public string NombrePersonaje { get => nombrePersonaje; set { nombrePersonaje = value; PropertyChanged(this, new PropertyChangedEventArgs("NombrePersonaje")); } }


    public string Clase { get => clase; set { clase = value; PropertyChanged(this, new PropertyChangedEventArgs("Clase")); } }

    public string Genero { get => genero; set { genero = value; PropertyChanged(this, new PropertyChangedEventArgs("Genero")); } }
 
    public int Fuerza { get => fuerza; set { fuerza = value; PropertyChanged(this, new PropertyChangedEventArgs("Fuerza")); } }

    public int Inteligencia { get => inteligencia; set { inteligencia = value; PropertyChanged(this, new PropertyChangedEventArgs("Fuerza")); } }

     public int Destreza { get => destreza; set { destreza = value; PropertyChanged(this, new PropertyChangedEventArgs("Fuerza")); } }
    public int Resistencia { get => resistencia; set { resistencia = value; PropertyChanged(this, new PropertyChangedEventArgs("Fuerza")); } }

    public string Foto { get => foto; set { foto = value; PropertyChanged(this, new PropertyChangedEventArgs("Foto")); } }




    public Personaje( string nombrePersonaje, string clase, string genero, int fuerza, int inteligencia, int destreza, int resistencia, string foto)
        {
            this.nombrePersonaje = nombrePersonaje;
            this.clase = clase;
            this.genero = genero;
            this.fuerza = fuerza;
            this.inteligencia = inteligencia;
            this.destreza = destreza;
            this.resistencia = resistencia;
            this.foto = foto;
        }

        public Personaje() { }


    public event PropertyChangedEventHandler PropertyChanged = delegate { };
    }
}
