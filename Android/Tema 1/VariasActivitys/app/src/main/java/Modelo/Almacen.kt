package Modelo

object Almacen {

    val listaPersonas = ArrayList<Persona>()
    fun addPersona(persona: Persona) {
        listaPersonas.add(persona)
    }

    fun getPersonas(): ArrayList<Persona> {
        return listaPersonas
    }

}