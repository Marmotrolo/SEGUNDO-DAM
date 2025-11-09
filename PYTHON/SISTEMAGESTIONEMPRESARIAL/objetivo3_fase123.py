#MANUEL PARRADO TORRES
# programa que realiza cinco comprobaciones diferentes con ayuda de estructuras condicionales 
numero = int(input("Introduce un número entero: "))

if numero > 0:
    print("El número es positivo.")
elif numero < 0:
    print("El número es negativo.")
else:
    print("El número es cero.")



num1 = int(input("\nIntroduce el primer número entero: "))
num2 = int(input("Introduce el segundo número entero: "))

if num1 > num2:
    print("El primero es mayor que el segundo.")
elif num2 > num1:
    print("El segundo es mayor que el primero.")
else:
    print("Ambos son iguales.")



frase = input("\nIntroduce una frase: ")
palabra = input("Introduce una palabra a buscar: ")

if palabra in frase:
    print("La palabra está en la frase.")
else:
    print("La palabra no se encuentra.")



texto = input("\nIntroduce un texto: ")

if texto[:1].isupper():
    print("Empieza por mayúscula.")
elif texto.endswith("."):
    print("Termina en punto.")
else:
    print("El texto no cumple las condiciones.")


nota = float(input("\nIntroduce una nota (0 a 10): "))

if nota == 0 and nota <= 4:
    print("Insuficiente")
elif nota == 5:
    print("Suficiente")
elif nota == 6:
    print("Bien")
elif nota == 7 or nota == 8:
    print("Notable")
elif nota == 9 or nota == 10:
    print("Sobresaliente")
else:
    print("Nota no válida")
