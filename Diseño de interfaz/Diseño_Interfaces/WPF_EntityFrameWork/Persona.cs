﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPF22_EntityFrameWork
{
    public class Persona
    {
        public int Id { get; set; }
        public string Nombre { get; set; } = string.Empty;
        public int Edad { get; set; }

        public ICollection<Mascotas> Mascotas { get;} = new List<Mascotas>();   


    }
}
