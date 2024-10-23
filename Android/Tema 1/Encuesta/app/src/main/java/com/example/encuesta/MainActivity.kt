package com.example.encuesta

import adaptador.AdaptadorPersonas
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.encuesta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val encuestas = mutableListOf<String>() // Lista de encuestas en memoria
    private lateinit var recyclerView: RecyclerView
    private lateinit var adaptador: AdaptadorPersonas



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

        // Configurar el RecyclerView
        recyclerView = binding.rvResumenPersonas
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializa el adaptador
        adaptador = AdaptadorPersonas(encuestas)
        recyclerView.adapter = adaptador

    }





    private fun validarEncuesta() {

        val nombre = if (binding.swAnonimo.isChecked) "Anónimo" else binding.etTuNombre.text.toString()
        val horasEstudio = binding.sbHorasDeEstudio.progress
        val especialidad = getEspecialidadSeleccionada()
        val sistemaOperativo = getSistemaOperativoSeleccionado()

        if (especialidad == null || sistemaOperativo == null) {
            Toast.makeText(this, "Faltan datos por completar", Toast.LENGTH_SHORT).show()
            return
        }

        adaptador.notifyDataSetChanged()
        val encuesta = "Nombre: $nombre, Horas: $horasEstudio, Especialidad: $especialidad, SO: $sistemaOperativo"
        encuestas.add(encuesta)
        Toast.makeText(this, "Encuesta guardada", Toast.LENGTH_SHORT).show()

        // Abrir el segundo activity para mostrar la encuesta
        val intent = Intent(this, DetalleEncuesta::class.java)
        intent.putExtra("ENCUESTA_DETALLE", encuesta) // Asegúrate de que esto no sea null
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