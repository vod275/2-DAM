using System.Collections.ObjectModel;
using System.Security.Cryptography.X509Certificates;
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


namespace WTF03
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

            //foreach (unidades unidad in unidades)
            //{
            //    comboboxitem item = new comboboxitem();
            //    item.content = unidad;
            //    boxunidadesentrada.items.add(item);

            //}

            //foreach (unidades unidad in unidades)
            //{
            //    comboboxitem item = new comboboxitem();
            //    item.content = unidad;
            //    boxunidadessalida.items.add(item);

            //}
        }

        // Método para manejar el evento al presionar el botón de conversión
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            double valor;
            if (double.TryParse(Unidad.Text, out valor))
            {
                string unidadEntrada = BoxUnidadesEntrada.SelectedItem as string;
                string unidadSalida = BoxUnidadesSalida.SelectedItem as string;

                if (unidadEntrada != null && unidadSalida != null)
                {
                    // Realizar la conversión
                    double resultado = Convertir(valor, unidadEntrada, unidadSalida);

                    // Mostrar el resultado
                    Resultado.Text = resultado.ToString();
                }
                else
                {
                    MessageBox.Show("Selecciona ambas unidades.");
                }
            }
            else
            {
                MessageBox.Show("Por favor, ingresa un número válido.");
            }
        }

        // Método para realizar las conversiones entre unidades
        private double Convertir(double valor, string unidadEntrada, string unidadSalida)
        {
            if (unidadEntrada == "Kg" && unidadSalida == "Gramos")
            {
                return valor * 1000;
            }
            else if (unidadEntrada == "Gramos" && unidadSalida == "Kg")
            {
                return valor / 1000;
            }
            else if (unidadEntrada == "Kg" && unidadSalida == "MlGramos")
            {
                return valor * 1000000;
            }
            else if (unidadEntrada == "MlGramos" && unidadSalida == "Kg")
            {
                return valor / 1000000;
            }
            else if (unidadEntrada == "Gramos" && unidadSalida == "MlGramos")
            {
                return valor * 1000; // Ejemplo de conversión ajustado
            }
            else if (unidadEntrada == "MlGramos" && unidadSalida == "Gramos")
            {
                return valor / 1000;
            }
            else
            {
                return valor; // Si no hay conversión, devuelve el valor original
            }
        }

        // Método para agregar una unidad nueva al ObservableCollection
        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            unidades.Add("nanogr");
        }

        // Método para eliminar la unidad "nanogr" del ObservableCollection
        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            unidades.Remove("nanogr");
        }
    }


}
