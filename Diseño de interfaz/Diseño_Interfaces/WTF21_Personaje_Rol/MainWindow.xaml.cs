using System.Collections.ObjectModel;
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

        public MainWindow()
        {
            InitializeComponent();
            Personajes = new ObservableCollection<Personaje>();
            CharacterListBox.ItemsSource = Personajes;
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
                                        $"Sabiduría: {selectedCharacter.Carisma}";
                CharacterImage.Source = new BitmapImage(new Uri(selectedCharacter.ImagenRuta, UriKind.RelativeOrAbsolute));
            }
        }
    }
}