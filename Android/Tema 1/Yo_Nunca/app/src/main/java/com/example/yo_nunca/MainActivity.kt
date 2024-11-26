package com.example.yo_nunca

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yo_nunca.databinding.ActivityMainBinding
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listaFrases: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar frases al iniciar la app
        loadFrasesFromFile()

        // Botón para agregar una frase
        binding.btnAgregar.setOnClickListener {
            val frase = binding.etFrase.text.toString().trim()
            if (frase.isNotEmpty()) {
                listaFrases.add(frase)
                saveFrasesToFile() // Guarda inmediatamente los cambios
                Toast.makeText(this, "Frase añadida", Toast.LENGTH_SHORT).show()
                binding.etFrase.text.clear()
            } else {
                Toast.makeText(this, "Por favor, escribe una frase", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón para mostrar una frase aleatoria
        binding.btnAleatorio.setOnClickListener {
            val fraseAleatoria = if (listaFrases.isNotEmpty()) listaFrases.random() else null
            if (fraseAleatoria != null) {
                binding.tvFrase.text = fraseAleatoria
            } else {
                Toast.makeText(this, "No hay frases guardadas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Guardar frases en un archivo JSON
    private fun saveFrasesToFile() {
        val jsonString = Gson().toJson(listaFrases)
        openFileOutput("frases.json", MODE_PRIVATE).use { output ->
            output.write(jsonString.toByteArray())
        }
    }

    // Cargar frases desde un archivo JSON
    private fun loadFrasesFromFile() {
        try {
            openFileInput("frases.json").use { input ->
                val jsonString = input.bufferedReader().use { it.readText() }
                listaFrases = Gson().fromJson(jsonString, object : com.google.gson.reflect.TypeToken<MutableList<String>>() {}.type)
            }
        } catch (e: Exception) {
            listaFrases = mutableListOf() // Si no existe el archivo, inicializamos una lista vacía
        }
    }
}
