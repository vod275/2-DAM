# Simulación
import random
import time

from Dinosaurios.spinosaurus import Spinosaurus
from Dinosaurios.triceratops import Triceraptor
from Dinosaurios.tyrannosaurusRex import TyrannosaurusRex



def simulacion():
    dinos = [
        Triceraptor("Triceraptor1"),
        Spinosaurus("Spinosaurus1"),
        TyrannosaurusRex("TyrannosaurusRex1"),
        Triceraptor("Triceraptor2"),
        Spinosaurus("Spinosaurus2"),
        TyrannosaurusRex("TyrannosaurusRex2"),
        Triceraptor("Triceraptor3"),
        Spinosaurus("Spinosaurus3"),
        TyrannosaurusRex("TyrannosaurusRex3")
    ]

    while True:
        vivos = [d for d in dinos if d.vivo]
        if not vivos:
            print("Todos los dinosaurios han muerto. Fin de la simulación.")
            break

        for dino in vivos:
            accion = random.choices(["desplazarse", "comer", "atacar"], [0.4, 0.3, 0.3])[0]
            try:
                if accion == "desplazarse":
                    dino.desplazarse(random.randint(1, 3))
                elif accion == "comer":
                    dino.comer()
                elif accion == "atacar" and isinstance(dino, (Spinosaurus, TyrannosaurusRex)):
                    presa = random.choice([d for d in vivos if d is not dino])
                    dino.atacar(presa)
            except Exception as e:
                print(e)

        time.sleep(1)
        if input("Presiona Enter para continuar o escribe 'q' para salir: ").lower() == "q":
            print("Simulación detenida por el usuario.")
            break


if __name__ == "__main__":
    simulacion()