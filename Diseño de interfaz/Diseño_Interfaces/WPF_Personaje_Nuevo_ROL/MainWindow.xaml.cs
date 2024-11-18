using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Configuration;
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
using WPF23_Personaje_Nuevo_ROL;

namespace WPF_Personaje_Nuevo_ROL
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        ObservableCollection<Personaje> lista { get; set; } = new ObservableCollection<Personaje>();
        ObservableCollection<Objeto> listaObjetos { get; set; } = new ObservableCollection<Objeto>();
        private ICollectionView vistaFiltradaPersonaje;
        public Personaje SelectedPersonaje { get; set; }
        public MainWindow()
        {
            InitializeComponent();
            lista = Repositorio.CargarPersonajes();
            listaObjetos = Repositorio.CargarObjetos();
            dgPersona.ItemsSource = lista;
            lbObjetos.ItemsSource = listaObjetos;
            vistaFiltradaPersonaje = CollectionViewSource.GetDefaultView(lista);
            DataContext = this;
        }

        private void CrearPersonaje_Click(object sender, RoutedEventArgs e)
        {

            string nombrePersonaje = txtNombrePersonaje.Text;

            string clasePersonaje = (cbClasePersonaje.SelectedItem as ComboBoxItem)?.Content.ToString() ?? "Sin Clase";


            string genero = GeneroMasculino.IsChecked == true ? "Masculino" : "Femenino";


            int fuerza = (int)sldFuerza.Value;
            int inteligencia = (int)sldInteligencia.Value;
            int destreza = (int)sldDestreza.Value;
            int resistencia = (int)sldResistencia.Value;
            string foto = RutaFoto.Text;

            Repositorio.AgregarPersonaje(nombrePersonaje, clasePersonaje, genero, fuerza, inteligencia, destreza, resistencia, foto);

            Repositorio.CargarPersonajes();



        }


        private void dgPersona_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (dgPersona.SelectedItem is Personaje selectedCharacter)
            {

                DetailsTextBlock.Text = $"Nombre: {selectedCharacter.NombrePersonaje}\n" +
                                        $"Clase: {selectedCharacter.Clase}\n" +
                                        $"Fuerza: {selectedCharacter.Fuerza}\n" +
                                        $"Destreza: {selectedCharacter.Destreza}\n" +
                                        $"Inteligencia: {selectedCharacter.Inteligencia}\n";

                // Cargar y mostrar la imagen desde la ruta en Foto
                if (!string.IsNullOrEmpty(selectedCharacter.Foto))
                {

                    // Crear una nueva instancia de BitmapImage con la ruta
                    BitmapImage bitmap = new BitmapImage();
                    bitmap.BeginInit();
                    bitmap.UriSource = new Uri(selectedCharacter.Foto, UriKind.RelativeOrAbsolute);
                    bitmap.EndInit();

                    // Asignar la imagen al control Image
                    CharacterImage.Source = bitmap;
                }
                else
                {
                    // Si no hay ruta, limpiar la imagen
                    CharacterImage.Source = null;
                }
            }
            else
            {
                // Si no hay personaje seleccionado, limpiar los detalles y la imagen
                DetailsTextBlock.Text = string.Empty;
                CharacterImage.Source = null;
            }
        }

        private void tbFiltro_TextChanged(object sender, TextChangedEventArgs e)
        {
            Filtrar(tbFiltro.Text);
        }

        private void Filtrar(string texto)
        {
            vistaFiltradaPersonaje.Filter = item =>
            {
                if (item is Personaje personaje)
                {
                    return string.IsNullOrEmpty(texto) || personaje.NombrePersonaje.Contains(texto, StringComparison.OrdinalIgnoreCase);
                }
                return false;

            };
            vistaFiltradaPersonaje.Refresh();   
        }
        //openFileDialog = new OpenFileDialog();
        //openFileDialog.Filter ="imagenes bonitas|*.jpg;*.png;*.jpeg"
    }

}