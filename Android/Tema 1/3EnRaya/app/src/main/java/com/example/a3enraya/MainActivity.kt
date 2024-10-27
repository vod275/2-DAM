package com.example.a3enraya

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import com.example.a3enraya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val board = ObservableArrayMap<Int, String>()
    val statusText = ObservableField("Turno: X")
    private var jugadorMomentaneo = "X"

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

        binding.btnReset.setOnClickListener { resetGame() }

        // Vincular el TextView de victoria
        binding.tvVictoria.text = "" // Inicializa el TextView

        // Inicializar el tablero y los botones
        for (i in 0..8) {
            board[i] = null
            val button = when (i) {
                0 -> binding.bt1
                1 -> binding.bt2
                2 -> binding.bt3
                3 -> binding.bt4
                4 -> binding.bt5
                5 -> binding.bt6
                6 -> binding.bt7
                7 -> binding.bt8
                8 -> binding.bt9
                else -> null
            }

            button?.setOnClickListener {
                onBoardButtonClick(i)
            }
        }
    }

    fun onBoardButtonClick(position: Int) {
        if (board[position] == null) {
            board[position] = jugadorMomentaneo

            // Obtiene el botón usando el binding directamente
            val button = when (position) {
                0 -> binding.bt1
                1 -> binding.bt2
                2 -> binding.bt3
                3 -> binding.bt4
                4 -> binding.bt5
                5 -> binding.bt6
                6 -> binding.bt7
                7 -> binding.bt8
                8 -> binding.bt9
                else -> null
            }

            if (button != null) {
                // Cambia el fondo del botón dependiendo del jugador
                if (jugadorMomentaneo == "X") {
                    button.setImageResource(R.drawable.x) // Cambia la imagen a X
                    jugadorMomentaneo = "O"
                    statusText.set("Turno: O")
                } else {
                    button.setImageResource(R.drawable.o) // Cambia la imagen a O
                    jugadorMomentaneo = "X"
                    statusText.set("Turno: X")
                }

                checkWin()
            } else {
                Log.e("MainActivity", "Botón no encontrado para la posición $position")
            }
        }
    }

    fun checkWin() {
        val winningPositions = listOf(
            listOf(0, 1, 2),
            listOf(3, 4, 5),
            listOf(6, 7, 8),
            listOf(0, 3, 6),
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            listOf(0, 4, 8),
            listOf(2, 4, 6)
        )

        for (positions in winningPositions) {
            val (a, b, c) = positions
            if (board[a] != null && board[a] == board[b] && board[a] == board[c]) {
                binding.tvVictoria.text = "Ganador Jugador: " + board[a] // Actualiza el mensaje de victoria
                binding.tvVictoria.visibility = View.VISIBLE // Muestra el TextView
                return
            }
        }

        // Verificar si hay empate
        if (board.values.none { it == null }) {
            statusText.set("Empate")
        }
    }

    fun resetGame() {
        Log.d("MainActivity", "Resetting game") // Log para depuración
        Toast.makeText(this, "Reiniciando el juego", Toast.LENGTH_SHORT).show()
        board.clear()
        jugadorMomentaneo = "X"
        statusText.set("Turno: X")
        binding.tvVictoria.visibility = View.GONE
        binding.tvVictoria.text = ""
        binding.bt1.setImageResource(R.drawable.fondo)
        binding.bt2.setImageResource(R.drawable.fondo)
        binding.bt3.setImageResource(R.drawable.fondo)
        binding.bt4.setImageResource(R.drawable.fondo)
        binding.bt5.setImageResource(R.drawable.fondo)
        binding.bt6.setImageResource(R.drawable.fondo)
        binding.bt7.setImageResource(R.drawable.fondo)
        binding.bt8.setImageResource(R.drawable.fondo)
        binding.bt9.setImageResource(R.drawable.fondo)
    }
}
