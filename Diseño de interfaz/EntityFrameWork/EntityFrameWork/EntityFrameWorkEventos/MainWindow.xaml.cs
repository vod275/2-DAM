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

namespace EntityFrameWorkEventos
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private AppDbContext _context;
        private Persona persona;
        private int errores;
        public MainWindow()
        {
            InitializeComponent();
            errores = 0;
            persona = new Persona();
            DataContext = persona;
            _context = new AppDbContext();
            _context.Database.EnsureCreated();
            LoadPeople();

        }
        private void LoadPeople()
        {
            try
            {
                var people = _context.personas.ToList();
                DataGridEjemplo.ItemsSource = people;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar los datos" + ex.Message);
            }

        }

        private void btnAgregar_Click(object sender, RoutedEventArgs e)
        {
            string nombre = txtNombre.Text.Trim();
            int edad = int.Parse(txtEdad.Text.Trim());
            try
            {
                persona = new Persona { Nombre = nombre, Edad = edad };
                _context.personas.Add(persona);
                _context.SaveChanges();
                txtNombre.Clear();
                txtEdad.Clear();
                LoadPeople();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al agragar los datos" + ex.Message);
            }
        }
        private void btnBorrar_Click(object sender, RoutedEventArgs e)
        {
            persona = DataGridEjemplo.SelectedItem as Persona;
            if (persona != null)
            {
                using (var context = new AppDbContext())
                {
                    context.personas.Remove(persona);
                    context.SaveChanges();
                    LoadPeople();
                }
            }
        }

        private void btnModificar_Click(object sender, RoutedEventArgs e)
        {
            persona = DataGridEjemplo.SelectedItem as Persona;
            if (persona != null)
            {
                using (var context = new AppDbContext())
                {
                    persona.Nombre = txtNombre.Text;
                    persona.Edad = int.Parse(txtEdad.Text);
                    context.SaveChanges();
                    LoadPeople();
                }

            }
        }

        private void btnAgregarEvento_Click(object sender, RoutedEventArgs e)
        {
            string nombre = txtNombreEvento.Text;
            try
            {
                var evento = new Evento { Nombre = nombre};
                _context.eventos.Add(evento);
                _context.SaveChanges();
                txtNombreEvento.Clear();
                LoadPeople();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al agragar los datos" + ex.Message);
            }
        }

        private void btnMostrarEventos_Click(object sender, RoutedEventArgs e)
        {
            persona = DataGridEjemplo.SelectedItem as Persona;
            if (persona != null)
            {
                try
                {
                    _context.Entry(persona).Collection(p => p.Eventos).Load();

                    string eventos = persona.Eventos.Any()? string.Join(", ", persona.Eventos.Select(e => e.Nombre)): "No tiene eventos asignados.";

                    MessageBox.Show($"Eventos de {persona.Nombre}: {eventos}");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error al mostrar los eventos: " + ex.Message);
                }
            }
            else
            {
                MessageBox.Show("Por favor, selecciona una persona.");
            }
        }


        private void Validation_Error(object sender,ValidationErrorEventArgs e)
        {
            if(e.Action == ValidationErrorEventAction.Added)
            {
                errores++;
            }
            else
            {
                errores--;
            }

            if(errores == 0)
            {
                Estado.Text = "";
            }
            else
            {
                Estado.Text = "Hay datos no válidos en el añadir persona";
            }
        }


    }
}