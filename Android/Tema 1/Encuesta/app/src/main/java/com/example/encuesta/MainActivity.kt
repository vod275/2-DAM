package com.example.encuesta

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.encuesta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val encuestas = mutableListOf<String>() // Lista de encuestas en memoria
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        // Enlazar el layout con el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar los listeners de botones con binding
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
            mostrarResumenEncuestas()
        }

    }





    private fun validarEncuesta() {
        // Validar datos de la encuesta
        val nombre = if (binding.swAnonimo.isChecked) "Anónimo" else binding.etTuNombre.text.toString()
        val horasEstudio = binding.sbHorasDeEstudio.progress
        val especialidad = getEspecialidadSeleccionada()
        val sistemaOperativo = getSistemaOperativoSeleccionado()

        if (especialidad == null || sistemaOperativo == null) {
            Toast.makeText(this, "Faltan datos por completar", Toast.LENGTH_SHORT).show()
            return
        }

        // Guardar la encuesta en la lista
        val encuesta = "Nombre: $nombre, Horas: $horasEstudio, Especialidad: $especialidad, SO: $sistemaOperativo"
        encuestas.add(encuesta)
        Toast.makeText(this, "Encuesta guardada", Toast.LENGTH_SHORT).show()

        // Aquí puedes abrir un segundo activity para mostrar la encuesta

        val intent = Intent(this, DetalleEncuesta::class.java)
        intent.putExtra("ENCUESTA_DETALLE", encuesta)
        startActivity(intent)
    }

    private fun reiniciarEncuestas() {
        encuestas.clear()
        Toast.makeText(this, "Encuestas reiniciadas", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarCantidadEncuestas() {
        Toast.makeText(this, "Total encuestas: ${encuestas.size}", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarResumenEncuestas() {
        val resumen = encuestas.joinToString("\n")
        binding.textView2.text = resumen
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
        return when {
            binding.rbWindows.isChecked -> "Windows"
            binding.rbMac.isChecked -> "Mac"
            binding.rbLinux.isChecked -> "Linux"
            else -> null
        }
    }
}