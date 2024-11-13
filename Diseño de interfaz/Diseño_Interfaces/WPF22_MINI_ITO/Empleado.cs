using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPF22_MINI_ITO
{
    public class Empleado : INotifyPropertyChanged
    {

        private string nombreEmpleado, rol;
        private float coste_por_hora;

        public string NombreEmpleado
        {
            get => nombreEmpleado;
            set
            {
                if (nombreEmpleado != value)
                {
                    nombreEmpleado = value;
                    OnPropertyChanged(nameof(NombreEmpleado));
                }
            }
        }

        public string Rol
        {
            get => rol;
            set
            {
                if (rol != value)
                {
                    rol = value;
                    OnPropertyChanged(nameof(rol));
                }
            }
        }

        public float Coste_por_Hora
        {
            get => coste_por_hora;
            set
            {
                if (coste_por_hora != value)
                {
                    coste_por_hora = value;
                    OnPropertyChanged(nameof(coste_por_hora));
                }
            }
        }


        public Empleado(string nombreEmpleado, string rol, float coste_por_Hora)
        {
            NombreEmpleado = nombreEmpleado;
            Rol = rol;
            Coste_por_Hora = coste_por_Hora;
        }

        public Empleado()
        {
           
        }

        

        public override string ToString()
        {
            return $"Nombre Empleado: {NombreEmpleado}, Rol: {Rol}, Coste por Hora: {Coste_por_Hora}";
        }




        public event PropertyChangedEventHandler? PropertyChanged;
        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

    }


}
