import math
import random

#Programa que calcula el area de un circulo



radio = float(input("Introduce el radio del circulo: "))

area = math.pi * (math.pow(radio, 2))

print(f"El area es: {area}")



#Programa si un numero es par o impar
numero = int(input("Introduce un numero: "))

if numero % 2 == 0:
    print("El numero es par")
else:
    print("El numero es impar")



#funcion tipo_figura
lados = int(input("Introduce el numero de lados: "))

def tipo_figura(lados):
    match lados:
         case 3: print("Es un triangulo")
         case 4: print("Es un cuadrado")
         case 6: print("Es un exagono")



tipo_figura(lados)



#programa que genere numero entre 1 y 10 y el usuario tenga que adivinarlo el programa da pistas de mayor o menor


numeroSecreto = random.randint(1, 10)

def adivina_numero():



    while True:
        numero = int(input("Introduce un numero entre 1 y 10: "))
        if numero < numeroSecreto:
            print("El número es mayor")
        elif numero > numeroSecreto:
            print("El número es menor")
        else:
            print("¡Has adivinado el número!")
            break


adivina_numero()


# funcion _palindromo recibe cadena ydevuelve true si es igual, falso si no

cadena = input("Introduce un palindromo o no: ")
def _palindromo(cadena):
    if cadena == cadena[::-1]:
        return True
    else:
        return False
