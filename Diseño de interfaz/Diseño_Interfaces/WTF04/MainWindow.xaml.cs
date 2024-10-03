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

namespace WTF04
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public ObservableCollection<string> unidades { get; set; } = new ObservableCollection<string>();
        public MainWindow()
        {
            InitializeComponent();

            unidades.Add(new string("Kg"));
            unidades.Add(new string("Gramos"));
            unidades.Add(new string("MlGramos"));

            this.DataContext = this;

        }



        public void btCalcular_Click(object sender, RoutedEventArgs e)
        {
            double peso = Convert.ToDouble(tbPeso.Text);
            double altura = Convert.ToDouble(tbAltura.Text);
            double imc = peso / (altura * altura);

            string unidadEntrada = cbUnidades.SelectedItem as string;
            

            string resultado;
            if (imc < 18.5)
            {
                resultado = imc.ToString("F2");

                lbMensaje.Content = "Estás muy delgado.";
                lbMensaje.Foreground = Brushes.Yellow;
                lbMensaje.Visibility = Visibility.Visible;
            }
            else if (imc >= 18.5 && imc <= 24.9)
            {
                resultado = imc.ToString("F2");

                lbMensaje.Content = "Estás en tu peso ideal.";
                lbMensaje.Foreground = Brushes.Green;
                lbMensaje.Visibility = Visibility.Visible;
            }
            else
            {
                resultado = imc.ToString("F2");

                lbMensaje.Content = "Estas Obeso";
                lbMensaje.Foreground = Brushes.Red;
                lbMensaje.Visibility = Visibility.Visible;
            }




            tbResultado.Text = "Tu IMC es: " +resultado;
        }


       
        }
    }
}