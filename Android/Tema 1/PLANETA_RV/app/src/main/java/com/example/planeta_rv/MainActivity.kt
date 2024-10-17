package com.example.planeta_rv

import adaptador.PlanetAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.planeta_rv.databinding.ActivityMainBinding
import modelo.PlanetData

class MainActivity : AppCompatActivity() {

    val planets = PlanetData.getPlanets()

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

        val botonDetalle: Button = findViewById(R.id.btDetalle)
        var  recyclerView: RecyclerView = findViewById(R.id.rvPlanetas)
        recyclerView.layoutManager =  LinearLayoutManager(this)
        val planetAdapter= PlanetAdapter(planets)
        recyclerView.adapter = planetAdapter



        botonDetalle.setOnClickListener {

            //Toast.makeText(this, "Selected items: ${selectedItems}", Toast.LENGTH_SHORT).show()
            val selectedItems = planetAdapter.getSelectedItems()
            //val intent = Intent(this, DetallePlanetas::class.java)
            intent.putIntegerArrayListExtra("selectedItems", ArrayList(selectedItems))
            startActivity(intent)
        }
    }
}