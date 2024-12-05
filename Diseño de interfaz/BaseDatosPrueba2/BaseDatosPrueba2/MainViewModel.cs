using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaseDatosPrueba2
{
    public class MainViewModel : INotifyPropertyChanged
    {
        public ObservableCollection<BookViewModel> Books { get; set; }
        public ObservableCollection<CategoryViewModel> Categories { get; set; }

        private BookViewModel _selectedBook;

        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public BookViewModel SelectedBook
        {
            get => _selectedBook;
            set
            {
                _selectedBook = value;
                OnPropertyChanged(nameof(SelectedBook));
            }
        }

        public MainViewModel()
        {
            LoadData();
        }

        private void LoadData()
        {
            using (var context = new SampleContext())
            {
                var books = context.Books
                    .Include(b => b.Categories)
                    .ToList();

                Books = new ObservableCollection<BookViewModel>(
                    books.Select(b => new BookViewModel
                    {
                        BookId = b.BookId,
                        Title = b.Title,
                        Categories = new ObservableCollection<Category>(b.Categories) 
                    })
                );
            }
        }
    }
}
