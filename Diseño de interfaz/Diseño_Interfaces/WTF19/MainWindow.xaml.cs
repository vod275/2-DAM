using System.Collections.ObjectModel;
using System.Reflection.Metadata.Ecma335;
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
using WTF16;

namespace WTF19
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public ObservableCollection<Persona> Personas {  get; set; }
        bool editando;
        int indice;
        public MainWindow()
        {
            InitializeComponent();
           Personas = new ObservableCollection<Persona>();
            editando = false;
            indice = 0;
           this.DataContext = this;


        }
        private void btAgragarPersona_Click(object sender, RoutedEventArgs e)
        {
            if(editando = false)
            {
                Personas.Add(new Persona(tbNombre.Text, tbApellidos.Text,
                int.Parse(tbEdad1.Text)));
                dgPersona.Items.Refresh();
            }
            else
            {
                Persona[indice] = new Persona((tbNombre.Text, tbApellidos.Text, int.Parse(tbEdad1.Text)));
                indice = -1;
                //limpiarFormulario
            }
         

        }

        private void btEliminar_Click(object sender, RoutedEventArgs e)
        {

                Personas.Remove((Persona)
                dgPersona.SelectedItem);
                dgPersona.Items.Refresh();
            
        }

        private void btModificar_Click(object sender, RoutedEventArgs e)
        {
            editando = true;
            indice = (Persona.Sele)
            if (dgPersona.SelectedItem != null)
            {
             
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
    }
}