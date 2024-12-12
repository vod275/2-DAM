# crear unas clases para gestionar una cloceccion de libros clase libro y las
# funciones agregarLibros, guardarLibros
import json


class libro:
    def __init__(self, titulo, autor, anio):
        self.titulo = titulo
        self.autor = autor
        self.anio = anio


class Biblioteca:

    def __init__(self):
        self.libros = []

    def agregarLibros(self, titulo, autor, anio):
        libro = {
            'titulo': titulo,
            'autor': autor,
            'anio': anio
        }
        self.libros.append(libro)
        print(f'Libro "{titulo}" agregado a la biblioteca.')

    def guardarLibros(self, archivo='libros.json'):
        try:
            with open(archivo, 'w') as f:
                json.dump(self.libros, f, indent=4)
            print(f'Libros guardados en {archivo}.')
        except Exception as e:
            print(f'Error al guardar los libros: {e}')

    def mostrarLibros(self):
        for libro in self.libros:
            titulo = libro.get('titulo', 'Desconocido')
            autor = libro.get('autor', 'Desconocido')
            anio = libro.get('anio', 'Desconocido')
            print(f'Título: {titulo}, Autor: {autor}, Año: {anio}')


# metodos
mi_biblioteca = Biblioteca()
mi_biblioteca.agregarLibros('Cien Anos de Soledad', 'Gabriel Garcia Marquez', '1992')
mi_biblioteca.guardarLibros()
mi_biblioteca.mostrarLibros()