using System.Collections.ObjectModel;
using System.Windows;

namespace WTF05
{
    public partial class MainWindow : Window
    {
        public ObservableCollection<string> monedas { get; set; } = new ObservableCollection<string>();

        public MainWindow()
        {
            InitializeComponent();

          
            monedas.Add("USD");
            monedas.Add("GBP");
            monedas.Add("JPY");
            monedas.Add("MXN");

          
            this.DataContext = this;
        }


        private double ConvertirAEuros(string monedaOrigen, double cantidad)
        {
            switch (monedaOrigen)
            {
                case "USD":
                    return cantidad * 0.85; 
                case "GBP":
                    return cantidad * 1.15; 
                case "JPY":
                    return cantidad * 0.0078; 
                case "MXN":
                    return cantidad * 0.048; 
                default:
                    return 0;
            }
        }


        private void btConversion_Click(object sender, RoutedEventArgs e)
        {
      
            if (double.TryParse(tbMonedaOrigen.Text, out double cantidad) && cbMonedas.SelectedItem != null)
            {
                string monedaOrigen = cbMonedas.SelectedItem as string;
                double resultado = ConvertirAEuros(monedaOrigen, cantidad);

                tbMonedaDestino.Text = $"{cantidad} {monedaOrigen} = {resultado:N2} EUR";
            }
            else
            {
                MessageBox.Show("Por favor, introduce una cantidad válida y selecciona una moneda de origen.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }

        }
    }
}