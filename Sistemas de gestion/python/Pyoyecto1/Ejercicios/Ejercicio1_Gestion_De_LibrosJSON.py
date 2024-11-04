import json

class Libro:
    def __init__(self, titulo, autor, anio):
        self.titulo = titulo
        self.autor = autor
        self.anio = anio

    def __str__(self):
        return f'Título: {self.titulo}, Autor: {self.autor}, Año: {self.anio}'



class Biblioteca:
    def __init__(self):
        self.libros = []

    def agregarLibros(self, titulo, autor, anio):
        libro = Libro(titulo, autor, anio)
        self.libros.append(libro)
        print(f'Libro "{titulo}" agregado a la biblioteca.')


    def guardarLibros(self, archivo='libros.json'):

            with open(archivo, 'w') as f:
                json.dump([libro.__dict__ for libro in self.libros], f)
            print(f'Libros guardados en {archivo}.')



    def cargarLibros(self, archivo='libros.json'):

            with open(archivo, 'r') as f:
                libros_data = json.load(f)
                self.libros.clear()  # Limpiar la lista de libros actual
                for data in libros_data:
                    # Crear un objeto Libro con los datos cargados y agregarlo a la lista
                    libro = Libro(data['titulo'], data['autor'], data['anio'])
                    self.libros.append(libro)
            print(f'Libros cargados desde {archivo}.')



    def numLibros(self):
        if not self.libros:
            print("No hay libros en la biblioteca.")
        for libro in self.libros:
            print(libro)



# Ejemplo de uso
mi_biblioteca = Biblioteca()
mi_biblioteca.agregarLibros('Cien Años de Soledad', 'Gabriel Garcia Marquez', 1967)
mi_biblioteca.agregarLibros('1984', 'George Orwell', 1949)
mi_biblioteca.guardarLibros()


mi_biblioteca.cargarLibros()
print(f"Tienes esta cantidad de libros: {mi_biblioteca.numLibros()}")
