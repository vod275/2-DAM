package com.example.encuesta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.encuesta.databinding.ActivityDetalleEncuestaBinding

class DetalleEncuesta : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleEncuestaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleEncuestaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener la encuesta desde el Intent
        val detalleEncuesta = intent.getStringExtra("ENCUESTA_DETALLE")
        binding.tvEncuestaDetalle.text = detalleEncuesta

        // Volver al MainActivity al pulsar el botón "Volver"
        binding.btVolver.setOnClickListener {
            finish() // Cierra el segundo activity y regresa al MainActivity
        }
    }
}
