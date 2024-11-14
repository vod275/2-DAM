using System;
using System.Collections.ObjectModel;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WPF22_MINI_ITO
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window     
    {

        ObservableCollection<DatosIniciales> datosInicilaes { get; set; } = new ObservableCollection<DatosIniciales>();
        ObservableCollection<Empleado> listaEmpleados { get; set; } = new ObservableCollection<Empleado>();
        public MainWindow()
        {
            InitializeComponent();
            DataContext = this;
            listaEmpleados = Repositorio.CargarEmpleados();
            datosInicilaes = Repositorio.CargarProyecto();
            dgEmpleado.ItemsSource = listaEmpleados;
            dgProyectos.ItemsSource = datosInicilaes;

        }

        private void btSave_Click(object sender, RoutedEventArgs e)
        {


            if (string.IsNullOrWhiteSpace(tbNombreProyecto.Text))
            {
                MessageBox.Show("Debe ingresar un nombre para el proyecto.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            if (string.IsNullOrWhiteSpace(tbPresupuestoInicial.Text))
            {
                MessageBox.Show("Debe ingresar un presupuesto.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }




            
            string nuevoProyecto = tbNombreProyecto.Text;
            float presupuestoIniicial = float.Parse(tbPresupuestoInicial.Text);
            Repositorio.AgregarProyecto(nuevoProyecto, presupuestoIniicial);
            Repositorio.CargarProyecto();

        }

        private void btAgregarEmpleado_Click(object sender, RoutedEventArgs e)
        {
            
                 string nombreEmpleado = tbNombre.Text;

                 string rol = tbRol.Text;


                float coste_Por_Hora = float.Parse(tbCoste_Por_Hora.Text);


                 Repositorio.AgregarEmpleado(nombreEmpleado, rol, coste_Por_Hora);

                 Repositorio.CargarEmpleados();
                
           
        }

        private void btEliminarEmpleado_Click(object sender, RoutedEventArgs e)
        {
            Empleado empleadoSeleccionado = dgEmpleado.SelectedItem as Empleado;

            if (empleadoSeleccionado != null)
            {

                Repositorio.EliminarEmpleado(empleadoSeleccionado.NombreEmpleado);

                listaEmpleados.Remove(empleadoSeleccionado);
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un empleado para eliminar.");
            }
        }

        private void btEliminarProyecto_Click(object sender, RoutedEventArgs e)
        {
            // Obtener el proyecto seleccionado en el DataGrid
            DatosIniciales proyectoSeleccionado = dgProyectos.SelectedItem as DatosIniciales;

            if (proyectoSeleccionado != null)
            {
                
                Repositorio.EliminarProyecto(proyectoSeleccionado.NombreProyecto);

                
                datosInicilaes.Remove(proyectoSeleccionado);
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un proyecto para eliminar.");
            }
        }


        private void btAsignarEmpleado_Click(object sender, RoutedEventArgs e)
        {
            if (dgProyectos.SelectedItem is DatosIniciales proyectoSeleccionado && cbEmpleados.SelectedValue is int empleadoId)
            {
                int proyectoId = proyectoSeleccionado.IDProyecto;

                // Llamada al método en Repositorio para asignar el empleado al proyecto
                Repositorio.AsignarEmpleadoAProyecto(proyectoId, empleadoId);

                MessageBox.Show("Empleado asignado al proyecto correctamente.");
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un proyecto y un empleado.");
            }
        }
    }
   
}
