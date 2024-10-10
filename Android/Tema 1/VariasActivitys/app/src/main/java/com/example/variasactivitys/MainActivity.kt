package com.example.variasactivitys

import Modelo.Almacen
import Modelo.Persona
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.variasactivitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val SECONDA_ACTIVITY_REQUEST_CODE = 0
    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                // Get String data from Intent
                val returnString = data!!.getStringExtra("valorEdicionV2")
                //val returnString = data!!.getSerializableExtra("objeto")
                // Set text view with string
                binding.etNombre.setText(returnString)

            }
        }





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
            val intent = Intent(this, VentanaDos::class.java)
            //intent.putExtra("nombre", binding.etNombre.text.toString())
            //intent.putExtra("edad", binding.etEdadTexto.text.toString())
            val persona = Persona(
                binding.etNombre.text.toString(),
                binding.etEdadTexto.text.toString().toInt()
            )
            //intent.putExtra("persona", persona)


            //bundle tipo
            //val bundle = Bundle()
            //bundle.putString("nombre", binding.etNombre.text.toString())
            //bundle.putString("edad", binding.etEdadTexto.text.toString())
            //bundle.putSerializable("persona", persona)
            //intent.putExtra("objeto", bundle)
            //startActivity(intent)

            Almacen.addPersona(persona)
            startActivity(intent)

        }

        binding.btReiniciar.setOnClickListener {
            var ine: Intent = intent
            finish()
            startActivity(ine)

        }

        binding.btEsperarRespuestaDeprecated.setOnClickListener {
            val intent = Intent(this, VentanaDos::class.java)
            startActivityForResult(intent, SECONDA_ACTIVITY_REQUEST_CODE)

        }

        binding.btLlamarEsperarActual.setOnClickListener {
            val intent = Intent(this, VentanaDos::class.java)

            resultLauncher.launch(intent)

        }






    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == SECONDA_ACTIVITY_REQUEST_CODE) {

            if (resultCode == Activity.RESULT_OK) {
                val returnString = data!!.getStringExtra("keyName")
                binding.etNombre.setText(returnString)
            } else {
                binding.etNombre.setText("No ha devuelto nada")
            }

        }

    }
}




