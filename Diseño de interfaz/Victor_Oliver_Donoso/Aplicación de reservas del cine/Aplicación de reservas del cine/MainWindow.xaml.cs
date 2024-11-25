using Microsoft.Win32;
using System.Collections.ObjectModel;
using System.ComponentModel;
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

namespace Aplicación_de_reservas_del_cine
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        ObservableCollection<Pelicula> listaPeliculas { get; set; } = new ObservableCollection<Pelicula>();
        private ICollectionView vistaFiltradaPersonaje;
        public MainWindow()
        {
            InitializeComponent();
            _ = InicializarDatos();
            lbPeliculas.ItemsSource = listaPeliculas;

            DataContext = this;
            vistaFiltradaPersonaje = CollectionViewSource.GetDefaultView(listaPeliculas);

        }
        private async void Button_Click(object sender, RoutedEventArgs e)
        {

            string titulo = tbTitulo.Text;

            string descripcion = tbDescripcion.Text;

            float precioEntrada = float.Parse(tbPrecio.Text);
            string imagen = tbImagen.Text;

            await Repositorio.AgregarPelicula(titulo, descripcion, precioEntrada, imagen);
        }

        private void tbFiltro_TextChanged(object sender, TextChangedEventArgs e)
        {
            Filtrar(tbFiltro.Text);
        }

        private void Filtrar(string texto)
        {
            vistaFiltradaPersonaje.Filter = item =>
            {
                if (item is Pelicula pelicula)
                {
                    return string.IsNullOrEmpty(texto) || pelicula.Titulo.Contains(texto, StringComparison.OrdinalIgnoreCase);
                }
                return false;

            };
            vistaFiltradaPersonaje.Refresh();
        }

        private void SeleccionarImagen_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog
            {
                Filter = "Imagenes|*.jpg;*.png;*.jpeg"
            };

            if (openFileDialog.ShowDialog() == true)
            {

                tbImagen.Text = openFileDialog.FileName;
            }
        }


        private async Task CargarDatosInicialesPersonajes(ObservableCollection<Pelicula> lista)
        {

            lista.Clear();

            var peliculas = await Repositorio.CargarPeliculas();


            foreach (var pelicula in peliculas)
            {
                lista.Add(pelicula);
            }
        }


        public async Task InicializarDatos()
        {
            await CargarDatosInicialesPersonajes(listaPeliculas);
          
        }

        //Elimina la oelicula de la lista y de la base de datos
        private void btEliminarPelicula_Click(object sender, RoutedEventArgs e)
        {
            Pelicula peliculaSeleccionada = lbPeliculas.SelectedItem as Pelicula;

            if (peliculaSeleccionada != null)
            {

                Repositorio.EliminarPelicula(peliculaSeleccionada.Titulo);

                listaPeliculas.Remove(peliculaSeleccionada);
            }
            else
            {
                MessageBox.Show("Por favor, selecciona una pelicula para eliminar.");
            }
        }

        private void btModificarPelicula_Click(object sender, RoutedEventArgs e)
        {
            Pelicula peliculaSeleccionada = lbPeliculas.SelectedItem as Pelicula;

            if (peliculaSeleccionada != null)
            {

                Repositorio.ActualizarPelicula(peliculaSeleccionada);

               
            }
            else
            {
                MessageBox.Show("Por favor, selecciona una pelicula para modificar.");
            }
        }


        //No se por que carajos no me funciona pero creo que estoy haciendo las cosas bienn, eso hace que no me funcione el calcular el total
        // Aun asi te hare el metodo para subirlo a la base de datos revisalo porfa y subeme aunque sea 0.25 :3
        private void lbPelicula_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (lbPeliculas.SelectedItem is Pelicula selectedCharacter)
            {

                DetailsTextBlock.Text = $"Titulo: {selectedCharacter.Titulo}\n" +
                                        $"Descripcion: {selectedCharacter.Descripcion}\n" +
                                        $"Precio: {selectedCharacter.PrecioEntrada}\n";

               
                if (!string.IsNullOrEmpty(selectedCharacter.Imagen))
                {

                    
                    BitmapImage bitmap = new BitmapImage();
                    bitmap.BeginInit();
                    bitmap.UriSource = new Uri(selectedCharacter.Imagen, UriKind.RelativeOrAbsolute);
                    bitmap.EndInit();
                    CharacterImage.Source = bitmap;
                }
                else
                {
                    CharacterImage.Source = null;
                }
            }
            else
            {
                DetailsTextBlock.Text = string.Empty;
                CharacterImage.Source = null;
            }
        }

        //calcula el precio
        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            if(lbPeliculas.SelectedItem is Pelicula selectedCharacter)
            {
                float cantidad = float.Parse(tbCantidad.Text);
                float cantidadTotal = float.Parse(tbTotal.Text);
                float precio = selectedCharacter.PrecioEntrada;
                cantidadTotal = cantidad * precio;
                cantidadTotal = float.Parse(tbTotal.Text);
            }
            

            
        }

        //Agrega la pelicula
        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            string nombreCliente = tbNombre.Text;

            bool carnetJoven = cbCarneJoven.IsReadOnly;
            int cantidadEntradas = int.Parse(tbCantidad.Text);
            float total = float.Parse(tbTotal.Text);


            Repositorio.AgregarEntrada(nombreCliente, carnetJoven, cantidadEntradas, total);
        }

     
       
    }
}