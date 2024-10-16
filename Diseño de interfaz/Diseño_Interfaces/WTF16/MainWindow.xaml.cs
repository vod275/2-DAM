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

namespace WTF16
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            
            if (string.IsNullOrWhiteSpace(tbNombre.Text))
            {
                MessageBox.Show("Debe ingresar una profesión.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            if (string.IsNullOrWhiteSpace(tbHermanos.Text) || !int.TryParse(tbHermanos.Text, out int numeroHermanos))
            {
                MessageBox.Show("Debe ingresar un número válido de hermanos.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            if (cbEdad.SelectedItem == null)
            {
                MessageBox.Show("Debe seleccionar una edad.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            if (!(rbMasculino.IsChecked == true || rbFemenino.IsChecked == true))
            {
                MessageBox.Show("Debe seleccionar un sexo.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }



            var nuevaPersona = new Persona
            {
                Profesion = tbNombre.Text,
                NumeroHermanos = numeroHermanos,
                Edad = ((ComboBoxItem)cbEdad.SelectedItem).Content.ToString(),
                Sexo = rbMasculino.IsChecked == true ? "Masculino" : "Femenino",
                if( cbPractica.IsChecked == true)
                 {
                    DeporteQuePractica = lbDeporte.SelectedItem != null ? ((ListBoxItem)lbDeporte.SelectedItem).Content.ToString();

                 }
                else
                {
                    DeporteQuePractica  = Console.WriteLine("No hace deporte");
                };

                ,
                AficionCompras = (int)slCompras.Value,
                AficionTelevision = (int)slTelevision.Value,
                AficionCine = (int)slCine.Value
            };

        }
    }
}