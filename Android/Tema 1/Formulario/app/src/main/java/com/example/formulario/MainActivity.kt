package com.example.formulario

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //iniciamos los campos y los botones
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellido1 = findViewById<EditText>(R.id.etApellido1)
        val etApellido2 = findViewById<EditText>(R.id.etApellido2)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)
        val etFechaNacimiento = findViewById<EditText>(R.id.etFechaNacimiento)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etContraseña = findViewById<EditText>(R.id.etContraseña)
        val etConfirmaContraseña = findViewById<EditText>(R.id.etConfirmaContraseña)
        val etObservaciones = findViewById<EditText>(R.id.etObservaciones)
        val btnValidar = findViewById<Button>(R.id.btnValidar)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)




        // para validar los campos
        btnValidar.setOnClickListener {
            if (validarCampos(etNombre, etApellido1, etTelefono, etEmail, etContraseña, etConfirmaContraseña)) {
                // Mostrar un Toast con los datos del formulario
                val datos = "Nombre: ${etNombre.text}\nApellido1: ${etApellido1.text}\nApellido2: ${etApellido2.text}\nTeléfono: ${etTelefono.text}\nFecha de Nacimiento: ${etFechaNacimiento.text}\nEmail: ${etEmail.text}\nObservaciones: ${etObservaciones.text}"
                Toast.makeText(this, datos, Toast.LENGTH_LONG).show()
            }
        }

        // Para limpiar el boton
        btnLimpiar.setOnClickListener {
            limpiarCampos(etNombre, etApellido1, etApellido2, etTelefono, etFechaNacimiento, etEmail, etContraseña, etConfirmaContraseña, etObservaciones)
        }
    }

    private fun validarCampos(
        etNombre: EditText,
        etApellido1: EditText,
        etTelefono: EditText,
        etEmail: EditText,
        etPassword: EditText,
        etConfirmPassword: EditText
    ): Boolean {
        if (etNombre.text.isBlank()) {
            mostrarError(etNombre, "El nombre es obligatorio")
            return false
        }

        if (etApellido1.text.isBlank()) {
            mostrarError(etApellido1, "El primer apellido es obligatorio")
            return false
        }

        if (!etTelefono.text.matches(Regex("^\\d{9}\$"))) {
            mostrarError(etTelefono, "El teléfono debe contener 9 dígitos")
            return false
        }

        if (!etEmail.text.matches(Regex("^[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+\$"))) {
            mostrarError(etEmail, "Formato de correo inválido")
            return false
        }

        if (etPassword.text.toString() != etConfirmPassword.text.toString()) {
            mostrarError(etPassword, "Las contraseñas no coinciden")
            return false
        }

        return true
    }

    private fun mostrarError(campo: EditText, mensaje: String) {
        campo.error = mensaje
        campo.setBackgroundColor(Color.parseColor("#FFCDD2"))
        campo.requestFocus()

        // Restaurar el color del campo cuando reciba el foco
        campo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                campo.setBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }
    }

    private fun limpiarCampos(vararg campos: EditText) {
        for (campo in campos) {
            campo.text.clear()
            campo.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }
}