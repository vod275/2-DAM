package adaptador

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.encuesta.R

class ResumenPersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)   {
    val tvPersona: TextView = itemView.findViewById(R.id.txPersona)
    var isBackgroundColorChanged = false // Flag to track color state

}