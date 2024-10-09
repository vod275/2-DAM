package modelo

data class PedidoPizzeria(

    val nombre: String,
    val imagen: Int,
    val borde: String,
    val extraQueso: Boolean,
    val bacon: Boolean,
    val cebolla: Boolean,
    val licencia: Boolean,
    val satisfacion: Int
)

