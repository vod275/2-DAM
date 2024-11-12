from Peliculas import pelicula
from Personajes import personaje
from Vehiculos import vehiculo

persona = personaje(1,"Chihiro","femenino",14,"El viaje de chihiro","humano")
persona2 = personaje(2,"Totoro","masculino",500,"Mi vecino totoro","totoro")
persona3 = personaje(3,"Yubaba","femenino",1000,"El viaje de chihiro","Bruja")
persona4 = personaje(4,"Akio","masculino",20,"El viaje de chihiro","humano")
chihiro = []

chihiro.append(persona.toDict())
chihiro.append(persona3.toDict())
chihiro.append(persona4.toDict())
v1 = vehiculo(1,"Audi","El viaje de chihiro",persona4.toDict())
v2 = vehiculo(2,"Escoba","El viaje de chihiro",persona3.toDict())
vehiculos1 = []
vehiculos1.append(v1.toDict())
vehiculos1.append(v2.toDict())
p = pelicula(1,"El viaje de chihiro",1984,"Iwata",chihiro,vehiculos1)
mostrar = p.a_diccionario()

print(mostrar)