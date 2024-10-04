using System;
using System.Windows;

namespace WTF06
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            iCirculo.Visibility = Visibility.Visible;
            iCuadrado.Visibility = Visibility.Visible;
            iTriangulo.Visibility = Visibility.Visible;

            OcultarCampos();
        }

        private void Figura_Checked(object sender, RoutedEventArgs e)
        {
            OcultarCampos(); 

            if (rbCirculo.IsChecked == true)
            {
                tbRadio.Visibility = Visibility.Visible;
                tblRadio.Visibility = Visibility.Visible;
            }
            else if (rbCuadrado.IsChecked == true)
            {
                tbLado.Visibility = Visibility.Visible;
                tblLado.Visibility = Visibility.Visible;
            }
            else if (rbTriangulo.IsChecked == true)
            {
                tbLado.Visibility = Visibility.Visible;
                tbAltura.Visibility = Visibility.Visible;
                tblLado.Visibility = Visibility.Visible;
                tblAltura.Visibility = Visibility.Visible;
            }
        }

        private void btCalcular_Click(object sender, RoutedEventArgs e)
        {
            double area = 0;

            // Cálculo del área dependiendo de la figura seleccionada
            if (rbCirculo.IsChecked == true)
            {
                if (double.TryParse(tbRadio.Text, out double radio))
                {
                    area = Math.PI * Math.Pow(radio, 2); // Área del círculo: π * r²
                }
                else
                {
                    MessageBox.Show("Por favor, introduce un radio válido.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                    return;
                }
            }
            else if (rbCuadrado.IsChecked == true)
            {
                if (double.TryParse(tbLado.Text, out double lado))
                {
                    area = Math.Pow(lado, 2); // Área del cuadrado: lado²
                }
                else
                {
                    MessageBox.Show("Por favor, introduce un lado válido.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                    return;
                }
            }
            else if (rbTriangulo.IsChecked == true)
            {
                if (double.TryParse(tbLado.Text, out double baseTriangulo) && double.TryParse(tbAltura.Text, out double altura))
                {
                    area = (baseTriangulo * altura) / 2; // Área del triángulo: (base * altura) / 2
                }
                else
                {
                    MessageBox.Show("Por favor, introduce valores válidos para la base y la altura.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                    return;
                }
            }

            // Mostrar el resultado
            tbResultado.Text = $"Área calculada: {area:N2}";
        }

        // Ocultar todos los campos de entrada y etiquetas
        private void OcultarCampos()
        {
            tbRadio.Visibility = Visibility.Collapsed;
            tbLado.Visibility = Visibility.Collapsed;
            tbAltura.Visibility = Visibility.Collapsed;
            tblRadio.Visibility = Visibility.Collapsed;
            tblLado.Visibility = Visibility.Collapsed;
            tblAltura.Visibility = Visibility.Collapsed;
        }
    }
}
