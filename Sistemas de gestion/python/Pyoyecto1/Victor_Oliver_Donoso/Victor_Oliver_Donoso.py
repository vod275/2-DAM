import json
import random



class Item:
    def __init__(self, nombre, tipo, valor):
        self.nombre = nombre
        self.tipo = tipo
        self.valor = valor

    def mostrar_item(self):
        print(f"Nombre: {self.nombre}, Tipo: {self.tipo}, Valor: {self.valor}")

class Personaje:
    def __init__(self, nombre, nivel, vida):
        self.nombre = nombre
        self.nivel = nivel
        self.vida = vida
        self.inventario = []

    def mostrar_info(self):
        print(f"Nombre: {self.nombre}, Nivel: {self.nivel}, Vida: {self.vida}")

    def agregar_item(self, item):
        self.inventario.append(item)

    def guardar_personaje(self, filename):
        data = {
            "nombre": self.nombre,
            "nivel": self.nivel,
            "vida": self.vida,
            "inventario": [vars(item) for item in self.inventario]
        }
        with open(filename, "w") as file:
            json.dump(data, file, indent=4)



    def cargar_personaje(self, filename):
        with open(filename, "r") as file:
            data = json.load(file)
        personaje = Personaje(data["nombre"], data["nivel"], data["vida"])
        personaje.inventario = [Item(**item) for item in data["inventario"]]
        return personaje



    def describir(self, **kwargs):
        descripciones = []
        for key, value in kwargs.items():
            if key == "arma":
                descripciones.append(f"usa una {value}")
            elif key == "armadura":
                descripciones.append(f"lleva una armadura de {value}")
            elif key == "pocion":
                descripciones.append(f"tiene una poción de {value}")
        print(f"El personaje {', '.join(descripciones)}.")




class Heroe(Personaje):
    def __init__(self, nombre, nivel, vida, clase):
        super().__init__(nombre, nivel, vida)
        self.clase = clase

    def mostrar_info(self):
        super().mostrar_info()
        print(f"Clase: {self.clase}")

    def subir_nivel(self):
        self.nivel += 1
        self.vida += 10



class Enemigo(Personaje):
    def __init__(self, nombre, nivel, vida, dificultad):
        super().__init__(nombre, nivel, vida)
        self.dificultad = dificultad

    def mostrar_info(self):
        super().mostrar_info()
        print(f"Dificultad: {self.dificultad}")




def generar_heroe():
    return Heroe("Gandalf", 1, 100, "Mago")


def generar_enemigos(cantidad):
    nombres = ["Parshendi", "Troll", "Picaro", "Esqueleto", "Dragon", "Brujo Oscuro"]
    dificultades = ["Facil", "Normal", "Dificil"]
    enemigos = []
    for _ in range(cantidad):
        nombre = random.choice(nombres)
        nivel = random.randint(1, 5)
        vida = random.randint(30, 100)
        dificultad = random.choice(dificultades)
        enemigos.append(Enemigo(nombre, nivel, vida, dificultad))
    return enemigos


def simular_combate(heroe, enemigo):
    turno = 0
    while heroe.vida > 0 and enemigo.vida > 0:
        atacante = heroe if turno % 2 == 0 else enemigo
        defensor = enemigo if turno % 2 == 0 else heroe

        dano = random.randint(5, 15)
        defensor.vida -= dano
        print(f"{atacante.nombre} ataco a {defensor.nombre} causando {dano} de daño. {defensor.nombre} tiene {defensor.vida} de vida.")

        if defensor.vida <= 0:
            print(f"{defensor.nombre} ha muerto.")
            if defensor == enemigo:
                heroe.subir_nivel()
            break

        turno += 1




def main():
    heroe = generar_heroe()
    heroe.agregar_item(Item("Baston", "arma", 50))
    heroe.agregar_item(Item("Pocion de vida", "pocion", 20))

    enemigos = generar_enemigos(6)

    heroe.describir(arma="Espada", armadura="Cuero")



    for enemigo in enemigos:
        print("\nIniciando combate:")
        heroe.mostrar_info()
        enemigo.mostrar_info()
        simular_combate(heroe, enemigo)

        heroe.guardar_personaje("heroe.json")
        # Lo tengo hecho pero no se por que me falla al cargar, si estas leyendo esto, esque no pude resolverlo:(
        # y aunque no da error, no me carga
        heroe.cargar_personaje("heroe.json")

        if heroe.vida <= 0:
            break
    else:
        print("El heroe ha derrotado a todos los enemigo")

if __name__ == "__main__":
    main()
