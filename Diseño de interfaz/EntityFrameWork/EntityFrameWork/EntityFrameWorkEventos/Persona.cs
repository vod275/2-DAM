using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntityFrameWorkEventos
{
    public class Persona : IDataErrorInfo
    {

        public int Id { get; set; }
        public string Nombre { get; set; } = string.Empty;
        public int Edad { get; set; }
        public List<Evento> Eventos { get; set; } = new List<Evento>();

        public string this[string columnName]
        {
            get
            {
                switch (columnName)
                {
                    case nameof(Nombre):
                        if (string.IsNullOrWhiteSpace(Nombre))
                        {
                            return "El nombre no puede estar vacío";
                        }
                        break;
                    case nameof(Edad):
                        if (Edad <= 0)
                        {
                            return "La edad tiene que ser mayor a 0";
                        }
                        if (Edad >= 120)
                        {
                            return "La edad tiene que ser menor a 120";
                        }
                        break;
                }
                return null;
            }
           
        }

        // Aquí se podría implementar algo para el error con un throw o mensaje o lo que fuera
        public string Error => null;

        //  public List<PersonaEvento> PersonasEventos { get; } = [];

        public override string ToString()
        {
            return $"Nombre: {Nombre}, Edad: {Edad}";
        }

    }
}
