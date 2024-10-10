using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace WTF13
{
    public partial class MainWindow : Window
    {
        Random random = new Random();

        public MainWindow()
        {
            InitializeComponent();
            PintarEllipsesAleatorias(5000);
        }

        private void PintarEllipsesAleatorias(int count)
        {
            for (int i = 0; i < count; i++)
            {
                Ellipse ellipse = new Ellipse
                {
                    
                    Width = random.Next(50, 133),
                    Height = random.Next(50, 133),

                   
                    Fill = new SolidColorBrush(Color.FromRgb(
                        (byte)random.Next(256), 
                        (byte)random.Next(256),
                        (byte)random.Next(256))) 
                };

               
                

                
                Canvas.SetLeft(ellipse, random.Next(1, 500));
                Canvas.SetTop(ellipse, random.Next(1,500));

                
                MiCanva.Children.Add(ellipse);
            }
        }
    }
}
