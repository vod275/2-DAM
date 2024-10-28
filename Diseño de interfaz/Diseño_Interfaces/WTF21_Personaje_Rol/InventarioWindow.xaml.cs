using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace WTF21_Personaje_Rol
{
    public partial class InventarioWindow : Window
    {
        public ObservableCollection<Inventario> ObjetosSeleccionados { get; private set; }

        public InventarioWindow(ObservableCollection<Inventario> objetosDisponibles)
        {
            InitializeComponent();
            ObjetosListBox.ItemsSource = objetosDisponibles;
            ObjetosSeleccionados = new ObservableCollection<Inventario>();
        }

        private void AceptarButton_Click(object sender, RoutedEventArgs e)
        {
            foreach (var item in ObjetosListBox.Items)
            {
                var container = ObjetosListBox.ItemContainerGenerator.ContainerFromItem(item) as ListBoxItem;
                if (container != null)
                {
                    var checkBox = GetCheckBoxFromListBoxItem(container);
                    if (checkBox != null && checkBox.IsChecked == true)
                    {
                        if (!ObjetosSeleccionados.Contains(item as Inventario))
                        {
                            ObjetosSeleccionados.Add(item as Inventario);
                        }
                    }
                }
            }

            DialogResult = true;
            Close();
        }


        private CheckBox GetCheckBoxFromListBoxItem(ListBoxItem item)
        {

            for (int i = 0; i < VisualTreeHelper.GetChildrenCount(item); i++)
            {
                var child = VisualTreeHelper.GetChild(item, i);
                if (child is StackPanel stackPanel)
                {
                    for (int j = 0; j < VisualTreeHelper.GetChildrenCount(stackPanel); j++)
                    {
                        var innerChild = VisualTreeHelper.GetChild(stackPanel, j);
                        if (innerChild is CheckBox checkBox)
                        {
                            return checkBox;
                        }
                    }
                }
            }
            return null;
        }


    }
}