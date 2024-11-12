#clase ingrediente con nombre, cantidad y descripción

class Ingrediente:
    def __init__(self, nombre, cantidad, descripcion):
        self.nombre = nombre
        self.cantidad = cantidad
        self.descripcion = descripcion

    def __str__(self):
        return f"Los ingredientes son: {self.nombre} {self.cantidad} {self.descripcion}"

    def to_dict(self):
        return {
            'nombre': self.nombre,
            'cantidad': self.cantidad,
            'descripcion': self.descripcion
        }

