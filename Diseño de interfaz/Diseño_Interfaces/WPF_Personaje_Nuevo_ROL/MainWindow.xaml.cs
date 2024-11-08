using System.Collections.ObjectModel;
using System.Configuration;
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
using WPF23_Personaje_Nuevo_ROL;

namespace WPF_Personaje_Nuevo_ROL
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        ObservableCollection<Personaje> lista { get; set; } = new ObservableCollection<Personaje>();
        public MainWindow()
        {
            InitializeComponent();
            this.DataContext = this;
            lista = Repositorio.CargarPersonajes();
        }

        private void CrearPersonaje_Click(object sender, RoutedEventArgs e)
        {
     
            string nombrePersonaje = txtNombrePersonaje.Text;

            string clasePersonaje = (cbClasePersonaje.SelectedItem as ComboBoxItem)?.Content.ToString() ?? "Sin Clase";


            string genero = GeneroMasculino.IsChecked == true ? "Masculino" : "Femenino";


            int fuerza = (int)sldFuerza.Value;
            int inteligencia = (int)sldInteligencia.Value;
            int destreza = (int)sldDestreza.Value;
            int resistencia = (int)sldResistencia.Value;
            string foto = RutaFoto.Text; 

            Repositorio.AgregarPersonaje(nombrePersonaje, clasePersonaje, genero, fuerza, inteligencia, destreza, resistencia, foto);

            Repositorio.CargarPersonajes();



        }

    }
}