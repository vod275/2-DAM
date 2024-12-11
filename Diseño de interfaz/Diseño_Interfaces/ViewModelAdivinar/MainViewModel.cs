using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Threading;

namespace ViewModelAdivinar
{
    internal class MainViewModel : INotifyPropertyChanged
    {
       
        private DispatcherTimer _timer;
        private int _timeTemaining;
        private double _progressValue;





        public event PropertyChangedEventHandler? PropertyChanged;
        protected void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public MainViewModel()
        {
           
            ProgressValue = 100;
            _timeTemaining = 60;

            _timer = new DispatcherTimer();
            _timer.Interval = TimeSpan.FromSeconds(1);
            _timer.Tick += Timer_Tick;
            

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
        public void StartTimer()
        {

            ProgressValue = 100;
            _timeTemaining = 60;
            _timer.Start();
        }

        public void StartTimerDificil()
        {

            ProgressValue = 50;
            _timeTemaining = 30;
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
