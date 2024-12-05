using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntityFrameWorkEventos
{
    public class AppDbContext : DbContext
    {
        public DbSet<Persona> personas { get; set; }
        public DbSet<Evento> eventos { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseMySql(
                "Server=localhost;Port=3307;Database=dbpersonas2;Uid=root;Pwd=root;",
                new MariaDbServerVersion(new Version(11, 5, 2)));
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {

            modelBuilder.Entity<Persona>()
                .HasMany(p => p.Eventos)
                .WithMany(e => e.Personas)
                .UsingEntity(j => j.ToTable("eventopersona"));
        }
    }
}
