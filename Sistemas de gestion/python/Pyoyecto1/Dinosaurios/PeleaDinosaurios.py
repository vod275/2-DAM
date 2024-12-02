# Simulación
import random
import time

from Dinosaurios.spinosaurus import Spinosaurus
from Dinosaurios.triceratops import Triceraptors
from Dinosaurios.tyrannosaurusRex import TyrannosaurusRex



def simulacion():
    dinos = [
        Triceraptors("Triceraptor1"),
        Spinosaurus("Spinosaurus1"),
        TyrannosaurusRex("TyrannosaurusRex1"),
        Triceraptors("Triceraptor2"),
        Spinosaurus("Spinosaurus2"),
        TyrannosaurusRex("TyrannosaurusRex2"),
        Triceraptors("Triceraptor3"),
        Spinosaurus("Spinosaurus3"),
        TyrannosaurusRex("TyrannosaurusRex3")
    ]


    while True:
        vivos = [d for d in dinos if d.vivo]
        if not vivos:
            print("Todos los dinosaurios han muerto. Fin de la simulación.")
            break

        for dino in vivos:
            accion = dino.accion()
            print(f"{dino.nombre} decidió: {accion}.")

            if accion == "desplazarse":
                dino.desplazarse(random.choice(vivos))
            elif accion == "comer":
                dino.comer()
            elif accion == "atacar":
                presas = [d for d in vivos if d is not dino and abs(dino.posicion - d.posicion) <= 5]
                if presas:
                    presa = random.choice(presas)
                    dino.atacar(presa)
                else:
                    print(f"{dino.nombre} no encuentra presas en rango. Se desplazará hacia la más cercana.")
                    objetivo = min(vivos, key=lambda x: abs(dino.posicion - x.posicion))
                    dino.desplazarse(objetivo)

        if input("Presiona Enter para continuar o escribe 'q' para salir: ").lower() == "q":
            print("Simulación detenida por el usuario.")
            break


if __name__ == "__main__":
    simulacion()