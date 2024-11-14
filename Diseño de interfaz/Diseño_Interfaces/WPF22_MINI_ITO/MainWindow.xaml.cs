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
                // Eliminar el empleado de la base de datos
                Repositorio.EliminarEmpleado(empleadoSeleccionado.NombreEmpleado);

                // Eliminar el empleado de la lista ObservableCollection
                listaEmpleados.Remove(empleadoSeleccionado);
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un empleado para eliminar.");
            }
        }
    }
   
}
