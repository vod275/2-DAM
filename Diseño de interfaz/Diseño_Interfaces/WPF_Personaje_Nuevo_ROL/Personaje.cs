using System.ComponentModel;

namespace WPF23_Personaje_Nuevo_ROL
{
    public class Personaje : INotifyPropertyChanged
    {
        private string nombrePersonaje, clase, genero, foto;
        private int fuerza, inteligencia, destreza, resistencia;

        public string NombrePersonaje
        {
            get => nombrePersonaje;
            set
            {
                if (nombrePersonaje != value)
                {
                    nombrePersonaje = value;
                    OnPropertyChanged(nameof(NombrePersonaje));
                }
            }
        }

        public string Clase
        {
            get => clase;
            set
            {
                if (clase != value)
                {
                    clase = value;
                    OnPropertyChanged(nameof(Clase));
                }
            }
        }

        public string Genero
        {
            get => genero;
            set
            {
                if (genero != value)
                {
                    genero = value;
                    OnPropertyChanged(nameof(Genero));
                }
            }
        }

        public int Fuerza
        {
            get => fuerza;
            set
            {
                if (fuerza != value)
                {
                    fuerza = value;
                    OnPropertyChanged(nameof(Fuerza));
                }
            }
        }

        public int Inteligencia
        {
            get => inteligencia;
            set
            {
                if (inteligencia != value)
                {
                    inteligencia = value;
                    OnPropertyChanged(nameof(Inteligencia));
                }
            }
        }

        public int Destreza
        {
            get => destreza;
            set
            {
                if (destreza != value)
                {
                    destreza = value;
                    OnPropertyChanged(nameof(Destreza));
                }
            }
        }

        public int Resistencia
        {
            get => resistencia;
            set
            {
                if (resistencia != value)
                {
                    resistencia = value;
                    OnPropertyChanged(nameof(Resistencia));
                }
            }
        }

        public string Foto
        {
            get => foto;
            set
            {
                if (foto != value)
                {
                    foto = value;
                    OnPropertyChanged(nameof(Foto));
                }
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
