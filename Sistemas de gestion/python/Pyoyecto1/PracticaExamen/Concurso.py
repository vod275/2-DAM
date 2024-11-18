import random
from PracticaExamen import ListaRecetas
from PracticaExamen.Aspirante import Aspirante
from PracticaExamen.Juez import Juez
from PracticaExamen.Prueba import Prueba


def seleccionar_receta(recetas):

    return random.choice(recetas)


def evaluar_aspirantes(jurado, aspirantes, receta):

    for aspirante in aspirantes:
        votos = [juez.votar() for juez in jurado]
        puntuacion_final = sorted(votos)[1]
        aspirante.puntuacion += puntuacion_final
        aspirante.pruebas.append(Prueba(receta, puntuacion_final))
        print(f"{aspirante.nombre} realizó {receta.nombre} y recibió {puntuacion_final} puntos.")


def eliminar_aspirantes(aspirantes, num_descartados=5):

    aspirantes_ordenados = sorted(aspirantes, key=lambda x: x.puntuacion)
    descartados = aspirantes_ordenados[:num_descartados]
    supervivientes = aspirantes_ordenados[num_descartados:]

    for aspirante in descartados:
        aspirante.estado = "Espectador"

    return supervivientes, descartados


def elegir_favorito(espectadores, aspirantes):

    favorito = max(aspirantes, key=lambda x: x.puntuacion)
    return favorito.nombre


def sortear_robot_de_cocina(espectadores, favorito):

    espectadores_favoritos = [espectador for espectador in espectadores if espectador.favorito == favorito]

    if espectadores_favoritos:
        ganador_robot = random.choice(espectadores_favoritos)
        print(f"El ganador del robot de cocina es: {ganador_robot.nombre}")
    else:
        print("Ningún espectador votó por el favorito. No hay ganador del robot de cocina.")



def primera_prueba(aspirantes, jurado, recetas):

    print("\n--- Primera Prueba ---")
    receta_seleccionada = seleccionar_receta(recetas)
    print(f"Receta seleccionada: {receta_seleccionada.nombre}")
    evaluar_aspirantes(jurado, aspirantes, receta_seleccionada)
    supervivientes, espectadores = eliminar_aspirantes(aspirantes)
    print("\n--- Supervivientes ---")
    for aspirante in supervivientes:
        print(aspirante)
    print("\n--- Espectadores ---")
    for espectador in espectadores:
        print(espectador)
    favorito = elegir_favorito(espectadores, supervivientes)
    print(f"\nEl favorito para los espectadores es: {favorito}")
    return supervivientes, espectadores


def segunda_prueba(aspirantes, jurado, recetas):

    print("\n--- Segunda Prueba ---")
    receta_seleccionada = seleccionar_receta(recetas)
    print(f"Receta seleccionada: {receta_seleccionada.nombre}")
    evaluar_aspirantes(jurado, aspirantes, receta_seleccionada)
    supervivientes, espectadores = eliminar_aspirantes(aspirantes, num_descartados=5)
    print("\n--- Supervivientes ---")
    for aspirante in supervivientes:
        print(aspirante)
    print("\n--- Espectadores ---")
    for espectador in espectadores:
        print(espectador)
    favorito = elegir_favorito(espectadores, supervivientes)
    print(f"\nEl favorito para los espectadores es: {favorito}")
    return supervivientes, espectadores


def tercera_prueba(aspirantes, jurado, recetas):

    print("\n--- Tercera Prueba ---")
    receta_seleccionada = seleccionar_receta(recetas)
    print(f"Receta seleccionada: {receta_seleccionada.nombre}")
    evaluar_aspirantes(jurado, aspirantes, receta_seleccionada)
    supervivientes, espectadores = eliminar_aspirantes(aspirantes, num_descartados=3)
    print("\n--- Supervivientes ---")
    for aspirante in supervivientes:
        print(aspirante)
    print("\n--- Espectadores ---")
    for espectador in espectadores:
        print(espectador)
    favorito = elegir_favorito(espectadores, supervivientes)
    print(f"\nEl favorito para los espectadores es: {favorito}")
    return supervivientes, espectadores

def cuarta_prueba(aspirantes, jurado, recetas):

    print("\n--- Cuarta Prueba ---")

    # Selección de receta
    receta_seleccionada = seleccionar_receta(recetas)
    print(f"Receta seleccionada: {receta_seleccionada.nombre}")
    evaluar_aspirantes(jurado, aspirantes, receta_seleccionada)

    # Elegir al chef: el que tenga la mayor puntuación final
    chef = max(aspirantes, key=lambda x: x.puntuacion)
    print(f"\n¡El Chef seleccionado es: {chef.nombre}!")

    # Premiar al chef con un curso de cocina
    print(f"{chef.nombre} ha ganado un curso de cocina como premio del jurado.")

    # Sorteo del robot de cocina entre los espectadores que han tenido como favorito al chef
    sortear_robot_de_cocina(aspirantes, chef.nombre)

    return chef


def main():

    
    filename = "recetas.json"  # Este archivo debe contener las recetas en formato JSON
    aspirantes = [Aspirante(f"Aspirante {i + 1}") for i in range(15)]
    jurado = [Juez(f"Juez {i + 1}") for i in range(3)]
    recetas = []
    ListaRecetas.cargar_recetas(filename, recetas)  # Método para cargar recetas desde el archivo JSON

    # Primera prueba
    print("\n--- Primera Prueba ---")
    supervivientes, espectadores = primera_prueba(aspirantes, jurado, recetas)

    # Segunda prueba
    print("\n--- Segunda Prueba ---")
    supervivientes, espectadores = segunda_prueba(supervivientes, jurado, recetas)

    # Tercera prueba
    print("\n--- Tercera Prueba ---")
    supervivientes, espectadores = tercera_prueba(supervivientes, jurado, recetas)

    # Cuarta prueba
    print("\n--- Cuarta Prueba ---")
    chef = cuarta_prueba(supervivientes, jurado, recetas)

    # Resultados finales
    print("\n--- Resultados Finales ---")
    print(f"El chef finalista es: {chef.nombre}")
    print("Fin del concurso")


# Llamada a la función principal para ejecutar el concurso
if __name__ == "__main__":
    main()
