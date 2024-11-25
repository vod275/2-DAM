using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aplicación_de_reservas_del_cine
{
    internal class Repositorio
    {

        // Método para agregar un personaje
        public static async Task AgregarPelicula(string titulo, string descripcion, float precioEntrada, string imagen)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                await connection.OpenAsync();
                string query = "INSERT into peliculas (titulo, descripcion, precioEntrada, imagen) VALUES (@titulo, @desccripcion, @precioEntrada, @imagen)";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@titulo", titulo);
                    command.Parameters.AddWithValue("@desccripcion", descripcion);
                    command.Parameters.AddWithValue("@precioEntrada", precioEntrada);
                    command.Parameters.AddWithValue("@imagen", imagen);
                    await command.ExecuteNonQueryAsync();

                }


            }
        }

        public async static Task<ObservableCollection<Pelicula>> CargarPeliculas()
        {
            ObservableCollection<Pelicula> listaPeliculas = new ObservableCollection<Pelicula>();
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                await connection.OpenAsync();
                string query = "SELECT titulo, descripcion, precioEntrada, imagen FROM peliculas";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    using (var reader = await command.ExecuteReaderAsync())
                    {
                        while (await reader.ReadAsync())
                        {
                            Pelicula pelicula = new Pelicula
                            {
                                Titulo = reader.GetString(0),
                                Descripcion = reader.GetString(1),
                                PrecioEntrada = reader.GetFloat(2),
                                Imagen = reader.GetString(3),
                            };

                            listaPeliculas.Add(pelicula);
                        }
                    }
                }
            }

            return listaPeliculas;
        }


        public static void EliminarPelicula(string nombrePelicula)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                connection.Open();
                string query = "DELETE FROM peliculas WHERE titulo = @titulo";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@titulo", nombrePelicula);
                    command.ExecuteNonQuery();
                }
            }
        }


        public static void ActualizarPelicula(Pelicula pelicula)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                connection.Open();

                string query = @"UPDATE peliculas 
                         SET titulo = @titulo, 
                             descripcion = @descripcion, 
                             precioEntrada = @precioEntrada, 
                             imagen = @imagen, 
                         WHERE titulo = @titulo";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@titulo", pelicula.Titulo);
                    command.Parameters.AddWithValue("@descripcion", pelicula.Descripcion);
                    command.Parameters.AddWithValue("@precioEntrada", pelicula.PrecioEntrada);
                    command.Parameters.AddWithValue("@imagen", pelicula.Imagen);
                    command.ExecuteNonQuery();
                }
            }
        }

        public static async Task AgregarEntrada(string nombreCliente,  bool carnetJoven, int cantidadEntradas, float total)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                await connection.OpenAsync();
                string query = "INSERT into asientos (nombreCliente, carnetJoven, cantidadEntradas, total) VALUES (@nombreCliente, @carnetJoven, @cantidadEntradas, @total)";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@nombreCliente", nombreCliente);
                    command.Parameters.AddWithValue("@carnetJoven", carnetJoven);
                    command.Parameters.AddWithValue("@cantidadEntradas", cantidadEntradas);
                    command.Parameters.AddWithValue("@total", total);
                    await command.ExecuteNonQueryAsync();

                }


            }
        }
    }
}
