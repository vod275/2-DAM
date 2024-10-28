#clase cliente con numero de cuenta y balance, ademas de la clase persona
from _ast import While

from Ejer_Cuenta_Bancaria.Personas import Personas

class Clientes(Personas):
    def __init__(self, numero_cuenta, balance, nombre, apellido):
        super(Clientes, self).__init__(nombre,apellido)
        self.numero_cuenta = numero_cuenta
        self.balance = balance


    def mostrarDatosCliente(self):
        print(f"Cuenta Bancaria: {self.numero_cuenta} \nBalance: {self.balance}")

    def mostrarDatos(self):
        print(super().mostrarDatosPersona())
        print(self.mostrarDatosCliente())

    def depositar(self, cantidad):
        self.balance += cantidad
        print(f"Se ha depositado: {cantidad}. Nuevo balance: {self.balance}")

    def retirar(self, cantidad):
        if cantidad > self.balance:
            print("Fondos insuficientes para retirar esa cantidad.")
        else:
            self.balance -= cantidad
            print(f"Se ha retirado: {cantidad}. Nuevo balance: {self.balance}")



if __name__ == '__main__':
    cliente = None
    while True:
        print("\n--- Menú de Opciones ---")
        print("0. Crear un cliente")
        print("1. Ingresar dinero")
        print("2. Retirar dinero")
        print("3. Ver datos del cliente")
        print("4. Salir")
        print("5. Divide por 0")

        opcion = int(input("Elige una opción: "))

        match opcion:
            case 0:
                nombre = input("Introduce el nombre del cliente: ")
                apellido = input("Introduce el apellido del cliente: ")
                numero_cuenta = input("Introduce el número de cuenta: ")
                balance = float(input("Introduce el balance inicial: "))
                cliente = Clientes(numero_cuenta, balance, nombre, apellido)
                print("Cliente creado con éxito.")

            case 1:
                if cliente:
                    cantidad = float(input("Introduce la cantidad a ingresar: "))
                    Clientes.depositar(cliente, cantidad)
                else:
                    print("Primero debes crear un cliente.")

            case 2:
                if cliente:
                    cantidad = float(input("Introduce la cantidad a retirar: "))
                    Clientes.retirar(cliente, cantidad)
                else:
                    print("Primero debes crear un cliente.")

            case 3:
                if cliente:
                    Clientes.mostrarDatos(cliente)
                else:
                    print("Primero debes crear un cliente.")

            case 4:
                print("Saliendo del programa.")
                break
            case 5:
                n1 = 2
                n2 = 0
                try:
                 resultado = n1 / n2
                 print(int(resultado))
                except ValueError:
                 print("Error: No se puede dividir entre 0.")

            case _:
                print("Opción no válida. Inténtalo de nuevo.")





