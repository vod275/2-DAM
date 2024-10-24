using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace WTF21_Personaje_Rol
{
    /// <summary>
    /// Lógica de interacción para CrearPersonaje.xaml
    /// </summary>
    public partial class CrearPersonaje : Window
    {
        public Personaje NuevoPersonaje { get; private set; }

        public CrearPersonaje()
        {
            InitializeComponent();
        }

        private void ClassComboBox_SelectionChanged(object sender, System.Windows.Controls.SelectionChangedEventArgs e)
        {
            
            string selectedClass = (ClaseComboBox.SelectedItem as ComboBoxItem).Content.ToString();
            switch (selectedClass)
            {
                case "Mago":
                    AttributesTextBlock.Text = "Fuerza: 5, Destreza: 10, Constitución: 8, Inteligencia: 15, Sabiduría: 12, Carisma: 8";
                    break;
                case "Picaro":
                    AttributesTextBlock.Text = "Fuerza: 8, Destreza: 15, Constitución: 10, Inteligencia: 12, Sabiduría: 8, Carisma: 10";
                    break;
                case "Guerrero":
                    AttributesTextBlock.Text = "Fuerza: 12, Destreza: 10, Constitución: 15, Inteligencia: 8, Sabiduría: 8, Carisma: 10";
                    break;
                case "Espadachin":
                    AttributesTextBlock.Text = "Fuerza: 10, Destreza: 12, Constitución: 15, Inteligencia: 10, Sabiduría: 8, Carisma: 8";
                    break;
                case "Barbaro":
                    AttributesTextBlock.Text = "Fuerza: 15, Destreza: 12, Constitución: 10, Inteligencia: 8, Sabiduría: 8, Carisma: 10";
                    break;
                case "Ladron":
                    AttributesTextBlock.Text = "Fuerza: 8, Destreza: 15, Constitución: 8, Inteligencia: 12, Sabiduría: 10, Carisma: 10";
                    break;
                case "Curandero":
                    AttributesTextBlock.Text = "Fuerza: 8, Destreza: 12, Constitución: 10, Inteligencia: 15, Sabiduría: 8, Carisma: 10";

                    break;

            }
        }

        private void AceptarButton_Click(object sender, RoutedEventArgs e)
        {
       
            NuevoPersonaje = new Personaje
            {
                Nombre = NameTextBox.Text,
                Genero = (GeneroComboBox.SelectedItem as ComboBoxItem).Content.ToString(),
                Clase = (ClaseComboBox.SelectedItem as ComboBoxItem).Content.ToString(),
                Fuerza = ObtenerAtributoDeTexto("Fuerza"),
                Destreza = ObtenerAtributoDeTexto("Destreza"),
                Constitución = ObtenerAtributoDeTexto("Constitución"),
                Inteligencia = ObtenerAtributoDeTexto("Inteligencia"),
                Sabiduría = ObtenerAtributoDeTexto("Sabiduría"),
                Carisma = ObtenerAtributoDeTexto("Carisma"),
                ImagenRuta = ImagePathTextBox.Text
            };

            DialogResult = true;
            Close();
        }

        private int ObtenerAtributoDeTexto(string atributo)
        {
            string[] partes = AttributesTextBlock.Text.Split(',');
            foreach (var parte in partes)
            {
                if (parte.Contains(atributo))
                {
                    return int.Parse(parte.Split(':')[1].Trim());
                }
            }
            return 0;
        }
    }
}
