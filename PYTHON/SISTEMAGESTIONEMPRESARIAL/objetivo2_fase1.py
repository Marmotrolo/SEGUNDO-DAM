#MANUEL PARRADO TORRES 2ºDAM
#Pido 2 números y hace las operaciones simples, mientras que suma y resta es int, division y multiplicacion es float

print("-1-")
num1= int(input("Dime un numero"))
num2= int(input("Dime otro numero"))
suma= int(num1+num2)
resta= int(num1-num2)
multiplicacion= float(num1*num2)
division= float(num1/num2)
print(suma)
print(resta)
print(multiplicacion)
print(division)
#Pido 3 números decimales (uso float porque pueden tener decimales), saco la media y la redondeo a 2 decimales con round
print("-2-")
num3= float(input("Dime un numero"))
num4= float(input("Dime otro numero"))
num5= float(input("Dime otro numero"))

media= float(round((num3 + num4 + num5)/ 3, 2))
print(media)

#Pido 2 números enteros (uso int porque no necesito decimales), comparo si el primero es mayor, si son iguales y si el segundo es distinto de 0

print("-3-")
num6= int(input("Dime un numero"))
num7= int(input("Dime otro numero"))

primeroesmayor = num6>num7
soniguales = num6==num7
segundonoes0= num7!=0

print("¿El primero es mayor?"  + str(primeroesmayor))
print ("Son iguales?" + str(soniguales))
print ("El segundo e distinto a cero?" + str(segundonoes0))
# Pido 2 valores lógicos, pero como input siempre da texto, lo convierto a bool
print("-4-")

booleano1=bool(input("Introduce el primer valor lógico (True/False)"))
booleano2=bool(input("Introduce el segundo valor lógico (True/False)"))
print(booleano1 and booleano2)
print(booleano1 or booleano2)
print (not booleano1  )
print (not booleano2)

print("-5-")
#Pido 2 edades, las sumo y hago la media conviertiendolo a float
edad1= int(input(("Dime tu edad ")))
edad2=  int (input ( ("Dime otra edad ")))
sumaedad=edad1+ edad2
promedioedad = float(round((sumaedad)/2))
print(sumaedad)
print(promedioedad)
#Pido 2 numeros y hago las validaciones
print("-6-")

num8= int(input("Dime un numero"))
num9= int(input("Dime otro numero"))
print(num8>10 and num9<5)
print(num8==num9 or num9>0)
print(not num8<num9)

#Pido 2 numeros reales y hago la media, redondeandolo a 1 deciamal con round
print("-7-")

real1= float(input(("Dime un numero con decimal")))
real2= float(input(("Dime otro numero con decimal")))

print(round(real1/real2,1))
