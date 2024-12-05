using Microsoft.EntityFrameworkCore;
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
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace EntityFrameWork
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
            _context= new AppDbContext();
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
                MessageBox.Show("Error al cargar los datos"+ex.Message);
            }
            
        }

        private void btnAgregar_Click(object sender, RoutedEventArgs e)
        {
            string nombre= txtNombre.Text.Trim();
            int edad = int.Parse(txtEdad.Text.Trim());
            try
            {
                var person = new Persona { Nombre = nombre, Edad = edad };
                _context.personas.Add(person);
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


        private void borrarPersona(int id)
        {
            using (var context = new AppDbContext())
            {
                var persona = context.personas.FirstOrDefault(p => p.Id == id);

                if (persona != null)
                {
                    context.personas.Remove(persona);
                    context.SaveChanges();
                    Console.WriteLine("Persona eliminada correctamente");
                }
                else
                {
                    Console.WriteLine($"No se encontró esa persona con ID {id}");
                }


            }
        }

        private void modificarPersona(int id, string nuevoNombre, int nuevaEdad)
        {
            using (var context = new AppDbContext())
            {
                var persona = context.personas.FirstOrDefault(p=>p.Id == id);
                if(persona != null)
                {
                    persona.Nombre = nuevoNombre;
                    persona.Edad = nuevaEdad;
                    context.SaveChanges();
                }
            }
        }



        private void btnBorrar_Click(object sender, RoutedEventArgs e)
        {
            var persona = DataGridEjemplo.SelectedItem as Persona;
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
            var persona = DataGridEjemplo.SelectedItem as Persona;
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


        public void ConsultarSql(int edadMinima)
        {
            using (var context = new AppDbContext())
            {
                var personas = context.personas.FromSqlInterpolated($"SELECT * FROM Personas Where Edad > {edadMinima}").ToList();

                Console.WriteLine($"Personas con edad mayor a {edadMinima}: ");
                foreach ( var persona in personas)
                {
                    Console.WriteLine($"Persona: {persona.Nombre} Edad: {persona.Edad}");
                }
                    
            }
        }

        private void btnAgregarMascota_Click(object sender, RoutedEventArgs e)
        {
            var persona = DataGridEjemplo.SelectedItem as Persona;

            if (persona != null)
            {
                using (var context = new AppDbContext())
                {
                    string nombre = txtNombreMascota.Text.Trim();
                    string tipo = txtTipoMascota.Text.Trim();
                    int personaId = persona.Id;
                    var mascota = new Mascota{ Nombre = nombre, Tipo = tipo ,personaId=personaId};
                    _context.mascotas.Add(mascota);
                    _context.SaveChanges();
                    txtNombreMascota.Clear();
                    txtTipoMascota.Clear();
                    LoadPeople();
                }
            }
        }
    }
}