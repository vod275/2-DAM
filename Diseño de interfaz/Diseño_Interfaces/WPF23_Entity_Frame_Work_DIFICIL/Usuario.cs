using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPF23_Entity_Frame_Work_DIFICIL
{
    public class Usuario : IDataErrorInfo
    {
        

        public int id {  get; set; }

        public string Name { get; set; }

        public string Email { get; set; }

        public string Edad { get; set; }
        public string Error => null;


        public string this[string columnName]
        {
            get
            {
                string result = null;

                switch (columnName)
                {
                    case nameof(Name):
                        if (string.IsNullOrWhiteSpace(Name))
                        {
                            result = "El nombre no puede estar vacío.";
                        }
                        else if (Name.Length < 3)
                        {
                            result = "El nombre debe tener al menos 3 caracteres.";
                        }
                        break;

                    case nameof(Email):
                        if (string.IsNullOrWhiteSpace(Email))
                        {
                            result = "El email no puede estar vacío.";
                        }
                        else if (!Email.Contains("@") || !Email.Contains("."))
                        {
                            result = "El email debe tener un formato válido.";
                        }
                        break;

                    case nameof(Edad):
                        if (!int.TryParse(Edad, out int edad) || edad < 0 || edad > 120)
                        {
                            result = "La edad debe ser un número entre 0 y 120.";
                        }
                        break;
                }

                return result;
            }
        }
    }
}
