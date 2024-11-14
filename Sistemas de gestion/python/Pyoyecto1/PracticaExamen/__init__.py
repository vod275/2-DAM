#hacer un menu con Cargar recetas JSON, Añadir receta, Exportar recetas a JSON

import json
import os

from PracticaExamen.Pasos import Pasos
from PracticaExamen.Ingrediente import Ingrediente
from PracticaExamen.Receta import Receta


def añadirIngrediente():
    nombre_ingrediente = input("Nombre del ingrediente (deje en blanco para terminar): ")
    cantidad = input("Cantidad: ")
    descripcion = input("Descripción: ")
    ing = Ingrediente(nombre_ingrediente, cantidad, descripcion)
    return ing


def añadirPasos():
    numero = input("Numero del paso: ")
    duracion = input("Duración (en minutos): ")
    descripcion = input("Descripcion del paso: ")
    pas = Pasos(numero, descripcion, duracion)
    return pas


def anadir_receta(recetas, filename):
    nombre = input("Ingrese el nombre de la receta: ")
    ingredientes = []
    pasos = []

    # Añadir ingredientes
    while True:
        aviso = input("Para dejar de añadir ingredientes dejalo en blanco: ")
        if aviso.strip() == "":
            break
        ingredientes.append(añadirIngrediente())

    # Añadir pasos

    while True:
        descripcion_paso = input(f"Descripción del paso (deje en blanco para terminar): ")
        if descripcion_paso.strip() == "":
            break
        pasos.append(añadirPasos())

    recetaNueva = Receta(nombre, ingredientes, pasos)

    recetas.append(recetaNueva.to_dict())
    with open(filename, 'w') as f:
        json.dump(recetas, f)
    print(f"Receta '{nombre}' añadida exitosamente.")


def exportar_recetas(filename, recetas):
    try:
        with open(filename, 'w') as f:
            json.dump([receta.to_dict() for receta in recetas], f)
        print("Recetas exportadas exitosamente.")
    except Exception as e:
        print(f"Error al exportar las recetas: {e}")

def cargar_recetas(filename):
    recetas = []
    if os.path.exists(filename):
        with open(filename, 'r') as f:
            try:
                data = json.load(f)
                for item in data:
                    receta = Receta(item['nombre'], item['ingredientes'], item['pasos'])
                    recetas.append(receta)
                print("Recetas cargadas exitosamente.")
            except json.JSONDecodeError:
                print("El archivo de recetas está vacío o contiene datos inválidos.")
    else:
        print("El archivo de recetas no existe.")
    return recetas


def menu():
    recetas = []
    filename = "recetas.json"
    filename2 = "recetasCargadas.json"
    while True:
        print("\nMenu:")
        print("1. Cargar recetas JSON")
        print("2. Añadir receta")
        print("3. Exportar recetas a JSON")
        print("4. Salir")

        opcion = input("Seleccione una opción: ")

        if opcion == '1':
            recetas =  cargar_recetas(filename2)
            break
        elif opcion == '2':
            anadir_receta(recetas, filename)
        elif opcion == '3':
            exportar_recetas(filename, recetas)
        elif opcion == '4':
            break
        else:
            print("Opción no válida. Intente de nuevo.")


if __name__ == '__main__':
    menu()
