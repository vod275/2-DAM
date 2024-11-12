class personaje:
    def __init__(self,codigo,nombre,genero,edad,pelicula,especie):
        self.codigo=codigo
        self.nombre=nombre
        self.genero=genero
        self.edad=edad
        self.pelicula=pelicula
        self.especie=especie

    def toDict (self):
        return {
            "Codigo":self.codigo,
            "Nombre":self.nombre,
            "Genero":self.genero,
            "Edad":self.edad,
            "Pelicula":self.pelicula,
            "Especie":self.especie
        }