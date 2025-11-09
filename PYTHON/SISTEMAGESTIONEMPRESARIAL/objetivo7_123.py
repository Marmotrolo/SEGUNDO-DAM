
#MANUEL PARRADO TORRES

class Vehiculo:
    def __init__(self, marca = "", velocidad_inicial = 0):
        self.__marca = marca
        self.__velocidad_inicial = velocidad_inicial
    def SetMarca(self, marca):
        self.__marca = marca
    
    def GetMarca(self):
        return self.__marca
    
    def SetVelocidad_Inicial(self, velocidad_inicial):
        self.__velocidad_inicial = velocidad_inicial

    def GetVelocidad_Inicial(self):
        return self.__velocidad_inicial
    
    def acelerar(self, v):
        mas_velocidad = self.GetVelocidad_Inicial()+v

        self.SetVelocidad_Inicial(mas_velocidad)
        return mas_velocidad
    
    def desacelerar(self, v):
        menos_velocidad = self.GetVelocidad_Inicial()-v
        self.SetVelocidad_Inicial(menos_velocidad)
        return menos_velocidad
    
    def mostrarVelocidad(self):
        return self.GetVelocidad_Inicial()


class Coche(Vehiculo):
    def __init__(self, marca, velocidad_inicial):
        super().__init__(marca, velocidad_inicial)
        self.bocina = "¡tuuut!"
    
    def tocar_claxon(self):
        return self.bocina


vehiculo = Vehiculo()
coche = Coche("Peugeot 3008", 4)
print("Marca: ", coche.GetMarca())
print("La velocidad inicial es: ", coche.mostrarVelocidad())
coche.acelerar(12)
print(coche.mostrarVelocidad(),"km/h")
coche.desacelerar(10)
print(coche.mostrarVelocidad(),"km/h")