package adaptador

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.encuesta.R
import Auxiliar.Conexion  // Asegúrate de importar tu clase Conexion
import android.widget.Toast

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
            // Extraer el ID de la encuesta (suponiendo que el formato es "Encuesta #id")
            val encuestaId = obtenerIdDeEncuesta(encuesta)

            // Crear y mostrar el diálogo de confirmación
            AlertDialog.Builder(context).apply {
                setTitle("Confirmación")
                setMessage("¿Seguro que desea eliminar esta encuesta?")
                setPositiveButton("Sí") { _, _ ->
                    // Intentar eliminar de la base de datos
                    try {
                        val exito = Conexion.eliminarEncuesta(context, encuestaId)

                        if (exito > 0) {
                            // Si la eliminación fue exitosa, eliminar de la lista
                            encuestas.removeAt(position)
                            notifyItemRemoved(position)
                            notifyItemRangeChanged(position, encuestas.size)

                            // Mostrar un mensaje de éxito
                            Toast.makeText(context, "Encuesta eliminada", Toast.LENGTH_SHORT).show()
                        } else {
                            // Mostrar mensaje de error si no se pudo eliminar de la base de datos
                            Toast.makeText(context, "Error al eliminar de la base de datos", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        // Handle database or other exceptions
                        Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
                setNegativeButton("Cancelar", null)
            }.show()
            true // Indica que el evento ha sido manejado
        }
    }

    // Método para obtener el ID de la encuesta
    private fun obtenerIdDeEncuesta(encuesta: String): Int {
        // Aquí suponemos que el ID está incluido en el texto de la encuesta
        // Ejemplo: "Encuesta #123", entonces extraemos el número
        return encuesta.substringAfter("#").toIntOrNull() ?: -1  // Devuelve -1 si no puede extraer el ID
    }
}
