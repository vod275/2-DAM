import os

ruta = os.getcwd()  # Obtiene el pwd
print(ruta)
os.chdir('../recursos')
ruta = os.getcwd()
archivo = open('Ejemplo.txt', 'r')
print(archivo.read())
archivo.close()

#crea otro directorio
#//os.makedirs('otro_directorio')
os.chdir('otro_directorio')
ruta = os.getcwd()+'/prueba_nueva.txt'
#archivo = open(ruta, 'w')# crea el txt en este caso
print(ruta)


elemento = os.path.basename(ruta)
print(elemento)  # Nombre de base del fichero
elemento = os.path.dirname(ruta)
print(elemento)  # Primera parte de nuestra ruta
elementos = os.path.split(ruta)
print(elementos)

os.rmdir(elementos[0])