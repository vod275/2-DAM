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

namespace ViewModelAdivinar
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

        private void btFacil_Click(object sender, RoutedEventArgs e)
        {
            viewModel.StartTimer();
            if (viewModel.ProgressValue == 0)
            {
                BitmapImage bitmap = new BitmapImage(new Uri("Descargas\\1-e92dae2b.jpg", UriKind.RelativeOrAbsolute));

                // Asigna la imagen al control
                imagen.Source = bitmap;
            }
        }

        private void btDificil_Click(object sender, RoutedEventArgs e)
        {
            viewModel.StartTimerDificil();
            if (viewModel.ProgressValue == 0)
            {
                BitmapImage bitmap = new BitmapImage(new Uri("Descargas\\1-e92dae2b.jpg", UriKind.RelativeOrAbsolute));

              
                imagen.Source = bitmap;
            }
        }
    }
}