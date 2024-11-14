namespace WPF23_Personaje_Nuevo_ROL
{
    internal class Objeto
    {
        public string NombreObjeto { get; set; }
        public string TipoObjeto { get; set; }
        public int FuerzaObjeto { get; set; }
        public int InteligenciaObjeto { get; set; }
        public int DestrezaObjeto { get; set; }
        public int ResistenciaObjeto { get; set; }

        // Constructor sin parámetros
        public Objeto() { }

        // Constructor con parámetros
        public Objeto(string nombreObjeto, string tipoObjeto, int fuerzaObjeto, int inteligenciaObjeto, int destrezaObjeto, int resistenciaObjeto)
        {
            NombreObjeto = nombreObjeto;
            TipoObjeto = tipoObjeto;
            FuerzaObjeto = fuerzaObjeto;
            InteligenciaObjeto = inteligenciaObjeto;
            DestrezaObjeto = destrezaObjeto;
            ResistenciaObjeto = resistenciaObjeto;
        }

     

        public override string ToString()
        {
            return $"{NombreObjeto} - {TipoObjeto} - " +
                   $"Fuerza: {FuerzaObjeto}, Inteligencia: {InteligenciaObjeto}, " +
                   $"Destreza: {DestrezaObjeto}, Resistencia: {ResistenciaObjeto}";
        }
    }
}
