using MySql.Data.MySqlClient;
using System;
using System.Configuration;


namespace WPF23_Personaje_Nuevo_ROL
{
    internal class Repositorio
    {


 
        // Método para agregar un personaje
        public static void AgregarPersonaje(string nombrePersonaje, string clase, bool genero, int fuerza, int inteligencia, int destreza, int resistencia, string foto)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                connection.Open();
                string query = "INSERT into personaje (nombre, clase, genero, fuerza, inteligencia, destreza, resistencia, foto) VALUES (@nombre, @clase, @genero, @fuerza, @inteligencia, @destreza, @resistencia, @foto)";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@nombre", nombrePersonaje);
                    command.Parameters.AddWithValue("@clase", clase);
                    command.Parameters.AddWithValue("@genero", genero);
                    command.Parameters.AddWithValue("@fuerza", fuerza);
                    command.Parameters.AddWithValue("@inteligencia", inteligencia);
                    command.Parameters.AddWithValue("@destreza", destreza);
                    command.Parameters.AddWithValue("@resistencia", resistencia);
                    command.Parameters.AddWithValue("@foto", foto);
                    command.ExecuteNonQuery();

                }


            }
        }
    }
}
