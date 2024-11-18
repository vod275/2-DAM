using System.ComponentModel;

namespace WPF23_Personaje_Nuevo_ROL
{
    public class Objeto : INotifyPropertyChanged
    {
        private string nombreObjeto, tipoObjeto;
        private int fuerzaObjeto, inteligenciaObjeto, destrezaObjeto, resistenciaObjeto;

        public string NombreObjeto
        {
            get => nombreObjeto;
            set
            {
                if (nombreObjeto != value)
                {
                    nombreObjeto = value;
                    OnPropertyChanged(nameof(NombreObjeto));
                }
            }
        }

        public string TipoObjeto
        {
            get => tipoObjeto;
            set
            {
                if (tipoObjeto != value)
                {
                    tipoObjeto = value;
                    OnPropertyChanged(nameof(TipoObjeto));
                }
            }
        }

        public int FuerzaObjeto
        {
            get => fuerzaObjeto;
            set
            {
                if (fuerzaObjeto != value)
                {
                    fuerzaObjeto = value;
                    OnPropertyChanged(nameof(FuerzaObjeto));
                }
            }
        }

        public int InteligenciaObjeto
        {
            get => inteligenciaObjeto;
            set
            {
                if (inteligenciaObjeto != value)
                {
                    inteligenciaObjeto = value;
                    OnPropertyChanged(nameof(InteligenciaObjeto));
                }
            }
        }

        public int DestrezaObjeto
        {
            get => destrezaObjeto;
            set
            {
                if (destrezaObjeto != value)
                {
                    destrezaObjeto = value;
                    OnPropertyChanged(nameof(DestrezaObjeto));
                }
            }
        }

        public int ResistenciaObjeto
        {
            get => resistenciaObjeto;
            set
            {
                if (resistenciaObjeto != value)
                {
                    resistenciaObjeto = value;
                    OnPropertyChanged(nameof(ResistenciaObjeto));
                }
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        // Constructor sin parámetros
        public Objeto() { }

        // Constructor con parámetros
        public Objeto(string nombreObjeto, string tipoObjeto, int fuerzaObjeto, int inteligenciaObjeto, int destrezaObjeto, int resistenciaObjeto)
        {
            NombreObjeto = nombreObjeto;
            TipoObjeto = tipoObjeto;
            FuerzaObjeto = fuerzaObjeto;
            InteligenciaObjeto = inteligenciaObjeto;
            DestrezaObjeto = destrezaObjeto;
            ResistenciaObjeto = resistenciaObjeto;
        }

        public override string ToString()
        {
            return $"{NombreObjeto} - {TipoObjeto} - " +
                   $"Fuerza: {FuerzaObjeto}, Inteligencia: {InteligenciaObjeto}, " +
                   $"Destreza: {DestrezaObjeto}, Resistencia: {ResistenciaObjeto}";
        }
    }
}
