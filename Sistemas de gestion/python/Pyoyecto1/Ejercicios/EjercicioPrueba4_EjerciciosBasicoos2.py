# funcion _palindromo recibe cadena ydevuelve true si es igual, falso si no

cadena = input("Introduce un palindromo o no: ")

def _palindromo(cadena):
    if cadena == cadena[::-1]:

        return print("Es palindromo")
    else:

        return print("No es palindromo")



_palindromo(cadena)


#Esccribir funcion _maximo_lista recibe una lista d numeros y hay que elegir el mayor


numeros = [1, 2, 3, 4, 5]


def _maximo_lista(numeros):
    maximo = max(numeros)
    return maximo


print(_maximo_lista(numeros))


#Escribe un programa que permita al usuario ingresar nombre, y calificaciones de estudiantes,
# alamecenando esa info en un diccionario, estudiante clave y calificacion valor
#el programa añadira estudiantes hata que el usuario decida detenerse



