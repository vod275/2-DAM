package Auxiliar

import Conexion.AdminSQLIteConexion
import Modelo.Persona
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context

object Conexion {

    private const val DATABASE_NAME = "Encuesta.db3"
    private const val DATABASE_VERSION = 1

    // Método para añadir una persona a la base de datos
    fun addPersona(context: Context, p: Persona): Long {
        // Abrir la base de datos en modo escritura
        val admin = AdminSQLIteConexion(context, DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.writableDatabase

        // Crear un objeto ContentValues para insertar los datos
        val registro = ContentValues()
        registro.put("nombre", p.nombre)
        registro.put("sistemaOperativo", p.sistemaOperativo)
        registro.put("especializacion", p.especializacion.joinToString(", "))  // Unir la lista de especialización
        registro.put("horasEstudio", p.horasEstudio)

        // Insertar los datos en la tabla "personas" y devolver el ID insertado
        val codigo = bd.insert("personas", null, registro)

        // Cerrar la base de datos
        bd.close()

        return codigo
    }

    // Método para obtener todas las personas desde la base de datos
    @SuppressLint("Range")
    fun obtenerPersonas(context: Context): List<Persona> {
        val admin = AdminSQLIteConexion(context, DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.readableDatabase

        val cursor = bd.rawQuery("SELECT * FROM personas", null)
        val personas = mutableListOf<Persona>()

        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndex("nombre"))
                val sistemaOperativo = cursor.getString(cursor.getColumnIndex("sistemaOperativo"))
                val especializacion = cursor.getString(cursor.getColumnIndex("especializacion")).split(", ")
                val horasEstudio = cursor.getInt(cursor.getColumnIndex("horasEstudio"))

                personas.add(Persona(nombre, sistemaOperativo, ArrayList(especializacion), horasEstudio))
            } while (cursor.moveToNext())
        }

        cursor.close()
        bd.close()

        return personas
    }

    fun eliminarEncuesta(context: Context, encuestaId: Int): Int {
        val admin = AdminSQLIteConexion(context, DATABASE_NAME, null, DATABASE_VERSION)
        val db = admin.writableDatabase
        val rowsDeleted = db.delete("personas", "Id=?", arrayOf(encuestaId.toString()))
        db.close()
        return rowsDeleted
    }

}
