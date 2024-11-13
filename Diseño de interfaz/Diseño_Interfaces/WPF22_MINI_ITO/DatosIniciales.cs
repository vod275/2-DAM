using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media.Media3D;
using System.Windows.Shapes;

namespace WPF22_MINI_ITO
{
    public class DatosIniciales : INotifyPropertyChanged
    {
       

        

        private int idProyecto;
        private string nombreProyecto;
        private float presupuestoInicial, costeTotal;



        public int IDProyecto
        {
            get => idProyecto;
            set
            {
                if (idProyecto != value)
                {
                    idProyecto = value;
                    OnPropertyChanged(nameof(nombreProyecto));
                }
            }
        }
        public string NombreProyecto
        {
            get => nombreProyecto;
            set
            {
                if (nombreProyecto != value)
                {
                    nombreProyecto = value;
                    OnPropertyChanged(nameof(nombreProyecto));
                }
            }
        }

        public float PresupuestoInicial
        {
            get => presupuestoInicial;
            set
            {
                if (presupuestoInicial != value)
                {
                    presupuestoInicial = value;
                    OnPropertyChanged(nameof(nombreProyecto));
                }
            }
        }

        public float CosteTotal
        {
            get => costeTotal;
            set
            {
                if (costeTotal != value)
                {
                    costeTotal = value;
                    OnPropertyChanged(nameof(nombreProyecto));
                }
            }
        }

        public DatosIniciales(string nombreProyecto, int iDProyecto, float presupuestoInicial, float costeTotal)
        {
            NombreProyecto = nombreProyecto;
            IDProyecto = iDProyecto;
            PresupuestoInicial = presupuestoInicial;
            CosteTotal = costeTotal;
        }

        public DatosIniciales() { }

       

        public override string ToString()
        {
            return $"Profesión: {NombreProyecto}, IDProyecto: {IDProyecto}, PresupuestoInicial: {PresupuestoInicial},  Coste Total: {CosteTotal}";
        }
        public event PropertyChangedEventHandler? PropertyChanged;

        private void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }


    }
}
