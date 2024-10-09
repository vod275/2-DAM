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

namespace WTF12
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

             string[,] botonesCalculadora = new string[,]
             {
                { "7", "8", "9" },   
                { "4", "5", "6" },   
                { "1", "2", "3" },    
                { "=", "0", "C" }    
             };

            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    Button boton = new Button();

                    
                    if (j < 3 || i < 4) 
                    {
                        boton.Content = botonesCalculadora[i, j];
                    }
                    

                    boton.HorizontalAlignment = HorizontalAlignment.Center;
                    boton.VerticalAlignment = VerticalAlignment.Center;
                    boton.Width = 60;
                    boton.Height = 60;
                    Grid.SetRow(boton, i); 
                    Grid.SetColumn(boton, j); 

                    contenedor.Children.Add(boton);
                }
            }
        }
    }
}