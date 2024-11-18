class Aspirante:
    def __init__(self, nombre):
        self.nombre = nombre
        self.puntuacion = 0
        self.pruebas = []  # Lista de pruebas asociadas al aspirante

    def __repr__(self):
        return f"{self.nombre} - Puntuación: {self.puntuacion}"
