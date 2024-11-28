import random

class Dinosaurio:
    def __init__(self, nombre, energia, es_de_manada):
        self.nombre = nombre
        self.es_de_manada = es_de_manada
        self.energia = energia
        self.posicion = random.randint(0, 100)
        self.vivo = True


    def comer(self):
        if not self.vivo:
            print(f"{self.nombre} está muerto y no puede comer.")
            return
        self.energia += 100
        print(f"{self.nombre} ha comido y ahora tiene {self.energia} de energía.")

    def desplazarse(self, distancia, costo_energia):
        # Validar que la distancia esté entre 1 y 3
        if distancia < 1 or distancia > 3:
            print(f"Error: {self.nombre} solo puede desplazarse una distancia entre 1 y 3 metros.")
            return

        if not self.vivo:
            print(f"{self.nombre} está muerto y no puede desplazarse.")
            return

        self.comprobarEnergia()
        energia_necesaria = distancia * costo_energia

        if self.energia >= energia_necesaria:
            self.energia -= energia_necesaria
            self.posicion += distancia
            print(
                f"{self.nombre} se desplazó {distancia} metros. Posición actual: {self.posicion}. Energía restante: {self.energia}.")
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



    def comprobarEnergia(self):
        if self.energia <= 0:
            self.vivo = False
            print(f"{self.nombre} murió por falta de energía.")

    def atacar(self, presa, costo_energia=20):
        if not self.vivo:
            print(f"{self.nombre} está muerto y no puede atacar.")
            return

        if self.energia < costo_energia:
            print(f"{self.nombre} no tiene suficiente energía para atacar.")
            return


        distancia = abs(self.posicion - presa.posicion)
        if distancia > 5:
            print(f"{self.nombre} no puede atacar a {presa.nombre} porque están a más de 5 casillas de distancia (distancia actual: {distancia}).")
            return

        # Reducir la energía por el ataque
        self.energia -= costo_energia
        print(f"{self.nombre} intenta atacar a {presa.nombre}...")

        # Calcular probabilidades de supervivencia
        prob_atacante = 0.5 if not self.es_de_manada else 0.8
        prob_presa = 0.5 if not presa.es_de_manada else 0.2

        atacante_sobrevive = random.random() < prob_atacante
        presa_sobrevive = random.random() < prob_presa

        # Resultados del ataque
        if not atacante_sobrevive:
            self.vivo = False
            print(f"{self.nombre} murió durante el ataque.")
        else:
            print(f"{self.nombre} sobrevivió al ataque.")

        if not presa_sobrevive:
            presa.vivo = False
            print(f"{presa.nombre} murió durante el ataque.")
        else:
            print(f"{presa.nombre} sobrevivió al ataque.")

        self.comprobarEnergia()
        presa.comprobarEnergia()



    def accion(self):
        if not self.vivo:
            print(f"{self.nombre} está muerto y no puede realizar acciones.")
            return

        if self.nombre == "TyrannosaurusRex":
            accion_probabilidades = [0.2, 0.2, 0.6]
        elif self.nombre == "Spinosaurus":
            accion_probabilidades = [0.35, 0.35, 0.3]
        else:
            accion_probabilidades = [0.5, 0.5, 0.0]

        accion_dino = random.choices(["desplazarse", "comer", "atacar"], accion_probabilidades)[0]
        print(f"{self.nombre} hizo la acción: {accion_dino}.")





