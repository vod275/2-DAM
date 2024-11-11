package com.example.encuesta

import Auxiliar.Conexion
import Conexion.AdminSQLIteConexion
import Modelo.Persona
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.encuesta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btValidad.setOnClickListener {
            validarEncuesta()
        }

        binding.btReiniciar.setOnClickListener {
            reiniciarEncuestas()
        }

        binding.btCuantas.setOnClickListener {
            mostrarCantidadEncuestas()
        }

        binding.btResumen.setOnClickListener {
            verResumenEncuestas()
        }
    }

    private fun validarEncuesta() {
        // Obtener los datos del formulario
        val nombre = if (binding.swAnonimo.isChecked) "Anónimo" else binding.etTuNombre.text.toString()
        val horasEstudio = binding.sbHorasDeEstudio.progress
        val especialidad = getEspecialidadSeleccionada()
        val sistemaOperativo = getSistemaOperativoSeleccionado()

        if (especialidad == null || sistemaOperativo == null) {
            Toast.makeText(this, "Faltan datos por completar", Toast.LENGTH_SHORT).show()
            return
        }

        val persona = Persona(nombre, sistemaOperativo, arrayListOf(especialidad), horasEstudio)
        val codigo = Conexion.addPersona(this, persona)

        if (codigo != -1L) {
            Toast.makeText(this, "Encuesta guardada en la base de datos", Toast.LENGTH_SHORT).show()

            // Recuperar las encuestas validadas de la base de datos
            val encuestasValidadas = Conexion.obtenerPersonas(this).map {
                "Nombre: ${it.nombre}, Horas: ${it.horasEstudio}, Especialidad: ${it.especializacion.joinToString(", ")}, SO: ${it.sistemaOperativo}"
            }

            val intent = Intent(this, DetalleEncuesta::class.java)
            intent.putStringArrayListExtra("ENCUESTAS_VALIDADAS", ArrayList(encuestasValidadas))
            startActivity(intent)
        } else {
            Toast.makeText(this, "Error al guardar la encuesta", Toast.LENGTH_SHORT).show()
        }
    }

    private fun reiniciarEncuestas() {
        // Si decides reiniciar las encuestas, deberías eliminar los registros de la base de datos también.
        val admin = AdminSQLIteConexion(this, "Encuesta.db3", null, 1)
        val db = admin.writableDatabase
        db.execSQL("DELETE FROM personas")  // Eliminar todas las encuestas
        db.close()
        Toast.makeText(this, "Encuestas reiniciadas", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarCantidadEncuestas() {
        // Mostrar la cantidad de encuestas almacenadas en la base de datos
        val encuestas = Conexion.obtenerPersonas(this)
        Toast.makeText(this, "Total encuestas: ${encuestas.size}", Toast.LENGTH_SHORT).show()
    }

    private fun getEspecialidadSeleccionada(): String? {
        return when {
            binding.cbDAM.isChecked -> "DAM"
            binding.cbDAW.isChecked -> "DAW"
            binding.cbASIR.isChecked -> "ASIR"
            else -> null
        }
    }

    private fun getSistemaOperativoSeleccionado(): String? {
        val radioGroup = binding.rgSistemaOperativo // Asegúrate de que rgSistemaOperativo es el ID del RadioGroup

        // Devuelve el texto del RadioButton seleccionado
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        return when (selectedRadioButtonId) {
            R.id.rbWindows -> "Windows"
            R.id.rbMac -> "Mac"
            R.id.rbLinux -> "Linux"
            else -> null // Si no hay ninguno seleccionado
        }
    }

    private fun verResumenEncuestas() {
        // Recuperar las encuestas almacenadas en la base de datos
        val encuestasValidadas = Conexion.obtenerPersonas(this).map {
            "Nombre: ${it.nombre}, Horas: ${it.horasEstudio}, Especialidad: ${it.especializacion.joinToString(", ")}, SO: ${it.sistemaOperativo}"
        }

        // Si hay encuestas validadas, navegar a DetalleEncuesta
        if (encuestasValidadas.isNotEmpty()) {
            val intent = Intent(this, DetalleEncuesta::class.java)
            intent.putStringArrayListExtra("ENCUESTAS_VALIDADAS", ArrayList(encuestasValidadas))
            startActivity(intent)
        } else {
            Toast.makeText(this, "No hay encuestas validadas", Toast.LENGTH_SHORT).show()
        }
    }
}
