mi_archivo = open('Ejemplo.txt')
print(mi_archivo.read())
mi_archivo.close()  # Se libera el espacio de memoria correspondiente

mi_archivo = open('Ejemplo.txt')

una_linea = mi_archivo.readline()
while una_linea:
    print(una_linea.rstrip())  # Eliminamos el \n del final de la línea porque print ya imprime uno
    una_linea = mi_archivo.readline()

mi_archivo.close()  # Se libera el espacio de memoria correspondiente



mi_archivo = open('Ejemplo.txt')

for lineas in mi_archivo: print(f"Aquí tenemos: {lineas}")

mi_archivo.close()  # Se libera el espacio de memoria correspondiente

mi_archivo = open('Ejemplo.txt')
todas = mi_archivo.readlines()
print(todas)  # Devuelve una lista
mi_archivo.close()  # Se libera el espacio de memoria correspondiente