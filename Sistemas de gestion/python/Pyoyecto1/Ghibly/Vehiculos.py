class vehiculo:
    def __init__(self,codigo,nombre,pelicula,piloto):
        self.codigo=codigo
        self.nombre=nombre
        self.pelicula=pelicula
        self.piloto=piloto

    def toDict (self):
        return {
            "Codigo":self.codigo,
            "Nombre":self.nombre,
            "Pelicula":self.pelicula,
            "Piloto":self.piloto
        }