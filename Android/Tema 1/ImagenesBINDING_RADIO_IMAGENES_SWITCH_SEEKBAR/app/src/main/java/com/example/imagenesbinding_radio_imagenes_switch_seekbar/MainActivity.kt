package com.example.imagenesbinding_radio_imagenes_switch_seekbar


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imagenesbinding_radio_imagenes_switch_seekbar.databinding.ActivityMainBinding
import modelo.PedidoPizzeria

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





        binding.btAceptar.setOnClickListener {
            var mensaje: String = "" // Declaramos la variable mensaje

            if (binding.sLicencia.isChecked) {
                // Construimos la base del mensaje
                mensaje = "Hola ${binding.ptNombre.text.toString()}, has pedido una pizza con "

                // Añadiendo el tipo de borde seleccionado
                val bordes = when (binding.rgBordes.checkedRadioButtonId) {
                    R.id.rbBordeFino -> "borde delgado"
                    R.id.rbBordeGrueso -> "borde grueso"
                    else -> "sin borde"
                }

                mensaje += "$bordes"

                // Añadiendo los ingredientes adicionales seleccionados
                val extras = mutableListOf<String>()
                if (binding.cbExtraQueso.isChecked) extras.add("extra de queso")
                if (binding.cbBacon.isChecked) extras.add("bacon")
                if (binding.cbCebolla.isChecked) extras.add("cebolla")

                // Si hay ingredientes adicionales, los concatenamos al mensaje
                if (extras.isNotEmpty()) {
                    mensaje += " con " + extras.joinToString(", ")
                }
            } else {
                mensaje = "Es obligatorio aceptar las licencias"
            }

            if(binding.sbSatisfaccion.progress == 0){
                mensaje = "Es obligatorio calificar la experiencia"
        }else{
            mensaje+=" con una puntuación de ${binding.sbSatisfaccion.progress}"
        }

            Log.i("Victor", mensaje)
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()


            if (binding.sLicencia.isChecked) {
                val order = PedidoPizzeria(
                    binding.ptNombre.text.toString(),
                    IMAGE_ONE,
                    binding.rgBordes.checkedRadioButtonId.toString(),
                    binding.cbExtraQueso.isChecked,
                    binding.cbBacon.isChecked,
                    binding.cbCebolla.isChecked,
                    binding.sLicencia.isChecked,
                    binding.sbSatisfaccion.progress
                )

            }
        }



        binding.btBorrar.setOnClickListener{
            binding.ptNombre.text.clear()
            binding.cbBacon.isChecked = false
            binding.cbCebolla.isChecked = false
            binding.rgBordes.clearCheck()
            binding.sLicencia.isChecked = false
            binding.cbExtraQueso.isChecked = false
            binding.sbSatisfaccion.progress = 5
            binding.ivFotoPizza.setImageResource(IMAGE_ONE)


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

        binding.sbSatisfaccion.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

                Log.i("Victor", "Progress: $progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Log.i("Victor", "Start ${binding.sbSatisfaccion.progress}")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Log.i("Victor", "Stop ${binding.sbSatisfaccion.progress}")
            }
        })

    }
}