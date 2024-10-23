package adaptador

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.planeta_rv.R
import modelo.Planet

import kotlin.text.lowercase

class PlanetAdapter(private val planets: MutableList<Planet>) : RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {
    private val selectedItems = mutableSetOf<Int>()
    inner class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.planetName)
        val sizeTextView: TextView = itemView.findViewById(R.id.planetSize)
        val distanceTextView: TextView = itemView.findViewById(R.id.planetDistance)
        val planetaImageView: ImageView = itemView.findViewById(R.id.ivPlaneta)

    }


    //Este método se llama cuando se necesita crear un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_planeta2, parent, false)
        return PlanetViewHolder(itemView)
    }
    //Este método se llama para actualizar el contenido de un ViewHolder existente
    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {


        val planet = planets[position]
        holder.nameTextView.text = planet.name
        holder.sizeTextView.text = "Size: ${planet.sizeKm} km"
        holder.distanceTextView.text = "Distance: ${planet.distanceAU} AU"

        //accedo al imageView
        val imageResourceId = holder.itemView.context.resources.getIdentifier( // Use holder.itemView.context
            planet.imageName,"drawable",holder.itemView.context.packageName)

        holder.planetaImageView.setImageResource(imageResourceId)

        //definimos el evento click para cada elemento de la lista
        holder.itemView.setOnClickListener {
            if (selectedItems.contains(position)) {
                selectedItems.remove(position)
            } else {
                selectedItems.add(position)
            }
            Toast.makeText(holder.itemView.context, "Clicked: ${planet.name}", Toast.LENGTH_SHORT).show()
            Log.d("ACSCO", "Clicked: ${selectedItems.joinToString(", ")}")
            notifyItemChanged(position)
        }

        //evento long click
        holder.itemView.setOnLongClickListener {
            val removedPosition = holder.adapterPosition
            Toast.makeText(holder.itemView.context, "Clicked: ${planet.name}", Toast.LENGTH_SHORT).show()

            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Borrar Planeta")
                .setMessage("¿Estás seguro de quieres  eliminar el planeta?")
                .setPositiveButton("Borrar") { dialog, _ ->
                    val removedItem = planets.removeAt(removedPosition)
                    notifyItemRemoved(removedPosition)
                    notifyItemRangeChanged(removedPosition, planets.size - removedPosition)
                    dialog.dismiss()
                }
                .setNegativeButton("Cancelar") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()

            true
        }

        //Cambiamo el color al seleccionar
        if (selectedItems.contains(position)) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.item_seleccionado))
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.item_no_seleccionado))
        }
    }

    override fun getItemCount(): Int {
        return planets.size
    }
    fun getSelectedItems(): List<Int> {
        return selectedItems.toList()
    }
}