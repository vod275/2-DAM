import random

class Juez:
    def __init__(self, nombre):
        self.nombre = nombre

    def votar(self):
        return random.choice([5, 4, 0, -1, -2])

    def __repr__(self):
        return f"Juez: {self.nombre}"