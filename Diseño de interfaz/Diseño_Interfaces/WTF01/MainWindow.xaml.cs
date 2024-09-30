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

namespace WTF01
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

        private void btRestar_Click(object sender, RoutedEventArgs e)
        {
            double.TryParse(texto1.Text, out double num1);
            double.TryParse(texto2.Text, out double num2);
            double resultado = num1 - num2;
        }

        private void btSumar_Click(object sender, RoutedEventArgs e)
        {
            double.TryParse(texto1.Text, out double num1);
            double.TryParse(texto2.Text, out double num2);
            double resultado = num1 + num2;

            resultado.Text = resultado.ToString();
        }

      
    }
}