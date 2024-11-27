using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

namespace WPF23_Entity_Frame_Work_DIFICIL
{
    internal class AppDbContext : DbContext
    {


        public DbSet<Persona> Personas { get; set; }
        public DbSet<Eventos> Eventos { get; set; }
        //public DbSet<PersonaEvento> PersonasEventos { get; set; }



        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseMySql("Server=localhost;Port=3307;DataBase=dbpersonas2;User Id=root;Password=root;",
                new MariaDbServerVersion(new Version(11, 5, 2)));
        }


    }
}
