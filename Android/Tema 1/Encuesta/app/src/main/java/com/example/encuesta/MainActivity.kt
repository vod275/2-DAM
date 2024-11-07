package com.example.encuesta
import Auxiliar.Conexion
import Modelo.Persona
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

        // Obtener los datos del formulario
        val nombre = if (binding.swAnonimo.isChecked) "Anónimo" else binding.etTuNombre.text.toString()
        val horasEstudio = binding.sbHorasDeEstudio.progress
        val especialidad = getEspecialidadSeleccionada()
        val sistemaOperativo = getSistemaOperativoSeleccionado()

        // Verificar que todos los campos estén completos
        if (especialidad == null || sistemaOperativo == null) {
            Toast.makeText(this, "Faltan datos por completar", Toast.LENGTH_SHORT).show()
            return
        }

        // Crear el objeto Persona
        val persona = Persona(nombre, sistemaOperativo, arrayListOf(especialidad), horasEstudio)

        // Guardar la persona en la base de datos
        val codigo = Conexion.addPersona(this, persona)

        if (codigo != -1L) {
            Toast.makeText(this, "Encuesta guardada en la base de datos", Toast.LENGTH_SHORT).show()

            // Crear un resumen de la encuesta para mostrar en el siguiente Activity
            val encuesta = "Nombre: $nombre, Horas: $horasEstudio, Especialidad: $especialidad, SO: $sistemaOperativo"
            encuestas.add(encuesta)

            // Abrir el segundo Activity para mostrar la encuesta
            val intent = Intent(this, DetalleEncuesta::class.java)
            intent.putExtra("ENCUESTA_DETALLE", encuesta)
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


    private fun mostrarResumenEncuestas() {
        adaptador.notifyDataSetChanged()
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