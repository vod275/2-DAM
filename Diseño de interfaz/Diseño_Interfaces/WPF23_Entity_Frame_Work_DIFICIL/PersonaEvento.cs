﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPF23_Entity_Frame_Work_DIFICIL
{
    class PersonaEvento
    {
        public int personaid {  get; set; }
        public int eventoid { get; set; }

        public Persona persona { get; set; } = null!;

        public Evento evento { get; set; } = null!;
    }
}
