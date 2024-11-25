import random

class Dinosaurio:
    def __init__(self, nombre, carnivoro, energia):
        self.nombre = nombre
        self.carnivoro = carnivoro
        self.energia = energia
        self.posicion = random.randint(0, 100)  # Posición inicial aleatoria
        self.vivo = True

    def comer(self):
        if not self.vivo:
            print(f"{self.nombre} está muerto y no puede comer.")
            return
        self.energia += 100
        print(f"{self.nombre} ha comido y ahora tiene {self.energia} de energía.")


    def desplazarse(self, distancia, costo_energia):
        if not self.vivo:
            print(f"{self.nombre} está muerto y no puede desplazarse.")
            return
        self.comprobarEnergia()
        energia_necesaria = distancia * costo_energia
        if self.energia >= energia_necesaria:
            self.energia -= energia_necesaria
            self.posicion += distancia
            print(f"{self.nombre} se desplazó {distancia} metros. Posición actual: {self.posicion}. Energía restante: {self.energia}.")
        else:
            self.vivo = False
            print(f"{self.nombre} no tiene suficiente energía para desplazarse y ha muerto.")


    def recibir_ataque(self, es_en_manada):
        if not self.vivo:
            print(f"{self.nombre} ya está muerto y no puede ser atacado.")
            return
        probabilidad_supervivencia = 0.8 if es_en_manada else 0.5
        if random.random() < probabilidad_supervivencia:
            print(f"{self.nombre} sobrevivió al ataque.")
        else:
            self.vivo = False
            print(f"{self.nombre} ha muerto tras el ataque.")

    def atacar(self, presa, costo_energia, probabilidad_supervivencia):
        if not self.vivo:
            print(f"{self.nombre} está muerto y no puede atacar.")
            return
        if self.energia < costo_energia:
            print(f"{self.nombre} no tiene suficiente energía para atacar.")
            return
        self.comprobarEnergia()

        print(f"{self.nombre} intenta atacar a {presa.nombre}...")
        # Reducir la energía por el intento de ataque, independientemente del resultado.
        self.energia -= costo_energia

        puede_atacar = random.random() < probabilidad_supervivencia
        if puede_atacar:
            presa.recibir_ataque(es_en_manada=(not presa.carnivoro))
            if presa.vivo and random.random() >= probabilidad_supervivencia:
                self.vivo = False
                print(f"{self.nombre} murió al atacar a {presa.nombre}.")
        else:
            print(f"{self.nombre} falló el ataque. Energía restante: {self.energia}.")

        # Comprobar si el dinosaurio sigue vivo tras el gasto de energía.
        self.comprobarEnergia()

    def comprobarEnergia(self):
        if self.energia <= 0:
            self.vivo = False
            print(f"{self.nombre} ha muerto porque se quedó sin energía.")
