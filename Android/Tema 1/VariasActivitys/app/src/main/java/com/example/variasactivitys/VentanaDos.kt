package com.example.variasactivitys

import Modelo.Persona
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.variasactivitys.databinding.ActivityMainBinding
import com.example.variasactivitys.databinding.ActivityVentanaDosBinding

class VentanaDos : AppCompatActivity() {

    lateinit var binding: ActivityVentanaDosBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityVentanaDosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Con intent
        //val nombre = intent.getStringExtra("nombre")
        //val edad = intent.getStringExtra("edad")
        //binding.tvDatos.text = "nombre: $nombre edad: $edad"
        //val persona = intent.getSerializableExtra("persona") as Persona
        //binding.tvDatos.text =  "Con intent el objeto es: " + persona.toString()

        //Con bundle
        val bundle = intent.getBundleExtra("objeto")
        //val nombre = bundle!!.getString("nombre")
        //val edad = bundle!!.getString("edad")
        val persona = bundle!!.getSerializable("persona")
        binding.tvDatos.text = "Con bundle el objeto es: " + persona.toString()
        //binding.tvDatos.text = "nombre: $nombre edad: $edad"


        binding.btVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}