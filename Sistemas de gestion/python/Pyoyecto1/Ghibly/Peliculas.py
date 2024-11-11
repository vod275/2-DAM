class pelicula:
    def __init__(self,codigo,titulo,anio,director,personajes,vehiculos):
        self.codigo=codigo
        self.titulo=titulo
        self.anio=anio
        self.director=director
        self.personajes=personajes
        self.vehiculos=vehiculos

    def a_diccionario (self):
        return {
            "Codigo":self.codigo,
            "Titulo":self.titulo,
            "Año":self.anio,
            "Director":self.director,
            "Personajes":self.personajes,
            "Vehiculos":self.vehiculos
        }