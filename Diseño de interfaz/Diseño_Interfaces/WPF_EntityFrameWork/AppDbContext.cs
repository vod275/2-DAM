using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPF22_EntityFrameWork
{
    internal class AppDbContext : DbContext
    {

        public DbSet<Persona> Personas { get; set; }


        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseMySql("Server=localhost;Port=3307;DataBase=dbpersonas;User Id=root;Password=root;",
                new MariaDbServerVersion(new Version(11, 5, 2)));
        }



    }
}
