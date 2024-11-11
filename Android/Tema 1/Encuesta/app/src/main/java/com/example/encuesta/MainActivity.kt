package com.example.encuesta

import Auxiliar.Conexion
import Modelo.Persona
import adaptador.AdaptadorPersonas
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.encuesta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val encuestas = mutableListOf<String>() // Lista de encuestas en memoria

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
            val encuesta = "Nombre: $nombre, Horas: $horasEstudio, Especialidad: $especialidad, SO: $sistemaOperativo"
            encuestas.add(encuesta)

            val intent = Intent(this, DetalleEncuesta::class.java)
            intent.putStringArrayListExtra("ENCUESTAS_VALIDADAS", ArrayList(encuestas))
            startActivity(intent)
        } else {
            Toast.makeText(this, "Error al guardar la encuesta", Toast.LENGTH_SHORT).show()
        }
    }

    private fun reiniciarEncuestas() {
        encuestas.clear()
        Toast.makeText(this, "Encuestas reiniciadas", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarCantidadEncuestas() {
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
}
