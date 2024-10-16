package adaptador

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_views.R

class AdaptadorCantantes(private val cantantes: ArrayList<String>) :
    RecyclerView.Adapter<CantanteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CantanteViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cantante, parent, false)
        return CantanteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cantantes.size
    }


    override fun onBindViewHolder(holder: CantanteViewHolder, position: Int) {
        // Inicializamos la lista de cantantes
        val cantante = cantantes[position]
        holder.tvCantante.text = cantante
        // Al hacer clic, el fondo del ítem cambia de color
        holder.itemView.setOnClickListener {
            holder.itemView.setBackgroundColor(Color.LTGRAY)
        }

        // Al dejar pulsado, se elimina el ítem de la lista
        holder.itemView.setOnLongClickListener {
            cantantes.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cantantes.size)
            true
        }
    }


}
