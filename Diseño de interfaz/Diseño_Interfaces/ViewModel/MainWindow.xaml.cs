using System.ComponentModel;
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

namespace ViewModel
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window  
    {
        private MainViewModel viewModel;
        public MainWindow()
        {
            InitializeComponent();
            viewModel = new MainViewModel();
            this.DataContext = viewModel;

        }


        private void AgregarPersona_Click(object sender, RoutedEventArgs e)
        {
            Persona p = new Persona();
             p.Nombre = tbNombre.Text;
             p.Edad = int.Parse(tbEdad.Text);
            viewModel.ProgressValue++;
            viewModel.AgregarPersona(p);

        }
    }
}