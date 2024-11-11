package adaptador

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.encuesta.R

class AdaptadorPersonas(
    private val encuestas: MutableList<String>,
    private val context: Context // Pasamos el contexto para poder mostrar el AlertDialog
) : RecyclerView.Adapter<ResumenPersonaViewHolder>() {

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

        // Configuración de un long click listener para mostrar el AlertDialog
        holder.itemView.setOnLongClickListener {
            // Crear y mostrar el diálogo de confirmación
            AlertDialog.Builder(context).apply {
                setTitle("Confirmación")
                setMessage("¿Seguro que desea eliminar esta encuesta?")
                setPositiveButton("Sí") { _, _ ->
                    // Eliminar el elemento y notificar al adaptador
                    encuestas.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, encuestas.size)
                }
                setNegativeButton("Cancelar", null)
            }.show()
            true // Indica que el evento ha sido manejado
        }
    }
}
