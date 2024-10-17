using System.Collections.ObjectModel;
using System.Windows;
using System.Windows.Controls;

namespace WTF16
{
    public partial class MainWindow : Window
    {
        // Inicializamos la lista observable
        ObservableCollection<Persona> personas = new ObservableCollection<Persona>();

        public MainWindow()
        {
            InitializeComponent();
            lbPersonas.ItemsSource = personas; 
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

            // Crear una nueva persona
            var nuevaPersona = new Persona
            {
                Profesion = tbNombre.Text,
                NumeroHermanos = numeroHermanos,
                Edad = ((ComboBoxItem)cbEdad.SelectedItem).Content.ToString(),
                Sexo = rbMasculino.IsChecked == true ? "Masculino" : "Femenino",
                DeporteQuePractica = lbDeporte.SelectedItem != null ? ((ListBoxItem)lbDeporte.SelectedItem).Content.ToString() : "No hace deporte",
                Compra = (int)slCompras.Value,
                Tele = (int)slTelevision.Value,
                Cine = (int)slCine.Value
            };


            personas.Add(nuevaPersona);

            LimpiarFormulario();
        }

        private void LimpiarFormulario()
        {
            tbNombre.Clear();
            tbHermanos.Clear();
            cbEdad.SelectedIndex = 0;
            rbMasculino.IsChecked = false;
            rbFemenino.IsChecked = false;
            cbPractica.IsChecked = false;
            lbDeporte.SelectedIndex = -1;
            slCompras.Value = 1;
            slTelevision.Value = 1;
            slCine.Value = 1;
        }

    }
}
