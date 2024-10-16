package adaptador

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_views.R

class CantanteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)   {
    val tvCantante: TextView = itemView.findViewById(R.id.txCantante)

}