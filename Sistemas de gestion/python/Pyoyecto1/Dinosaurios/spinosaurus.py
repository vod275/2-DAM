from Dinosaurios.dinosaurio import Dinosaurio


class Spinosaurus(Dinosaurio):

    def __init__(self, nombre):
        super().__init__(nombre, True, 100)

    def desplazarse(self, distancia):
        super().desplazarse(distancia, 2)

    def atacar(self, presa):
        super().atacar(presa, 20, 0.5)