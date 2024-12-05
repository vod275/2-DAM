using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace WPF23_Entity_Frame_Work_DIFICIL
{
    public class Persona
    {
        public int id { get; set; }
        public string nombre { get; set; } = string.Empty;
        public int edad { get; set; }
        public List<Evento> Eventos { get; } = new List<Evento>();


        public string this[string columnName]
        {
            get
            {
                switch (columnName)
                {
                    case nameof(nombre):
                        if (string.IsNullOrWhiteSpace(nombre))
                        {
                            return "El nombre no puede estar vacío";
                        }
                        break;
                    case nameof(edad):
                        if (edad <= 0)
                        {
                            return "La edad tiene que ser mayor a 0";
                        }
                        if (edad >= 120)
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
            return $"Nombre: {nombre}, Edad: {edad}";
        }

    }
}
