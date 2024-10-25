using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Windows;
using System.Windows.Controls;

namespace WTF21_Personaje_Rol
{
    public partial class InventarioWindow : Window
    {
        public ObservableCollection<Inventario> ObjetosSeleccionados { get; private set; }

        public InventarioWindow(ObservableCollection<Inventario> objetosDisponibles)
        {
            InitializeComponent();
            ObjetosListBox.ItemsSource = objetosDisponibles;
            ObjetosSeleccionados = new ObservableCollection<Inventario>
            {
                new Inventario("Espada", 5, 3, 2, 0, 0, 0),
                new Inventario("Escudo", 0, 0, 5, 0, 0, 0),
                new Inventario("Poción de Salud", 0, 0, 0, 0, 0, 2)
            };



        }

        private void AceptarButton_Click(object sender, RoutedEventArgs e)
        {

            foreach (var item in ObjetosListBox.Items)
            {
                var container = ObjetosListBox.ItemContainerGenerator.ContainerFromItem(item) as ListBoxItem;
                if (container != null)
                {
                    var checkBox = container.ContentTemplate.FindName("Content", container) as CheckBox;
                    if (checkBox != null && checkBox.IsChecked == true)
                    {
                        ObjetosSeleccionados.Add(item as Inventario); 
                    }
                }
            }

            DialogResult = true;
            Close();
        }
    }
}
