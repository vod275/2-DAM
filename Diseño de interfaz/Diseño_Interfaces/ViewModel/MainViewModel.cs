using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Threading;

namespace ViewModel
{
    public class MainViewModel : INotifyPropertyChanged
    {
        private Persona _personaCreada;
        private Persona _selectedPersona;
        private bool _isNuttonEnabled;
        private DispatcherTimer _timer;
        private int _timeTemaining;
        private double _progressValue;

        public event PropertyChangedEventHandler? PropertyChanged;

       public ObservableCollection<Persona> lista { get; set; } = new ObservableCollection<Persona>();

        public MainViewModel()
        {
            lista = new ObservableCollection<Persona>();
            PersonaCreada = new Persona();
            ProgressValue = 100;
            _timeTemaining = 60;

            _timer = new DispatcherTimer();
            _timer.Interval = TimeSpan.FromSeconds(1);
            _timer.Tick += Timer_Tick;
            StartTimer();

        }

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


        public Persona SelectedPersona
        {
            get => _selectedPersona;
            set
            {
                _selectedPersona = value;
                OnPropertyChanged(nameof(SelectedPersona));
            }
        }

        public double ProgressValue
        {
            get => _progressValue;
            set
            {
                _progressValue = value;
                OnPropertyChanged(nameof(ProgressValue));
            }
        }


        public void AgregarPersona(Persona persona)
        {
            
            lista.Add(persona);    

        }


        public void StartTimer()
        {

            ProgressValue = 100;
            _timeTemaining = 60;
            _timer.Start();
        }

        public void Timer_Tick(object sender, EventArgs e)
        {
            _timeTemaining--;
            if (_timeTemaining == 0)
            {
                _timer.Stop();
                ProgressValue = 0;
            }
            else
            {
                ProgressValue = (_timeTemaining / 60.0) * 100;
            }
        }



    }
}
