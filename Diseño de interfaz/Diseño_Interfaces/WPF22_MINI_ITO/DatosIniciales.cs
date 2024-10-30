using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media.Media3D;
using System.Windows.Shapes;

namespace WPF22_MINI_ITO
{
    public class DatosIniciales
    {
        public String NombreProyecto { get; set; }

        public int IDProyecto { get; set; }

        public String PresupuestoInicial { get; set; }

        public DatosIniciales(string nombreProyecto, int iDProyecto, String presupuestoInicial)
        {
            NombreProyecto = nombreProyecto;
            IDProyecto = iDProyecto;
            PresupuestoInicial = presupuestoInicial;
        }

        public DatosIniciales() { }

        public override string ToString()
        {
            return $"Profesión: {NombreProyecto}, IDProyecto: {IDProyecto}, PresupuestoInicial: {PresupuestoInicial}";
        }



    }
}
