from Dinosaurios.dinosaurio import Dinosaurio


class TyrannosaurusRex(Dinosaurio):

    def __init__(self, nombre):
        super().__init__(nombre, 100, False)

    def desplazarse(self, distancia):
        super().desplazarse(distancia, 1)

    def atacar(self, presa):
        super().atacar(presa, 20)