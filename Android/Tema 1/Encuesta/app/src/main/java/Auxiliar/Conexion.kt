package Auxiliar

import Conexion.AdminSQLIteConexion
import Modelo.Persona
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity

object Conexion {

    private  var DATABASE_NAME = "Encuesta.db3"
    private  var DATABASE_VERSION = 1



    fun addPersona(contexto: AppCompatActivity, p: Persona):Long{
        val admin = AdminSQLIteConexion(contexto, this.DATABASE_NAME, null, DATABASE_VERSION)
        val bd = admin.writableDatabase //habilito la BBDD para escribir en ella, tambié deja leer.
        val registro = ContentValues() //objeto de kotlin, contenido de valores, un Map. Si haceis ctrl+clic lo veis.
        registro.put("nombre", p.nombre)
        registro.put("sistemaOperativo",p.sistemaOperativo)
        registro.put("especializacion",p.especializacion.toString())
        registro.put("horasEstudio",p.horasEstudio)
        val codigo = bd.insert("personas", null, registro)
        bd.close()
        return codigo
    }
}