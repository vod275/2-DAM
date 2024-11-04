class Biblioteca:
    def __init__(self):
        self.libros = []

    def agregarLibros(self, titulo, autor, isbn):
        libro = {
            'titulo': titulo,
            'autor': autor,
            'isbn': isbn
        }
        self.libros.append(libro)
        print(f'Libro "{titulo}" agregado a la biblioteca.')


# Ejemplo de uso
mi_biblioteca = Biblioteca()
mi_biblioteca.agregarLibros('Cien Años de Soledad', 'Gabriel García Márquez', '978-84-376-0494-7')