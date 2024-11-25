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
                dgPersona.ItemsSource = people;

            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message);

            }


        }

        private void btAgregar_Click(object sender, RoutedEventArgs e)
        {
            string nombre = tbNombre.Text;
            int edad = int.Parse(tbEdad.Text);
            try
            {
                var persona = new Persona { Nombre = nombre, Edad = edad.ToString()};
                _context.Personas.Add(persona);
                _context.SaveChanges();//INSERT
                MessageBox.Show("Persona Creada");
                tbEdad.Clear();
                tbNombre.Clear();
                LoadPeople();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);

            }
        }
    }
}