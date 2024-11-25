using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicación_de_reservas_del_cine
{
    internal class Asiento : INotifyPropertyChanged
    {
        private string nombreCliente, carnetJoven;
        private int cantidadEntradas;
        private float total;

        public event PropertyChangedEventHandler? PropertyChanged;


        public string NombreCliente
        {
            get => nombreCliente;
            set
            {
                if (nombreCliente != value)
                {
                    nombreCliente = value;
                    OnPropertyChanged(nameof(NombreCliente));
                }
            }
        }

        public string CarnetJoven
        {
            get => carnetJoven;
            set
            {
                if (carnetJoven != value)
                {
                    carnetJoven = value;
                    OnPropertyChanged(nameof(CarnetJoven));
                }
            }
        }

        public int CantidadEntradas
        {
            get => cantidadEntradas;
            set
            {
                if (cantidadEntradas != value)
                {
                    cantidadEntradas = value;
                    OnPropertyChanged(nameof(CantidadEntradas));
                }
            }
        }
        public float Total
        {
            get => total;
            set
            {
                if (total != value)
                {
                    total = value;
                    OnPropertyChanged(nameof(Total));
                }
            }
        }

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

    }
}
