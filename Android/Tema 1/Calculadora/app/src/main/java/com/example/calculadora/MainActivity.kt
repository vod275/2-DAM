package com.example.calculadora

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sumar
        binding.btSumar.setOnClickListener {
            if (validarCampos()) {
                val num1 = binding.etPrimerNumero.text.toString().toInt()
                val num2 = binding.etSegundoNumero.text.toString().toInt()
                val resultado = num1 + num2
                binding.etResultado.setText(resultado.toString())
                ocultarResto()
            }
        }

        // Restar
        binding.btRestar.setOnClickListener {
            if (validarCampos()) {
                val num1 = binding.etPrimerNumero.text.toString().toInt()
                val num2 = binding.etSegundoNumero.text.toString().toInt()
                val resultado = num1 - num2
                binding.etResultado.setText(resultado.toString())
                ocultarResto()
            }
        }

        // Multiplicar
        binding.btMultiplicar.setOnClickListener {
            if (validarCampos()) {
                val num1 = binding.etPrimerNumero.text.toString().toInt()
                val num2 = binding.etSegundoNumero.text.toString().toInt()
                val resultado = num1 * num2
                binding.etResultado.setText(resultado.toString())
                ocultarResto()
            }
        }

        // Dividir
        binding.btDividir.setOnClickListener {
            if (validarCampos()) {
                val num1 = binding.etPrimerNumero.text.toString().toInt()
                val num2 = binding.etSegundoNumero.text.toString().toInt()

                if (num2 != 0) {
                    val resultado = num1 / num2
                    val resto = num1 % num2
                    binding.etResultado.setText(resultado.toString())

                    if (resto != 0) {
                        // Mostrar el resto solo si es diferente de 0
                        binding.etResto.setText(resto.toString())
                        binding.etResto.visibility = android.view.View.VISIBLE
                    } else {
                        ocultarResto()
                    }
                } else {
                    Toast.makeText(this, "El segundo número no puede ser 0 al dividir", Toast.LENGTH_SHORT).show()
                }
            }
        }


        binding.btLimpiar.setOnClickListener {
            binding.etPrimerNumero.setText("")
            binding.etSegundoNumero.setText("")
            binding.etResultado.setText("")
            ocultarResto()
        }

    }


    private fun validarCampos(): Boolean {
        val num1 = binding.etPrimerNumero.text.toString()
        val num2 = binding.etSegundoNumero.text.toString()

        if (TextUtils.isEmpty(num1) || TextUtils.isEmpty(num2)) {
            Toast.makeText(this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Ocultar el campo del resto
    private fun ocultarResto() {
        binding.etResto.setText("") // Limpia el contenido del campo resto
        binding.etResto.visibility = android.view.View.INVISIBLE // Lo hace invisible
    }
}
