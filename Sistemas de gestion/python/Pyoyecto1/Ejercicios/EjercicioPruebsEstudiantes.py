def main():
    estudiantes = ingresar_estudiantes()
    print("\nDiccionario de estudiantes y calificaciones:")
    for nombre, nota in estudiantes.items():
        print(f"{nombre}: {nota}")


def ingresar_estudiantes():
    estudiantes = {}

    while True:
        nombre = input("Ingrese el nombre del estudiante (o 'fin' para terminar): ")

        if nombre.lower() == 'fin':
            break


        try:
            nota = float(input(f"Ingrese la calificación de {nombre}: "))
        except ValueError:
            print("Por favor, ingrese una nota válida.")
            continue

        estudiantes[nombre] = nota

    return estudiantes

# Ejecutar el programa
if __name__ == "__main__":
    main()
