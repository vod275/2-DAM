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

namespace ViewModelBarra
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

        private async void StartDownload_Click(object sender, RoutedEventArgs e)
        {
            ProgressBarDownload.Value = 0;
            ProgressText.Text = "Descarga Iniciada";

            for(int i = 1; i <= 100; i++)
            {
                await Task.Delay(50);
                ProgressBarDownload.Value = i;
                ProgressText.Text = $"{i}% completado";
            }
            ProgressText.Text = "Descarga Completada";

        }

       
    }
}