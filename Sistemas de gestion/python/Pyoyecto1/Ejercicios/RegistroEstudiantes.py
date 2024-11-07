import json

# Clase Estudiante
class Estudiante:
    def __init__(self, nombre, apellido, edad, clase):
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad
        self.clase = clase

    def __str__(self):
        return f"Nombre: {self.nombre} \nApellido: {self.apellido} \nEdad: {self.edad} \nClase: {self.clase}"

    def to_dict(self):
        return {
            'nombre': self.nombre,
            'apellido': self.apellido,
            'edad': self.edad,
            'clase': self.clase
        }


# Clase Metodos
class Metodos:
    def __init__(self):
        self.estudiantes = []

    def diccionarioEstudiante(self):
        diccionario_estudiantes = {}
        for i, estudiante in enumerate(self.estudiantes, 1):
            diccionario_estudiantes[f'estudiante_{i}'] = estudiante.to_dict()
        return diccionario_estudiantes

    def agregarEstudiante(self, estudiante):
        self.estudiantes.append(estudiante)

    def guardarEstudiantes(self):
        archivo = 'estudiantes.json'
        with open(archivo, 'w') as f:
            json.dump([estudiante.to_dict() for estudiante in self.estudiantes], f)
        print(f'Estudiantes guardados en {archivo}.')



estudiante1 = Estudiante("Juan", "Pérez", 20, "Matemáticas")
estudiante2 = Estudiante("Ana", "García", 22, "Física")
estudiante3 = Estudiante("Luis", "Rodríguez", 21, "Biología")


metodos = Metodos()

metodos.agregarEstudiante(estudiante1)
metodos.agregarEstudiante(estudiante2)
metodos.agregarEstudiante(estudiante3)


diccionario = metodos.diccionarioEstudiante()
print(diccionario)
metodos.guardarEstudiantes()
