using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPF22_MINI_ITO
{
    internal class Repositorio
    {


        public static void AgregarEmpleado(string nombreEmpleado, string rol, float coste_por_Hora)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                connection.Open();
                string query = "INSERT into empleado (nombre, rol, coste_por_Hora) VALUES (@nombre, @rol, @coste_por_Hora)";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@nombre", nombreEmpleado);
                    command.Parameters.AddWithValue("@rol", rol);
                    command.Parameters.AddWithValue("@coste_por_Hora", coste_por_Hora);
                    command.ExecuteNonQuery();

                }


            }
        }



        public static ObservableCollection<Empleado> CargarEmpleados()
        {
            ObservableCollection<Empleado> listaEmpleados = new ObservableCollection<Empleado>();
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                connection.Open();
                string query = "SELECT nombre, rol, coste_por_hora FROM empleado";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    using (MySqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            Empleado empleado = new Empleado
                            {
                                NombreEmpleado = reader.GetString("nombre"),
                                Rol = reader.GetString("rol"),
                                Coste_por_Hora = reader.GetFloat("coste_por_hora"),
                                
                            };

                            listaEmpleados.Add(empleado);
                        }
                    }
                }
            }

            return listaEmpleados;
        }



        public static void AgregarProyecto(string nombreProyecto, float presupuestoInicial)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                connection.Open();
                string query = "INSERT into proyecto (nombre, presupuesto_inicial) VALUES (@nombre, @presupuesto_inicial)";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@nombre", nombreProyecto);
                    command.Parameters.AddWithValue("@presupuesto_inicial", presupuestoInicial);
                    command.ExecuteNonQuery();

                }


            }
        }

        public static ObservableCollection<DatosIniciales> CargarProyecto()
        {
            ObservableCollection<DatosIniciales> listaProyectos = new ObservableCollection<DatosIniciales>();
            string connectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;

            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                connection.Open();
                string query = "SELECT  nombre, presupuesto_inicial FROM proyecto";

                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    using (MySqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            DatosIniciales datosIniciales = new DatosIniciales
                            {
                                NombreProyecto = reader.GetString("nombre"),
                                PresupuestoInicial = reader.GetFloat("presupuesto_inicial"),
                                

                            };

                            listaProyectos.Add(datosIniciales);
                        }
                    }
                }
            }

            return listaProyectos;
        }

    }


    
}
