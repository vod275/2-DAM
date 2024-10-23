using System.Collections.ObjectModel;
using System.Windows;
using WTF16;

namespace WTF19
{
    public partial class MainWindow : Window
    {
        public ObservableCollection<Persona> Personas { get; set; }
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
            if (!editando) 
            {
                Personas.Add(new Persona(tbNombre.Text, tbApellidos.Text, int.Parse(tbEdad1.Text)));
                dgPersona.Items.Refresh();
            }
            else
            {
               
                Personas[indice] = new Persona(tbNombre.Text, tbApellidos.Text, int.Parse(tbEdad1.Text));
                indice = -1;
                editando = false;
             
                LimpiarFormulario();
            }
        }

        private void btEliminar_Click(object sender, RoutedEventArgs e)
        {
            if (dgPersona.SelectedItem != null)
            {
                Personas.Remove((Persona)dgPersona.SelectedItem);
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
