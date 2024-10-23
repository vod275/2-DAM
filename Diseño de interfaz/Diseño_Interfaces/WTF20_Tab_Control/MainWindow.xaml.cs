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

namespace WTF20_Tab_Control
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public ObservableCollection<Persona> personas { get; set; }

        bool editando;
        int indice;
        public MainWindow()
        {
            InitializeComponent();
            personas = new ObservableCollection<Persona>();
            editando = false;
            indice = 0;
            this.DataContext = this;

        }

       private void btAgragarPersona_Click(object sender, RoutedEventArgs e)
        {
            var persona = new Persona(tbNombre2.Text, tbApellidos2.Text, int.Parse(tbEdad2.Text));
            personas.Add(persona);
            //if (!editando)
            //{
            //    personas.Add(new Persona(tbNombre.Text, tbApellidos.Text, int.Parse(tbEdad1.Text)));
            //    dgPersona.Items.Refresh();
            //}
            //else
            //{

            //    personas[indice] = new Persona(tbNombre.Text, tbApellidos.Text, int.Parse(tbEdad1.Text));
            //    indice = -1;
            //    editando = false;

            //    LimpiarFormulario();
            //}
        }

        private void btEliminar_Click(object sender, RoutedEventArgs e)
        {
            if (dgPersona.SelectedItem != null)
            {
                personas.Remove((Persona)dgPersona.SelectedItem);
                dgPersona.Items.Refresh();
            }
            else
            {
                MessageBox.Show("Por favor, seleccione una persona en la lista para eliminar.");
            }
        }

        private void btModificar_Click(object sender, RoutedEventArgs e)
        {
            if (dgPersona.SelectedItem != null)
            {
                editando = true;

                indice = dgPersona.SelectedIndex;


                Persona persElegida = (Persona)dgPersona.SelectedItem;


                tbNombre.Text = persElegida.Nombre;
                tbApellidos.Text = persElegida.Apellidos;
                tbEdad1.Text = persElegida.Edad.ToString();
            }
            else
            {
                MessageBox.Show("Por favor, seleccione una persona en la lista para modificar.");
            }
        }

        private void LimpiarFormulario()
        {
            tbNombre.Clear();
            tbApellidos.Clear();
            tbEdad1.Clear();
        }

      
    }
}