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

namespace WTF04
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        List<string> list = new List<string>();
        public MainWindow()
        {
            InitializeComponent();
            list.Add("kg");
            list.Add("gr");
            list.Add("Mlgr");
        }

        private void Text2_TextChanged(object sender, TextChangedEventArgs e)
        {

        }
    }
}