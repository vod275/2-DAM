using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicación_de_reservas_del_cine
{
    public class Pelicula : INotifyPropertyChanged
    {


        private string titulo, descriocion, imagen;
        private float precioentrada;

        public string Titulo
        {
            get => titulo;
            set
            {
                if (titulo != value)
                {
                    titulo = value;
                    OnPropertyChanged(nameof(Titulo));
                }
            }
        }

        public string Descripcion
        {
            get => titulo;
            set
            {
                if (descriocion != value)
                {
                    descriocion = value;
                    OnPropertyChanged(nameof(Descripcion));
                }
            }
        }

        public string Imagen
        {
            get => imagen;
            set
            {
                if (imagen != value)
                {
                    imagen = value;
                    OnPropertyChanged(nameof(Imagen));
                }
            }
        }

        public float PrecioEntrada
        {
            get => precioentrada;
            set
            {
                if (precioentrada != value)
                {
                    precioentrada = value;
                    OnPropertyChanged(nameof(PrecioEntrada));
                }
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public override string ToString()
        {
            return $"{Titulo} - {Descripcion} - " +
                   $"Precio: {PrecioEntrada}, Imagen: {Imagen}, ";
        }
    }
}
