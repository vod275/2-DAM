from pathlib import Path, PureWindowsPath


carpeta = Path('../Recursos')
# Cualquier sistema que abra esto lo podrá leer
archivo = carpeta / 'Ejemplo.txt'



#leer lo que haya en el archivo
mi_archivo = open(archivo)
print(mi_archivo.read())
mi_archivo.close()



ruta = Path('Ejemplo.txt')
print(ruta.read_text())  # No hemos tenido que abrir ni cerrar nuestro fichero
print(ruta.name)  # Nombre del fichero
print(ruta.suffix)
print(ruta.stem)

ruta_windows = PureWindowsPath(ruta)
print(ruta_windows)

if not ruta.exists():
    print('Este archivo no existe')
else:
    print('Genial! Existe')