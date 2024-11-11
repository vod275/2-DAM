package com.example.encuesta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.encuesta.databinding.ActivityDetalleEncuestaBinding
import adaptador.AdaptadorPersonas

class DetalleEncuesta : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleEncuestaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleEncuestaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar la lista de encuestas validadas
        val encuestasValidadas = intent.getStringArrayListExtra("ENCUESTAS_VALIDADAS") ?: arrayListOf()

        // Inicializar el adaptador con los datos y el contexto
        val adaptador = AdaptadorPersonas(encuestasValidadas, this)
        binding.rvResumenPersonas.layoutManager = LinearLayoutManager(this)
        binding.rvResumenPersonas.adapter = adaptador

        // Configurar el botón de volver
        binding.btVolver.setOnClickListener {
            finish()
        }
    }
}
