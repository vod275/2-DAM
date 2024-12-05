using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaseDatosPrueba2
{
    public class Book
    {
        public int BookId { get; set; }
        public string Title { get; set; }
        public ICollection<Category> Categories { get; set; } = new List<Category>();
    }
}
