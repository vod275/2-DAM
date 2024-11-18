import json
import os

from PracticaExamen.Pasos import Pasos
from PracticaExamen.Ingrediente import Ingrediente
from PracticaExamen.Receta import Receta


def añadirIngrediente():
    nombre_ingrediente = input("Nombre del ingrediente: ")
    cantidad = input("Cantidad: ")
    descripcion = input("Descripción: ")
    return Ingrediente(nombre_ingrediente, cantidad, descripcion)


def añadirPasos():
    while True:
        try:
            numero = int(input("Número del paso: "))
            break
        except ValueError:
            print("Por favor, introduce un número válido.")
    while True:
        try:
            duracion = int(input("Duración (en minutos): "))
            break
        except ValueError:
            print("Por favor, introduce una duración válida.")
    descripcion = input("Descripción del paso: ")
    return Pasos(numero, descripcion, duracion)


def anadir_receta(recetas, filename):
    nombre = input("Ingrese el nombre de la receta: ")
    ingredientes = []
    pasos = []

    print("Añadiendo ingredientes (deja en blanco para terminar):")
    while True:
        nombre_ingrediente = input("Nombre del ingrediente (deja en blanco para terminar): ")
        if not nombre_ingrediente.strip():
            break
        ingredientes.append(añadirIngrediente())

    print("Añadiendo pasos (deja la descripción en blanco para terminar):")
    while True:
        descripcion_paso = input(f"Descripción del paso: ")
        if not descripcion_paso.strip():
            break
        pasos.append(añadirPasos())

    recetaNueva = Receta(nombre, ingredientes, pasos)
    recetas.append(recetaNueva)

    with open(filename, 'w') as f:
        json.dump([receta.to_dict() for receta in recetas], f, indent=4)
    print(f"Receta '{nombre}' añadida exitosamente.")


def exportar_recetas(recetas):
    filename = input("Ingrese el nombre del archivo para exportar (por defecto: recetas_exportadas.json): ")
    filename = filename.strip() or "recetas_exportadas.json"

    if not recetas:
        print("No hay recetas para exportar.")
        return

    try:
        with open(filename, 'w') as f:
            json.dump([receta.to_dict() for receta in recetas], f, indent=4)
        print(f"Recetas exportadas exitosamente a {filename}.")
    except Exception as e:
        print(f"Error al exportar las recetas: {e}")


def cargar_recetas(filename, recetas):
    if os.path.exists(filename):
        try:
            with open(filename, 'r') as f:
                data = json.load(f)

                if not isinstance(data, list):
                    print("El archivo JSON no contiene una lista de recetas.")
                    return

                for item in data:
                    try:
                        nombre = item['nombre']
                        ingredientes = [
                            Ingrediente(ing['nombre'], ing['cantidad'], ing['descripcion'])
                            for ing in item.get('ingredientes', [])
                        ]
                        pasos = [
                            Pasos(p['numero'], p['descripcion'], p['duracion'])
                            for p in item.get('pasos', [])
                        ]
                        recetas.append(Receta(nombre, ingredientes, pasos))
                    except KeyError as e:
                        print(f"Faltan datos en la receta: {e}")
                    except Exception as e:
                        print(f"Error al procesar una receta: {e}")

                print("Recetas cargadas exitosamente.")
        except json.JSONDecodeError:
            print("El archivo de recetas está vacío o contiene datos inválidos.")
    else:
        print(f"El archivo {filename} no existe.")





def menu():
    recetas = []
    filename = "recetas.json"

    while True:
        print("\nMenú:")
        print("1. Cargar recetas JSON")
        print("2. Añadir receta")
        print("3. Exportar recetas a JSON")
        print("4. Salir")

        opcion = input("Seleccione una opción: ")

        if opcion == '1':
            cargar_recetas(filename, recetas)

        elif opcion == '2':
            anadir_receta(recetas, filename)

        elif opcion == '3':

            exportar_recetas(recetas)

        elif opcion == '4':
            print("Saliendo del programa.")
            break

        else:
            print("Opción no válida. Intente de nuevo.")


if __name__ == '__main__':
    menu()
