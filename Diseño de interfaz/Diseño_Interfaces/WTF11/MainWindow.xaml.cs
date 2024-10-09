using System.Diagnostics.Eventing.Reader;
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

namespace WTF11
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            for (int i = 0; i < 3; i++)
            {

                for (int j = 0; j < 3; j++)
                {


                    if (j == 0)
                    {
                        Label label = new Label();
                        label.Content = "Label " + (i + 1);
                        label.HorizontalAlignment = HorizontalAlignment.Left;
                        label.VerticalAlignment = VerticalAlignment.Center;
                        Grid.SetRow(label, i);
                        Grid.SetColumn(label, j);
                        contenedor.Children.Add(label);
                    }

                    else if (j == 1)
                    {
                        TextBox textBox = new TextBox();
                        textBox.Width = 120;
                        textBox.HorizontalAlignment = HorizontalAlignment.Left;
                        textBox.VerticalAlignment = VerticalAlignment.Center;
                        Grid.SetRow(textBox, i);
                        Grid.SetColumn(textBox, j);
                        contenedor.Children.Add(textBox);
                    }

                    else if (j == 2)
                    {
                        Button boton = new Button();
                        boton.Content = "Botón " + (i + 1);
                        boton.HorizontalAlignment = HorizontalAlignment.Center;
                        boton.VerticalAlignment = VerticalAlignment.Center;
                        Grid.SetRow(boton, i);
                        Grid.SetColumn(boton, j);
                        contenedor.Children.Add(boton);
                    }
                }
            }
        }
    }
}