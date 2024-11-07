package Modelo



data class Persona(

    var nombre: String,
    var sistemaOperativo: String,
    var especializacion: ArrayList<String>,
    var horasEstudio: Int
) {
    override fun toString(): String {
        return "Persona(Nombre='$nombre', sistemaOperativo='$sistemaOperativo', " +
                "especializacion=$especializacion, horasEstudio=$horasEstudio)"
    }
}








