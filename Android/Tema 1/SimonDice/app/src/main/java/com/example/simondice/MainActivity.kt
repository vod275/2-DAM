package com.example.simondice

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simondice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val sequence = mutableListOf<Int>()
    private val userSequence = mutableListOf<Int>()
    private var level = 1
    private var isUserTurn = false

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

        setupGame()
        setupButtons()
    }

    private fun setupGame() {
        binding.btNuevaPartida.setOnClickListener {
            level = 1
            startNewGame()
        }

        binding.btSiguiente.setOnClickListener {
            if (!isUserTurn) {
                generateSequence(level)
                showSequence()
            }
        }
    }

    private fun setupButtons() {
        binding.btRojo.setOnClickListener { onColorButtonClicked(0) }
        binding.btAzul.setOnClickListener { onColorButtonClicked(1) }
        binding.btVerde.setOnClickListener { onColorButtonClicked(2) }
        binding.btAmarillo.setOnClickListener { onColorButtonClicked(3) }
    }

    private fun onColorButtonClicked(color: Int) {
        if (isUserTurn) {
            userSequence.add(color)
            if (userSequence.size == sequence.size) {
                checkUserSequence()
            }
        }
    }

    private fun startNewGame() {
        sequence.clear()
        userSequence.clear()
        isUserTurn = false
        Toast.makeText(this, "Nueva Partida Iniciada", Toast.LENGTH_SHORT).show()
    }

    private fun generateSequence(level: Int) {
        val colorsToShow = level + 2 //botones en cada nivel
        for (i in 1..colorsToShow) {
            sequence.add(Random.nextInt(4)) //para la aleatoriedad de lo borones
        }
    }

    private fun showSequence() {
        isUserTurn = false
        userSequence.clear()

        val handler = Handler()
        var delay = 0L

        sequence.forEach { color ->
            handler.postDelayed({
                flashButton(color)
            }, delay)
            delay += 1000 
        }

        handler.postDelayed({
            isUserTurn = true
        }, delay)
    }

    private fun flashButton(color: Int) {
        val button = when (color) {
            0 -> binding.btRojo
            1 -> binding.btAzul
            2 -> binding.btVerde
            else -> binding.btAmarillo
        }

        val originalColor = button.solidColor
        button.setBackgroundColor(Color.WHITE)
        Handler().postDelayed({
            button.setBackgroundColor(originalColor)
        }, 500)
    }

    private fun checkUserSequence() {
        isUserTurn = false
        if (userSequence == sequence) {
            Toast.makeText(this, "¡Correcto! Nivel $level superado", Toast.LENGTH_SHORT).show()
            level++
            startNewGame()
            generateSequence(level)
            showSequence()
        } else {
            Toast.makeText(this, "Error en la secuencia. Inténtalo de nuevo.", Toast.LENGTH_SHORT).show()
            startNewGame()
        }
    }
}
