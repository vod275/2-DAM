using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;


namespace WTF19_Data_Grid
{
    /// <summary>
    /// Lógica de interacción para AddPersona.xaml
    /// </summary>
    public partial class AddPersona : Window
    {
        public ObservableCollection<Persona> _persona;
        public AddPersona(ObservableCollection<Persona> personas)
        {
            InitializeComponent();

            _persona = personas;
        }

        private void btAgragarPersona_Click(object sender, RoutedEventArgs e)
        {
            var persona = new Persona(tbNombre2.Text, tbApellidos2.Text, int.Parse(tbEdad2.Text));
            _persona.Add(persona);
            this.Close();
        }
    }
}
