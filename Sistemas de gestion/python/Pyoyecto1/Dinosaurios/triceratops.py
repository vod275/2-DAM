from Dinosaurios.dinosaurio import Dinosaurio


class Triceraptors(Dinosaurio):
    def __init__(self, nombre):
        super().__init__(nombre, 100, True)

    def desplazarse(self, distancia):

        super().desplazarse(distancia, 5)
