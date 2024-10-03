package com.example.imagenesbinding_radio_imagenes_switch_seekbar


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
import com.example.imagenesbinding_radio_imagenes_switch_seekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val IMAGE_ONE = R.drawable.ic_comida_foreground
    private val IMAGE_TWO = R.drawable.pizza3
    private var currentImage = IMAGE_ONE

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





        binding.btAceptar.setOnClickListener{
            println(binding.ptNombre.text.toString())
            Log.i("Victor", "Hola ${binding.ptNombre.text}")
            Toast.makeText(this, "Hola ${binding.ptNombre.text}", Toast.LENGTH_LONG).show()
        }

        binding.btBorrar.setOnClickListener{
            binding.ptNombre.text.clear()
        }




        // Asigna la acción al pulsar el ImageButton
        binding.ibPlay.setOnClickListener {
            // Cambia la imagen de la ImageView

            if(IMAGE_ONE == currentImage)
            {
                binding.ivFotoPizza.setImageResource(IMAGE_TWO)
                currentImage = IMAGE_TWO
            }
            else
            {
                binding.ivFotoPizza.setImageResource(IMAGE_ONE)
                currentImage = IMAGE_ONE
            }
        }

        binding.ivFotoPizza.setOnClickListener{


            if(IMAGE_ONE == currentImage)
            {
                binding.ivFotoPizza.setImageResource(IMAGE_TWO)
                currentImage = IMAGE_TWO
            }
            else
            {
                binding.ivFotoPizza.setImageResource(IMAGE_ONE)
                currentImage = IMAGE_ONE
            }

        }

    }
}