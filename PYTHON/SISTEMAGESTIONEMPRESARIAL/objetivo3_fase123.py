# Nombre: [Tu Nombre]
# Apellidos: [Tus Apellidos]
# Grupo: [Tu Grupo]

# OBJETIVO 3 - FASES 1, 2 y 3
# Este programa realiza cinco comprobaciones usando estructuras condicionales simples.

# --- 1. Evaluar un número ---
# Pedimos al usuario un número entero y mostramos si es positivo, negativo o cero.

numero = int(input("Introduce un número entero: "))

if numero > 0:
    print("El número es positivo.")
elif numero < 0:
    print("El número es negativo.")
else:
    print("El número es cero.")

# --- 2. Comparar dos números ---
# Pedimos dos números y los comparamos para saber cuál es mayor o si son iguales.

num1 = int(input("\nIntroduce el primer número entero: "))
num2 = int(input("Introduce el segundo número entero: "))

if num1 > num2:
    print("El primero es mayor que el segundo.")
elif num2 > num1:
    print("El segundo es mayor que el primero.")
else:
    print("Ambos son iguales.")

# --- 3. Comprobar texto dentro de una frase ---
# Se pide una frase y luego una palabra, y se verifica si la palabra está en la frase.

frase = input("\nIntroduce una frase: ")
palabra = input("Introduce una palabra a buscar: ")

if palabra in frase:
    print("La palabra está en la frase.")
else:
    print("La palabra no se encuentra.")

# --- 4. Verificar el formato de una cadena ---
# Se analiza si el texto empieza con mayúscula o termina en punto.

texto = input("\nIntroduce un texto: ")

if texto[:1].isupper():
    print("Empieza por mayúscula.")
elif texto.endswith("."):
    print("Termina en punto.")
else:
    print("El texto no cumple las condiciones.")

# --- 5. Clasificar una nota ---
# Se pide una nota del 0 al 10 y se muestra su calificación correspondiente.

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
