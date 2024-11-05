package BBDD;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploObtenerTablasYColumnas {

	public static void main(String[] args) {

		mysqlTablas();
		System.out.println("");
		System.out.println("");
		oracleTablas();
		System.out.println("");
		System.out.println("");
		derbyTablas();
		System.out.println("");
		System.out.println("");
		sqliteTablas();
		System.out.println("");
		System.out.println("");
		hsqldbTablas();
		System.out.println("");
		System.out.println("");
		ascessTablas();
		System.out.println("");
		System.out.println("");
		h2Tablas();

	}

	public static void mysqlTablas() {

		Connection conexion = null;
		ResultSet resul = null;

		try {

			// Establecer conexión
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");

			DatabaseMetaData dbmd = conexion.getMetaData();

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS  MYSQL:");
			System.out.println("===================================");
			System.out.printf("Nombre : %s %n", nombre);
			System.out.printf("Driver : %s %n", driver);
			System.out.printf("URL : %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);

			// Obtener información de las tablas y vistas que hay
			resul = dbmd.getTables("ejemplo", null, null, null); // Cambiado para obtener todas las tablas

			while (resul.next()) {
				String catalogo = resul.getString(1); // columna 1
				String esquema = resul.getString(2); // columna 2
				String tabla = resul.getString(3); // columna 3
				String tipo = resul.getString(4); // columna 4
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			
			System.out.println("-----------------------------------------------------------------");
			System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
			System.out.println("===================================");
			ResultSet columnas=null;
			columnas = dbmd.getColumns("ejemplo", null, "departamentos", null);
			while (columnas.next()) {
			 String nombCol = columnas.getString("COLUMN_NAME"); //getString(4)
			 String tipoCol = columnas.getString("TYPE_NAME"); //getString(6)
			 String tamCol = columnas.getString("COLUMN_SIZE"); //getString(7)
			 String nula = columnas.getString("IS_NULLABLE"); //getString(18)
			 System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol, nula);
			 
			 
			 //ClavePrimaria
			 ResultSet pk = dbmd.getPrimaryKeys("ejemplo", null,  "departamentos");
			 String pkDep="", separador="";
			 while (pk.next()) {
			  pkDep = pkDep + separador +
			  pk.getString("COLUMN_NAME");//getString(4)
			  separador="+";
			 }
			 System.out.println("Clave Primaria: " + pkDep);
			 
			 
			 //ClaveForanea
			 ResultSet fk = dbmd.getExportedKeys( "ejemplo", null, "departamentos");
			 while (fk.next()) {
			  String fk_name = fk.getString("FKCOLUMN_NAME");
			  String pk_name = fk.getString("PKCOLUMN_NAME");
			  String pk_tablename = fk.getString("PKTABLE_NAME");
			  String fk_tablename = fk.getString("FKTABLE_NAME");
			  System.out.printf("Tabla PK: %s, Clave Primaria: %s %n", pk_tablename, pk_name);
			  System.out.printf("Tabla FK: %s, Clave Ajena: %s %n", fk_tablename, fk_name);
			 }

			 //ImportedKeys
			 ResultSet ik = dbmd.getImportedKeys( "ejemplo", null, "departamentos");
			 while (ik.next()) {
			  String fk_name = ik.getString("FKCOLUMN_NAME");
			  String pk_name = ik.getString("PKCOLUMN_NAME");
			  String pk_tablename = ik.getString("PKTABLE_NAME");
			  String fk_tablename = ik.getString("FKTABLE_NAME");
			  System.out.printf("Tabla PK: %s, Clave Primaria: %s %n", pk_tablename, pk_name);
			  System.out.printf("Tabla FK: %s, Clave Ajena: %s %n", fk_tablename, fk_name);
			 }

			 //Procedures
			 ResultSet proc = dbmd.getProcedures( "ejemplo", null, null);
			 while (proc.next()) {
			  String proc_name = proc.getString("PROCEDURE_NAME");
			  String proc_type = proc.getString("PROCEDURE_TYPE");
			  System.out.printf("Nombre Procedimiento: %s - Tipo: %s %n",proc_name, proc_type);
			 }


			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar ResultSet y conexión
			try {
				if (resul != null)
					resul.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void oracleTablas() {

		Connection conexion = null;
		ResultSet resul = null;

		try {

			// Establecer conexión
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "C##VICTOR", "Ora1234");

			DatabaseMetaData dbmd = conexion.getMetaData();

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS ORACLE:");
			System.out.println("===================================");
			System.out.printf("Nombre : %s %n", nombre);
			System.out.printf("Driver : %s %n", driver);
			System.out.printf("URL : %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);

			// Obtener información de las tablas y vistas que hay
			resul = dbmd.getTables(null, "C##VICTOR", null, null); // Cambiado para obtener todas las tablas

			while (resul.next()) {
				String catalogo = resul.getString(1); // columna 1
				String esquema = resul.getString(2); // columna 2
				String tabla = resul.getString(3); // columna 3
				String tipo = resul.getString(4); // columna 4
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			
			System.out.println("-----------------------------------------------------------------");
			System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
			System.out.println("===================================");
			ResultSet columnas=null;
			columnas = dbmd.getColumns(null, "C##VICTOR", "DEPARTAMENTOS", null);
			while (columnas.next()) {
			 String nombCol = columnas.getString("COLUMN_NAME"); //getString(4)
			 String tipoCol = columnas.getString("TYPE_NAME"); //getString(6)
			 String tamCol = columnas.getString("COLUMN_SIZE"); //getString(7)
			 String nula = columnas.getString("IS_NULLABLE"); //getString(18)
			 System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol, nula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar ResultSet y conexión
			try {
				if (resul != null)
					resul.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void sqliteTablas() {

		Connection conexion = null;
		ResultSet resul = null;

		try {

			// Establecer conexión
			conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso_a_datos\\BBDDEjercicios\\Basesdatos\\sqlite\\ejemplo.db");

			DatabaseMetaData dbmd = conexion.getMetaData();

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS SQLITE:");
			System.out.println("===================================");
			System.out.printf("Nombre : %s %n", nombre);
			System.out.printf("Driver : %s %n", driver);
			System.out.printf("URL : %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);

			// Obtener información de las tablas y vistas que hay
			resul = dbmd.getTables(null, null, null, null); // Cambiado para obtener todas las tablas

			while (resul.next()) {
				String catalogo = resul.getString(1); // columna 1
				String esquema = resul.getString(2); // columna 2
				String tabla = resul.getString(3); // columna 3
				String tipo = resul.getString(4); // columna 4
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			
			System.out.println("-----------------------------------------------------------------");
			System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
			System.out.println("===================================");
			ResultSet columnas=null;
			columnas = dbmd.getColumns(null, null, "departamentos", null);
			while (columnas.next()) {
			 String nombCol = columnas.getString("COLUMN_NAME"); //getString(4)
			 String tipoCol = columnas.getString("TYPE_NAME"); //getString(6)
			 String tamCol = columnas.getString("COLUMN_SIZE"); //getString(7)
			 String nula = columnas.getString("IS_NULLABLE"); //getString(18)
			 System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol, nula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar ResultSet y conexión
			try {
				if (resul != null)
					resul.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void derbyTablas() {

		Connection conexion = null;
		ResultSet resul = null;

		try {

			// Establecer conexión
			conexion = DriverManager.getConnection("jdbc:derby:C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso_a_datos\\BBDDEjercicios\\Basesdatos\\derby\\ejemplo");

			DatabaseMetaData dbmd = conexion.getMetaData();

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS DERBY:");
			System.out.println("===================================");
			System.out.printf("Nombre : %s %n", nombre);
			System.out.printf("Driver : %s %n", driver);
			System.out.printf("URL : %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);

			// Obtener información de las tablas y vistas que hay
			resul = dbmd.getTables(null, "APP", null, null); // Cambiado para obtener todas las tablas

			while (resul.next()) {
				String catalogo = resul.getString(1); // columna 1
				String esquema = resul.getString(2); // columna 2
				String tabla = resul.getString(3); // columna 3
				String tipo = resul.getString(4); // columna 4
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			
			
			System.out.println("-----------------------------------------------------------------");
			System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
			System.out.println("===================================");
			ResultSet columnas=null;
			columnas = dbmd.getColumns(null, "APP", "DEPARTAMENTOS", null);
			while (columnas.next()) {
			 String nombCol = columnas.getString("COLUMN_NAME"); //getString(4)
			 String tipoCol = columnas.getString("TYPE_NAME"); //getString(6)
			 String tamCol = columnas.getString("COLUMN_SIZE"); //getString(7)
			 String nula = columnas.getString("IS_NULLABLE"); //getString(18)
			 System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol, nula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar ResultSet y conexión
			try {
				if (resul != null)
					resul.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void hsqldbTablas() {

		Connection conexion = null;
		ResultSet resul = null;

		try {

			// Establecer conexión
			conexion = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso_a_datos\\BBDDEjercicios\\Basesdatos\\hsqldb\\ejemplo\\ejemplo");

			DatabaseMetaData dbmd = conexion.getMetaData();

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS HSQLDB:");
			System.out.println("===================================");
			System.out.printf("Nombre : %s %n", nombre);
			System.out.printf("Driver : %s %n", driver);
			System.out.printf("URL : %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);

			// Obtener información de las tablas y vistas que hay
			resul = dbmd.getTables("PUBLIC", "PUBLIC", null, null); // Cambiado para obtener todas las tablas

			while (resul.next()) {
				String catalogo = resul.getString(1); // columna 1
				String esquema = resul.getString(2); // columna 2
				String tabla = resul.getString(3); // columna 3
				String tipo = resul.getString(4); // columna 4
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			
			System.out.println("-----------------------------------------------------------------");
			System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
			System.out.println("===================================");
			ResultSet columnas=null;
			columnas = dbmd.getColumns("PUBLIC", "PUBLIC", "DEPARTAMENTOS", null);
			while (columnas.next()) {
			 String nombCol = columnas.getString("COLUMN_NAME"); //getString(4)
			 String tipoCol = columnas.getString("TYPE_NAME"); //getString(6)
			 String tamCol = columnas.getString("COLUMN_SIZE"); //getString(7)
			 String nula = columnas.getString("IS_NULLABLE"); //getString(18)
			 System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol, nula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar ResultSet y conexión
			try {
				if (resul != null)
					resul.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void ascessTablas() {

		Connection conexion = null;
		ResultSet resul = null;

		try {

			// Establecer conexión
			conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso_a_datos\\BBDDEjercicios\\Basesdatos\\ejemplo.accdb");

			DatabaseMetaData dbmd = conexion.getMetaData();

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS ASCESS:");
			System.out.println("===================================");
			System.out.printf("Nombre : %s %n", nombre);
			System.out.printf("Driver : %s %n", driver);
			System.out.printf("URL : %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);

			// Obtener información de las tablas y vistas que hay
			resul = dbmd.getTables(null, "ejemplo", null, null); // Cambiado para obtener todas las tablas

			while (resul.next()) {
				String catalogo = resul.getString(1); // columna 1
				String esquema = resul.getString(2); // columna 2
				String tabla = resul.getString(3); // columna 3
				String tipo = resul.getString(4); // columna 4
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			
			System.out.println("-----------------------------------------------------------------");
			System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
			System.out.println("===================================");
			ResultSet columnas=null;
			columnas = dbmd.getColumns(null, "ejemplo", "departamentos", null);
			while (columnas.next()) {
			 String nombCol = columnas.getString("COLUMN_NAME"); //getString(4)
			 String tipoCol = columnas.getString("TYPE_NAME"); //getString(6)
			 String tamCol = columnas.getString("COLUMN_SIZE"); //getString(7)
			 String nula = columnas.getString("IS_NULLABLE"); //getString(18)
			 System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol, nula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar ResultSet y conexión
			try {
				if (resul != null)
					resul.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void h2Tablas() {
		
		Connection conexion = null;
		ResultSet resul = null;

		try {

			// Establecer conexión
			conexion = DriverManager.getConnection("jdbc:h2:file:C:\\Users\\Alumno\\Desktop\\2-DAM\\Acceso_a_datos\\BBDDEjercicios\\Basesdatos\\h2\\ejemplo", "sa","");

			DatabaseMetaData dbmd = conexion.getMetaData();

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS H2:");
			System.out.println("===================================");
			System.out.printf("Nombre : %s %n", nombre);
			System.out.printf("Driver : %s %n", driver);
			System.out.printf("URL : %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);

			// Obtener información de las tablas y vistas que hay
			resul = dbmd.getTables(null, "ejemplo", null, null); // Cambiado para obtener todas las tablas

			while (resul.next()) {
				String catalogo = resul.getString(1); // columna 1
				String esquema = resul.getString(2); // columna 2
				String tabla = resul.getString(3); // columna 3
				String tipo = resul.getString(4); // columna 4
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			
			System.out.println("-----------------------------------------------------------------");
			System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
			System.out.println("===================================");
			ResultSet columnas=null;
			columnas = dbmd.getColumns(null, "ejemplo", "departamentos", null);
			while (columnas.next()) {
			 String nombCol = columnas.getString("COLUMN_NAME"); //getString(4)
			 String tipoCol = columnas.getString("TYPE_NAME"); //getString(6)
			 String tamCol = columnas.getString("COLUMN_SIZE"); //getString(7)
			 String nula = columnas.getString("IS_NULLABLE"); //getString(18)
			 System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol, nula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar ResultSet y conexión
			try {
				if (resul != null)
					resul.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
