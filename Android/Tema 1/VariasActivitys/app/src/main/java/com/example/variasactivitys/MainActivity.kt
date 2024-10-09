package com.example.variasactivitys

import Modelo.Persona
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.variasactivitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btVentana2.setOnClickListener {
            //de forma intent

            val intent: Intent = Intent(this, VentanaDos::class.java)
            //intent.putExtra("nombre", binding.etNombre.text.toString())
            //intent.putExtra("edad", binding.etEdadTexto.text.toString())
            var persona = Persona(binding.etNombre.text.toString(), binding.etEdadTexto.text.toString().toInt())
            //intent.putExtra("persona", persona)
            //startActivity(intent)


            //bundle tipo
            val bundle = Bundle()
            bundle.putString("nombre", binding.etNombre.text.toString())
            bundle.putString("edad", binding.etEdadTexto.text.toString())
            bundle.putSerializable("persona", persona)
            intent.putExtras(bundle)
            startActivity(intent)


        }
    }
}




