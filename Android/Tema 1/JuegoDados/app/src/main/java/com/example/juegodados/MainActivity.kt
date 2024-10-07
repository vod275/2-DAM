package com.example.juegodados

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.juegodados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    // Variables para contar tiradas, puntos y victorias
    private var tiradasJugador1 = 0
    private var tiradasJugador2 = 0
    private var puntosJugador1 = 0
    private var puntosJugador2 = 0
    private var victoriasJugador1 = 0
    private var victoriasJugador2 = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        binding.imageView.setImageResource(R.drawable.dados_interrogacion)
        binding.imageView3.setImageResource(R.drawable.dados_interrogacion)

        // Botón del Jugador 1
        binding.btJugador.setOnClickListener {
            if (tiradasJugador1 < 5) {
                val dado = lanzarDado()
                binding.imageView.setImageResource(getImagenDado(dado))
                puntosJugador1 += dado
                tiradasJugador1++
                actualizarMarcadores()
            } else {
                Toast.makeText(this, "Jugador 1 ya hizo 5 tiradas", Toast.LENGTH_SHORT).show()
            }
            verificarGanador()
        }

        // Botón del Jugador 2
        binding.btJugador2.setOnClickListener {
            if (tiradasJugador2 < 5) {
                val dado = lanzarDado()
                binding.imageView3.setImageResource(getImagenDado(dado))
                puntosJugador2 += dado
                tiradasJugador2++
                actualizarMarcadores()
            } else {
                Toast.makeText(this, "Jugador 2 ya hizo 5 tiradas", Toast.LENGTH_SHORT).show()
            }
            verificarGanador()
        }

        // Botón para reiniciar partida
        binding.btReiniciarPartida.setOnClickListener {
            reiniciarPartida()
        }
    }

    // Función para lanzar el dado (retorna un número entre 1 y 6)
    private fun lanzarDado(): Int {
        return (1..6).random()
    }

    // Obtener la imagen del dado correspondiente al número
    private fun getImagenDado(numero: Int): Int {
        return when (numero) {
            1 -> R.drawable.dado1
            2 -> R.drawable.dado2
            3 -> R.drawable.dado3
            4 -> R.drawable.dado4
            5 -> R.drawable.dado5
            6 -> R.drawable.dado6
            else -> R.drawable.dados_interrogacion
        }
    }

    // Actualizar los TextView con las tiradas y puntos actuales
    private fun actualizarMarcadores() {
        binding.tvTiradasResultado1.text = tiradasJugador1.toString()
        binding.tvTiradasResultado2.text = tiradasJugador2.toString()
        binding.tvPuntosResultado1.text = puntosJugador1.toString()
        binding.tvPuntosResultado2.text = puntosJugador2.toString()
    }

    // Verificar si ambos jugadores han terminado sus tiradas y decipir el ganador
    private fun verificarGanador() {
        if (tiradasJugador1 == 5 && tiradasJugador2 == 5) {
            val ganador = when {
                puntosJugador1 > puntosJugador2 -> "Jugador 1"
                puntosJugador2 > puntosJugador1 -> "Jugador 2"
                else -> "Empate"
            }

            if (ganador == "Jugador 1") {
                victoriasJugador1++
            } else if (ganador == "Jugador 2") {
                victoriasJugador2++
            }


            binding.tvGanadasResultado1.text = victoriasJugador1.toString()
            binding.tvGanadasResultado2.text = victoriasJugador2.toString()


            binding.tvTitulo.text = "¡El ganador es $ganador!"


            binding.btJugador.isEnabled = false
            binding.btJugador2.isEnabled = false
        }
    }

    // Función para reiniciar la partida actual pero mantener las victorias
    private fun reiniciarPartida() {
        tiradasJugador1 = 0
        tiradasJugador2 = 0
        puntosJugador1 = 0
        puntosJugador2 = 0
        binding.tvTitulo.text = getString(R.string.juego_de_los_dados)
        binding.imageView.setImageResource(R.drawable.dados_interrogacion)
        binding.imageView3.setImageResource(R.drawable.dados_interrogacion)


        binding.btJugador.isEnabled = true
        binding.btJugador2.isEnabled = true

        actualizarMarcadores()
    }
}