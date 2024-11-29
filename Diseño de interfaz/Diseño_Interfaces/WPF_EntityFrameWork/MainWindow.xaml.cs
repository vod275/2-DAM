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
        private Usuario usuario;
        int errores;

        private AppDbContext _context;
        public MainWindow()
        {
            InitializeComponent();
            _context = new AppDbContext();
            _context.Database.EnsureCreated();
            LoadPeopleAndMascotas();
            usuario = new Usuario();
            errores = 0;
        }


        public void LoadPeopleAndMascotas()
        {
            try
            {
                var mascotas = _context.Mascotas.ToList();
                var people = _context.Personas.ToList();
                dgPersona.ItemsSource = people;
                dgMascota.ItemsSource = mascotas;

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
                LoadPeopleAndMascotas();
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error al guardar la persona: {ex.Message}");
            }
        }


        private void btAgregarMascota_Click(object sender, RoutedEventArgs e)
        {
            string nombre = tbNombreMascota.Text;

            if (string.IsNullOrWhiteSpace(nombre))
            {
                MessageBox.Show("El nombre de la mascota no puede estar vacío.");
                return;
            }

             string tipo = tbTipo.Text;
            if (string.IsNullOrWhiteSpace(tipo))
            {
                MessageBox.Show("El nombre de la mascota no puede estar vacío.");
                return;
            }

            if (!int.TryParse(tbPersonaID.Text, out int personaid))
            {
                MessageBox.Show("La edad debe ser un número válido.");
                return;
            }

            try
            {
                var mascota = new Mascotas { nombre = nombre, tipo = tipo, personaid = personaid };
                _context.Mascotas.Add(mascota);
                _context.SaveChanges();
                MessageBox.Show("Mascota creada exitosamente.");
                tbNombreMascota.Clear();
                tbTipo.Clear();
                tbPersonaID.Clear();
                LoadPeopleAndMascotas();
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
                    LoadPeopleAndMascotas();

                }


            }

        }

        private void btEliminarMascota_Click(object sender, RoutedEventArgs e)
        {
            using (var context = new AppDbContext())
            {
                Mascotas mascotaSeleccionada = dgMascota.SelectedItem as Mascotas;

                if (mascotaSeleccionada != null)
                {
                    context.Remove(mascotaSeleccionada);

                    context.SaveChanges();
                    Console.WriteLine("Se borro");
                    LoadPeopleAndMascotas();

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
                    LoadPeopleAndMascotas();

                }
            }

        }

        private void btModificarMascota_Click(object sender, RoutedEventArgs e)
        {

            using (var context = new AppDbContext())
            {
                Mascotas mascotaSeleccionada = dgMascota.SelectedItem as Mascotas;
                if (mascotaSeleccionada != null)
                {
                    mascotaSeleccionada.nombre = tbNombreMascota.Text;
                    mascotaSeleccionada.tipo = tbTipo.Text;
                    mascotaSeleccionada.personaid = int.Parse(tbPersonaID.Text);

                    context.SaveChanges();
                    LoadPeopleAndMascotas();

                }
            }

        }


        private void BuscarPersonaPorId(int id)
        {
            using (var context = new AppDbContext())
            {
                
            }
        }
    }
}