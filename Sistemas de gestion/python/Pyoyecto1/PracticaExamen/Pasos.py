#Un paso tendrá un número, una descripción y una duración.


class Pasos:
    def __init__(self, numero, descripcion, duracion):
        self.numero = numero
        self.descripcion = descripcion
        self.duracion = duracion

    def __str__(self):
        return f"Los pasos son: {self.numero} {self.descripcion} {self.duracion}"

    def to_dict(self):
        return {
            'numero': self.numero,
            'descripcion': self.descripcion,
            'duracion': self.duracion
        }