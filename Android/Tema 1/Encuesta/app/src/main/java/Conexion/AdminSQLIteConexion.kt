package Conexion

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class AdminSQLIteConexion(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        Log.e("AdminSQLIteConexion", "Paso por OnCreate del AdminSQLLite")
        // Creación de la tabla personas si no existe
        db.execSQL("CREATE TABLE IF NOT EXISTS personas (" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "sistemaOperativo TEXT, " +
                "especializacion TEXT, " +
                "horasEstudio INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.e("AdminSQLIteConexion", "Paso por OnUpgrade del AdminSQLLite")
        // Si la versión de la base de datos cambia, puedes agregar la lógica aquí para hacer migraciones
        db.execSQL("DROP TABLE IF EXISTS personas")
        onCreate(db)
    }
}
