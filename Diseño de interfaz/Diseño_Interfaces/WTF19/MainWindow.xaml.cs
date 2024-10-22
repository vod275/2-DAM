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
using WTF16;

namespace WTF19
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public ObservableCollection<Persona> Personas {  get; set; }
        public MainWindow()
        {
            InitializeComponent();
           Personas = new ObservableCollection<Persona>();
            this.DataContext = this;
        }

        private void btAgragarPersona_Click(object sender, RoutedEventArgs e)
        {
            Personas.Add(new Persona(tbNombre.Text, tbApellidos.Text,
            int.Parse(tbEdad1.Text)));
            dgPersona.Items.Refresh();

        
        }
    }
}