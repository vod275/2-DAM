class Aspirante:
    def __init__(self, nombre):
        self.nombre = nombre
        self.puntuacion = 0
        self.pruebas = []
        self.favorito = ""

    def __repr__(self):
        return f"{self.nombre} - Puntuación: {self.puntuacion}"
