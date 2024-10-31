#definir funcion con un parametro numerico y que devuelva la suma de los numeros primos desde el 0 hasta el numero

primo = input("Introduce un numero: ")

def sumaPrimos(numero):
    suma = 0
    for i in range(numero+1):
        if i > 1:
            for j in range(2,i):
                if (i % j) == 0:
                    break
            else:
                suma += i
    return suma


print(sumaPrimos(int(primo)))



#juego del ahorcado con 6 vidas, sustituiremos cada _ con la letra acertada
# siesque coincide con algun caracter de la palabra a avivinar


