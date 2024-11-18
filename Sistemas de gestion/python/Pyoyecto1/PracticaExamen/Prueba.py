class Prueba:
    def __init__(self, receta, puntuacion):
        self.receta = receta
        self.puntuacion = puntuacion

    def __repr__(self):
        return f"Prueba con receta: {self.receta.nombre} - Puntuación: {self.puntuacion}"
