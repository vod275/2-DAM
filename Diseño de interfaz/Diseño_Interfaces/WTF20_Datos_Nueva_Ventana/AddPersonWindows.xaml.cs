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

namespace WTF20_Datos_Nueva_Ventana
{
    /// <summary>
    /// Lógica de interacción para Window1.xaml
    /// </summary>
    public partial class AddPersonWindows : Window
    {
        public ObservableCollection<Persona> _Personas { get; set; }
      

        public AddPersonWindows()
        {
            InitializeComponent();
            
            editando = false;
            indice = 0;
            this.DataContext = this;
        }

        

        private void btAgragarPersona_Click(object sender, RoutedEventArgs e)
        {
           
            
                _Personas.Add(new Persona(tbNombre.Text, tbApellidos.Text, int.Parse(tbEdad1.Text)));
                dgPersona.Items.Refresh();
           
           

            
        }


    }
}
