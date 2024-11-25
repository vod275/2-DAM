from Dinosaurios.dinosaurio import Dinosaurio


class Triceraptor(Dinosaurio):
    def __init__(self, nombre):

        super().__init__(nombre, False, 100)

    def desplazarse(self, distancia):

        super().desplazarse(distancia, 5)
