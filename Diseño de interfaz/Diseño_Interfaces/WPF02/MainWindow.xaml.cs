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

namespace WPF02
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            List<Persona> personas = new List<Persona>();
            personas.Add(new Persona("Irene", "Castillo"));
            personas.Add(new Persona("Victor", "Oliver"));

            foreach (Persona persona in personas)
            {
                ComboBoxItem item = new ComboBoxItem();
                item.Content = persona;
                BoxPersonas.Items.Add(item);
            }
        }

        private void ComboBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            ComboBoxItem personaItem = (ComboBoxItem)BoxPersonas.SelectedItem;
            Persona persona = (Persona)personaItem.Content;
            Nombre.Content = persona.Nombre;
            Apellidos.Content = persona.Apellidos;
        }
    }
}