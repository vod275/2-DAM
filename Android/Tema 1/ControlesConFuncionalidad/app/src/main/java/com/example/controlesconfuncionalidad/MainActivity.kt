package com.example.controlesconfuncionalidad

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        val ptNombre = findViewById<EditText>(R.id.ptNombre)
        val btAceptar = findViewById<Button>(R.id.btAceptar)
        val btBorrar = findViewById<Button>(R.id.btBorrar)

        btAceptar.setOnClickListener{
            println(ptNombre.text.toString())
            Log.i("Victor", "Hola ${ptNombre.text}")
            Toast.makeText(this, "Hola ${ptNombre.text}", Toast.LENGTH_LONG).show()
        }
        btBorrar.setOnClickListener{
            ptNombre.text.clear()
        }
    }
}