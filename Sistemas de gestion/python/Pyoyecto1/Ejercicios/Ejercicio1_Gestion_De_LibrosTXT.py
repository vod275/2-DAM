class Libro:
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


    def guardarLibros(self, archivo='libros.txt'):

        with open(archivo, 'w') as f:
             for libro in self.libros:
                 f.write(f"Título: {libro['titulo']}, Autor: {libro['autor']}, Año: {libro['anio']}\n")
                 print(f'Libros guardados en {archivo}.')




    def cargarLibros(self):

        archivo = open('libros.txt', 'r')
        for linea in archivo:
            titulo, autor, anio = linea.split(',')
            self.libros.append({'titulo': titulo, 'autor': autor, 'anio': anio})
        archivo.close()


    def numeroLibros(self):
        return len(self.libros)





# metodos
mi_biblioteca = Biblioteca()
mi_biblioteca.agregarLibros('Cien Años de Soledad', 'Gabriel García Márquez', '1992')
mi_biblioteca.guardarLibros()
mi_biblioteca.cargarLibros()

print(f"Numero de libros: {mi_biblioteca.numeroLibros()}")
