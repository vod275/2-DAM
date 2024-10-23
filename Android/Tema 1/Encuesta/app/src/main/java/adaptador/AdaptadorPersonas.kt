package adaptador

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.encuesta.R

class AdaptadorPersonas(private val encuestas: MutableList<String>) :
    RecyclerView.Adapter<ResumenPersonaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumenPersonaViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ResumenPersonaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return encuestas.size
    }


    override fun onBindViewHolder(holder: ResumenPersonaViewHolder, position: Int) {

        val encuesta = encuestas[position]
        holder.tvPersona.text = encuesta



    }



}
