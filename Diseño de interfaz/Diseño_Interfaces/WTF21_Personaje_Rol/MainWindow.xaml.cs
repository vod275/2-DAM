using MySql.Data.MySqlClient;
using System.Collections.ObjectModel;
using System.Configuration;
using System.Windows;
using System.Windows.Media.Imaging;

namespace WTF21_Personaje_Rol
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public ObservableCollection<Personaje> Personajes { get; set; }
        public ObservableCollection<Inventario> ObjetosDisponibles { get; private set; }

        public MainWindow()
        {
            InitializeComponent();
            Personajes = new ObservableCollection<Personaje>();
            CharacterListBox.ItemsSource = Personajes;
            ObjetosDisponibles = new ObservableCollection<Inventario>
            {
                new Inventario("Espada", 5, 3, 2, 0, 0, 0),
                new Inventario("Escudo", 0, 0, 5, 0, 0, 0),
                new Inventario("Poción de Salud", 0, 0, 0, 0, 0, 2)
            };
        }

        private void AddCharacterButton_Click(object sender, RoutedEventArgs e)
        {

            CrearPersonaje CrearPersonajeWindow = new CrearPersonaje();
            if (CrearPersonajeWindow.ShowDialog() == true)
            {
                Personajes.Add(CrearPersonajeWindow.NuevoPersonaje);
            }
        }

        private void CharacterListBox_SelectionChanged(object sender, System.Windows.Controls.SelectionChangedEventArgs e)
        {
           

            if (CharacterListBox.SelectedItem is Personaje selectedCharacter)
            {
                DetailsTextBlock.Text = $"Nombre: {selectedCharacter.Nombre}\n" +
                                        $"Clase: {selectedCharacter.Clase}\n" +
                                        $"Fuerza: {selectedCharacter.Fuerza}\n" +
                                        $"Destreza: {selectedCharacter.Destreza}\n" +
                                        $"Constitución: {selectedCharacter.Constitución}\n" +
                                        $"Inteligencia: {selectedCharacter.Inteligencia}\n" +
                                        $"Sabiduría: {selectedCharacter.Sabiduría}\n" +
                                        $"Carisma: {selectedCharacter.Carisma}\n" +
                                        $"Inventario: {selectedCharacter.Objetos}\n";

                CharacterImage.Source = new BitmapImage(new Uri(selectedCharacter.ImagenRuta, UriKind.RelativeOrAbsolute));
            }

           
        }


        private void AbrirInventario_Click(object sender, RoutedEventArgs e)
        {
            if (CharacterListBox.SelectedItem is Personaje selectedCharacter) 
            {
                
                InventarioWindow inventarioWindow = new InventarioWindow(ObjetosDisponibles);

                if (inventarioWindow.ShowDialog() == true)
                {
                   
                    foreach (var objeto in inventarioWindow.ObjetosSeleccionados)
                    {
                        if (!selectedCharacter.Objetos.Contains(objeto))
                        {
                            selectedCharacter.Objetos.Add(objeto);
                        }
                    }

                    MessageBox.Show($"Objetos añadidos al personaje {selectedCharacter.Nombre}");
                }
            }
            else
            {
                MessageBox.Show("Selecciona un personaje antes de abrir el inventario.");
            }
        }







    }
}