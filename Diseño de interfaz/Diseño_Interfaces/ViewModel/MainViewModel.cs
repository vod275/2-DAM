using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ViewModel
{
    internal class MainViewModel : INotifyPropertyChanged
    {
        private Persona _personaCreada; 

        public event PropertyChangedEventHandler? PropertyChanged;

        protected void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public Persona PersonaCreada
        {
            get => _personaCreada;
            set
            {
                _personaCreada = value;
                OnPropertyChanged(nameof(PersonaCreada));

            }

        }


        public void AgregarPersona(Persona persona)
        {
            Persona p = new Persona();
            listaPersona.Add(p);    

        }

     
      
    }
}
