#Una receta tendrá como información un nombre (que servirá también como identificador), una serie de
# ingredientes y una serie de pasos de cocinado los pasos y los ingredientes son una lista.
from Recursos.EscribirFichero import lista


class Receta:
    def __init__(self, nombre, ingredientes, pasos):
        self.nombre = nombre
        self.ingredientes = ingredientes
        self.pasos = pasos


    def __str__(self):
        return f"Los ingredientes son: {self.nombre} {self.ingredientes} {self.pasos}"



    def to_dict(self):
        ingredientes = []
        for ingrediente in self.ingredientes:
            ingrediente.to_dict()

        pasos = []
        for pasoss in self.pasos:
            pasoss.to_dict()
        return {
            'nombre': self.nombre,
            'ingredientes': ingredientes,
            'pasos': pasos
        }

