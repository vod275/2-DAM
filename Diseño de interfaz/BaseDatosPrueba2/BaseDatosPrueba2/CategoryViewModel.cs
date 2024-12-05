using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaseDatosPrueba2
{
    public class CategoryViewModel : INotifyPropertyChanged
    {
        private string _categoryName;

        public int CategoryId { get; set; }
        public string CategoryName
        {
            get => _categoryName;
            set
            {
                _categoryName = value;
                OnPropertyChanged(nameof(CategoryName));
            }
        }

        public ObservableCollection<Book> Books { get; set; }

        public CategoryViewModel()
        {
            Books = new ObservableCollection<Book>();
        }

        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
