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
        Random random = new Random();
        ObservableCollection<DatosIniciales> datosInicilaes = new ObservableCollection<DatosIniciales>();
        public MainWindow()
        {
            InitializeComponent();
            lbProyectos.ItemsSource = datosInicilaes;

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




            int id = random.Next(1, 10000000);
            var nuevoProyecto = new DatosIniciales
            {
                
                NombreProyecto = tbNombreProyecto.Text,
                IDProyecto = id,//Se que esta mal pero no estoy sembrado hoy perdon :( no se me va a mostrar el numero aleatorio
                PresupuestoInicial = tbPresupuestoInicial.Text,

            };
            
            
            datosInicilaes.Add(nuevoProyecto);
        }

        
    }
   
}
