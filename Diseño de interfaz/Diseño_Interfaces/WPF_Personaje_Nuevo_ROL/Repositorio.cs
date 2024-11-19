using MySql.Data.MySqlClient;
using System;
using System.Collections.ObjectModel;
using System.Configuration;


namespace WPF23_Personaje_Nuevo_ROL
{
    internal class Repositorio
    {


 
        // Método para agregar un personaje
        public static void AgregarPersonaje(string nombrePersonaje, string clase, string genero, int fuerza, int inteligencia, int destreza, int resistencia, string foto)
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


        public static ObservableCollection<Personaje> CargarPersonajes()
        {
            ObservableCollection<Personaje> lista = new ObservableCollection<Personaje>();
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                connection.Open();
                string query = "SELECT nombre, clase, genero, fuerza, inteligencia, destreza, resistencia, foto FROM personaje";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    using (MySqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            Personaje personaje = new Personaje
                            {
                                NombrePersonaje = reader.GetString("nombre"),
                                Clase = reader.GetString("clase"),
                                Genero = reader.GetString("genero"),
                                Fuerza = reader.GetInt32("fuerza"),
                                Inteligencia = reader.GetInt32("inteligencia"),
                                Destreza = reader.GetInt32("destreza"),
                                Resistencia = reader.GetInt32("resistencia"),
                                Foto = reader.GetString("foto")
                            };

                            lista.Add(personaje);
                        }
                    }
                }
            }

            return lista;
        }

        public static ObservableCollection<Objeto> CargarObjetos()
        {
            ObservableCollection<Objeto> listaObjetos = new ObservableCollection<Objeto>();
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                connection.Open();
                string query = "SELECT  nombre, tipo, fuerza, inteligencia, destreza, resistencia FROM objeto";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    using (MySqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            Objeto objeto = new Objeto
                            {

                                NombreObjeto = reader.GetString("nombre"),
                                TipoObjeto = reader.GetString("tipo"),
                                FuerzaObjeto = reader.GetInt16("fuerza"),
                                InteligenciaObjeto = reader.GetInt16("inteligencia"),
                                DestrezaObjeto = reader.GetInt16("destreza"),
                                ResistenciaObjeto = reader.GetInt16("resistencia")
                             
                            };

                            listaObjetos.Add(objeto);
                        }
                    }
                }
            }

            return listaObjetos;
        }

        public static void ActualizarPersonaje(Personaje personaje)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                connection.Open();

                string query = @"UPDATE personaje 
                         SET clase = @clase, 
                             genero = @genero, 
                             fuerza = @fuerza, 
                             inteligencia = @inteligencia, 
                             destreza = @destreza, 
                             resistencia = @resistencia, 
                             foto = @foto
                         WHERE nombre = @nombre";

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
