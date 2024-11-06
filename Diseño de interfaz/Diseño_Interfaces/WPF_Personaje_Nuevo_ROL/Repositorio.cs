using System;
using System.Configuration;


namespace WPF23_Personaje_Nuevo_ROL
{
    internal class Repositorio
    {
        private readonly string _connectionString;

        public PersonajeRepositorio()
        {
            _connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;
        }

        // Método para agregar un personaje
        public void AgregarPersonaje(Personaje personaje)
        {
            using (MySqlConnection connection = new MySqlConnection(_connectionString))
            {
                connection.Open();
                string query = @"INSERT INTO Personaje (nombre, clase, genero, fuerza, inteligencia, destreza, resistencia, foto) 
                             VALUES (@nombre, @clase, @genero, @fuerza, @inteligencia, @destreza, @resistencia, @foto)";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@nombre", personaje.NombrePersonaje);
                    command.Parameters.AddWithValue("@clase", personaje.Clase);
                    command.Parameters.AddWithValue("@genero", personaje.Genero);
                    command.Parameters.AddWithValue("@fuerza", personaje.Fuerza);
                    command.Parameters.AddWithValue("@inteligencia", personaje.Inteligencia);
                    command.Parameters.AddWithValue("@destreza", personaje.Destreza);
                    command.Parameters.AddWithValue("@resistencia", personaje.Resistencia);
                    command.Parameters.AddWithValue("@foto", personaje.Foto);

                    command.ExecuteNonQuery();
                }
            }
        }
    }
}
