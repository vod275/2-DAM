using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntityFrameWork
{
    public class AppDbContext : DbContext
    {
        public DbSet<Persona> personas { get; set; }
        public DbSet<Mascota> mascotas { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseMySql("Server=localhost;Port=3307;Database=dbpersonas;Uid=root;Pwd=root;", new MariaDbServerVersion(new Version(11, 5, 2)));

        }

    }
}
