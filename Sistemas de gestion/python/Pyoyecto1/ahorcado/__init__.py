import json


def ahorcado():
    # Escoge una palabra aleatoria (puedes modificar la lista o pedirla al usuario)
    palabra = input("Introduce la palabra a adivinar: ").lower()
    letras_adivinadas = ['_'] * len(palabra)  # Lista que muestra el progreso de la adivinanza
    intentos = 6  # Número de intentos permitidos
    letras_erroneas = []  # Para guardar las letras incorrectas
    mensajes = []  # Lista para almacenar los mensajes que se mostrarán en la consola

    # Agregar mensaje inicial
    mensajes.append("¡Vamos a jugar al ahorcado!")

    while intentos > 0 and '_' in letras_adivinadas:
        # Mostrar el estado actual de la palabra y las letras incorrectas
        mensajes.append(f"Palabra: {' '.join(letras_adivinadas)}")
        mensajes.append(f"Letras incorrectas: {', '.join(letras_erroneas)}")
        mensajes.append(f"Te quedan {intentos} intentos.")

        # Mostrar la palabra con los huecos
        print(f"Palabra: {' '.join(letras_adivinadas)}")
        print(f"Letras incorrectas: {', '.join(letras_erroneas)}")
        print(f"Te quedan {intentos} intentos.")

        # Solicitar una letra
        letra = input("Introduce una letra: ").lower()

        # Verificar si la letra es válida (solo una letra)
        if len(letra) != 1 or not letra.isalpha():
            mensajes.append("Por favor, introduce una sola letra.")
            continue

        # Verificar si la letra ya fue adivinada o fallada
        if letra in letras_adivinadas or letra in letras_erroneas:
            mensajes.append("Ya has probado esta letra. Intenta con otra.")
            continue

        # Verificar si la letra está en la palabra
        if letra in palabra:
            mensajes.append(f"¡Correcto! La letra '{letra}' está en la palabra.")
            # Actualizar la lista de letras adivinadas
            for i in range(len(palabra)):
                if palabra[i] == letra:
                    letras_adivinadas[i] = letra
        else:
            mensajes.append(f"¡Incorrecto! La letra '{letra}' no está en la palabra.")
            letras_erroneas.append(letra)
            intentos -= 1  # Restar un intento

    # Final del juego
    if '_' not in letras_adivinadas:
        mensajes.append(f"¡Felicidades! Has adivinado la palabra: {''.join(letras_adivinadas)}")
    else:
        mensajes.append(f"¡Te has quedado sin intentos! La palabra era: {palabra}")

    # Guardar los mensajes en un archivo JSON
    with open('registro_ahorcado.json', 'w') as f:
        json.dump(mensajes, f, indent=4)

    # Mostrar los mensajes por consola
    for mensaje in mensajes:
        print(mensaje)


# Iniciar el juego
ahorcado()
