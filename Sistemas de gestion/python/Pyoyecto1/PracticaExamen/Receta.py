class Receta:
    def __init__(self, nombre, ingredientes, pasos):
        self.nombre = nombre
        self.ingredientes = ingredientes
        self.pasos = pasos

    def __str__(self):
        ingredientes_str = ", ".join(str(ingrediente) for ingrediente in self.ingredientes)
        pasos_str = ", ".join(str(paso) for paso in self.pasos)
        return f"Receta: {self.nombre}\nIngredientes: {ingredientes_str}\nPasos: {pasos_str}"

    def to_dict(self):
        return {
            'nombre': self.nombre,
            'ingredientes': [ingrediente.to_dict() for ingrediente in self.ingredientes],
            'pasos': [paso.to_dict() for paso in self.pasos]
        }
