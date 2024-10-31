
texto = input("Introduce un texto: ").strip()


letra1 = input("Introduce la primera letra: ").strip().lower()
letra2 = input("Introduce la segunda letra: ").strip().lower()
letra3 = input("Introduce la tercera letra: ").strip().lower()


texto_minusculas = texto.lower()


resultados = {}


contador_letras = {
    letra1: texto_minusculas.count(letra1),
    letra2: texto_minusculas.count(letra2),
    letra3: texto_minusculas.count(letra3)
}


resultados['conteo_letras'] = contador_letras


palabras = texto.split()
num_palabras = len(palabras)


resultados['numero_palabras'] = num_palabras

# Obtener la primera y última letra del textox
primera_letra = texto[0] if texto else ""
ultima_letra = texto[-1] if texto else ""

# Añadir l diccionario
resultados['primera_letra'] = primera_letra
resultados['ultima_letra'] = ultima_letra

# Texto en orden inverso
texto_inverso = texto[::-1]

# Añadr al diccionario
resultados['texto_inverso'] = texto_inverso


contiene_python = 'python' in texto_minusculas


resultados['contiene_python'] = contiene_python


print("\n--- Resultados ---")
print(f"El número de veces que aparecen las letras {letra1}, {letra2}, {letra3} es: {contador_letras}")
print(f"El número de palabras en el texto es: {num_palabras}")
print(f"La primera letra del texto es: '{primera_letra}'")
print(f"La última letra del texto es: '{ultima_letra}'")
print(f"El texto en orden inverso es: {texto_inverso}")
print(f"¿Aparece 'Python' en el texto?: {'Sí' if contiene_python else 'No'}")
