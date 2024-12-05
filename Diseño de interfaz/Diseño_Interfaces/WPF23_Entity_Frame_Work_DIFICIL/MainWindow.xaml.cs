using Microsoft.EntityFrameworkCore;
using System.Collections.ObjectModel;
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


namespace WPF23_Entity_Frame_Work_DIFICIL
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private AppDbContext _context;
        private Usuario usuario;
        private Persona persona;
        int errores;
        public MainWindow()
        {
            InitializeComponent();
            persona = new Persona();
            DataContext = persona;
            _context = new AppDbContext();
            _context.Database.EnsureCreated();
            LoadPeople();
            usuario = new Usuario();
            errores = 0;
        }


        private void Validation_Error(object sender, ValidationErrorEventArgs e)
        {
            if(e.Action == ValidationErrorEventAction.Added)
            {
                errores++;

            }
            else
            {
                errores--;
            }

            if (errores == 0)
            {
                Estado.Text = "";
            }
        }

        private void LoadPeople()
        {
            try
            {
                var people = _context.Personas.ToList();
                dgPersona.ItemsSource = people;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar los datos" + ex.Message);
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
                var persona = new Persona { nombre = nombre, edad = edad };
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


        private void btnBorrar_Click(object sender, RoutedEventArgs e)
        {
            persona = dgPersona.SelectedItem as Persona;
            if (persona != null)
            {
                using (var context = new AppDbContext())
                {
                    context.Personas.Remove(persona);
                    context.SaveChanges();
                    LoadPeople();
                }
            }
        }

    }
}