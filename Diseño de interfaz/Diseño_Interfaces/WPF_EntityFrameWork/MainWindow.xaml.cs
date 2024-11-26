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
using WPF22_EntityFrameWork;

namespace WPF_EntityFrameWork
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        private AppDbContext _context;
        public MainWindow()
        {
            InitializeComponent();
            _context = new AppDbContext();
            _context.Database.EnsureCreated();
            LoadPeople();
        }


        public void LoadPeople()
        {
            try
            {
                var people = _context.Personas.ToList();
                dgPersona.ItemsSource = people;s

            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);

            }


        }

        private void btAgregar_Click(object sender, RoutedEventArgs e)
        {
            string nombre = tbNombre.Text;

            if (string.IsNullOrWhiteSpace(nombre))
            {
                MessageBox.Show("El nombre no puede estar vacío.");
                return;
            }

            if (!int.TryParse(tbEdad.Text, out int edad))
            {
                MessageBox.Show("La edad debe ser un número válido.");
                return;
            }

            try
            {
                var persona = new Persona { Nombre = nombre, Edad = edad };
                _context.Personas.Add(persona);
                _context.SaveChanges(); // INSERT
                MessageBox.Show("Persona creada exitosamente.");
                tbEdad.Clear();
                tbNombre.Clear();
                LoadPeople();
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error al guardar la persona: {ex.Message}");
            }
        }



        private void btEliminarPersona_Click(object sender, RoutedEventArgs e)
        {
            using (var context = new AppDbContext())
            {
                Persona personaSeleccionada = dgPersona.SelectedItem as Persona;
                if (personaSeleccionada != null)
                {

                    context.Remove(personaSeleccionada);
                    context.SaveChanges();
                    Console.WriteLine("Se borro");
                    LoadPeople();

                }


            }

        }


        private void btModificarPersona_Click(object sender, RoutedEventArgs e)
        {
 
            using (var context = new AppDbContext())
            {
                Persona personaSeleccionada = dgPersona.SelectedItem as Persona;
                if (personaSeleccionada != null)
                {
                    personaSeleccionada.Nombre = tbNombre.Text;
                    personaSeleccionada.Edad = int.Parse(tbEdad.Text);

                    context.SaveChanges();
                    LoadPeople();

                }
            }

        }
    }
}