#MANUEL PARRADO TORRES
#calculadora interactiva, capaz de realizar tanto las operaciones matemáticas básicas (suma, resta, multiplicación, división) como otras operaciones extendidas (potencia, raíz cuadrada y módulo).

import math  

def pedir_numero(mensaje):
    """
    Solicita un número al usuario y controla entradas no numéricas.
    """
    while True:
        try:
            return float(input(mensaje))
        except ValueError:
            print(" Error: introduce un número válido.")


def sumar():
    """Realiza la suma de dos números."""
    a = pedir_numero("Introduce el primer número: ")
    b = pedir_numero("Introduce el segundo número: ")
    resultado = a + b
    print("Resultado de la suma:" + resultado)


def restar():
    """Realiza la resta de dos números."""
    a = pedir_numero("Introduce el primer número: ")
    b = pedir_numero("Introduce el segundo número: ")
    resultado = a - b
    print("Resultado de la resta:"+ resultado)


def multiplicar():
    """Realiza la multiplicación de dos números."""
    a = pedir_numero("Introduce el primer número: ")
    b = pedir_numero("Introduce el segundo número: ")
    resultado = a * b
    print("Resultado de la multiplicación"+ resultado)


def dividir():
    """Realiza la división entre dos números, controlando la división entre cero."""
    a = pedir_numero("Introduce el dividendo: ")
    b = pedir_numero("Introduce el divisor: ")
    if b == 0:
        print("Error: no se puede dividir entre cero.")
        return
    resultado = a / b
    print("Resultado de la división"+ resultado)



def potencia():
    """Calcula la potencia de un número (base ^ exponente)."""
    base = pedir_numero("Base: ")
    exponente = pedir_numero("Exponente: ")
    resultado = math.pow(base, exponente)
    print("Resultado"+ resultado)


def raiz_cuadrada():
    """Calcula la raíz cuadrada de un número, evitando valores negativos."""
    numero = pedir_numero("Introduce un número: ")
    if numero < 0:
        print(" Error: no se puede calcular la raíz cuadrada de un número negativo.")
        return
    resultado = math.sqrt(numero)
    print("Resultado"+ resultado)


def modulo():
    """Calcula el módulo (resto) de la división entre dos números."""
    a = pedir_numero("Introduce el primer número: ")
    b = pedir_numero("Introduce el segundo número: ")
    if b == 0:
        print(" Error: no se puede calcular el módulo con divisor cero.")
        return
    resultado = a % b
    print("Resultado"+ resultado)


# ------------------------------------------------------------
# MENÚ PRINCIPAL
# ------------------------------------------------------------

def menu_avanzado():
    """
    Muestra el submenú de operaciones avanzadas
    y ejecuta la opción elegida.
    """
    while True:
        print("\nOperaciones avanzadas:")
        print("a) Potencia")
        print("b) Raíz cuadrada")
        print("c) Módulo")
        print("d) Volver")
        opcion = input("Selecciona una opción: ").lower()

        if opcion == "a":
            potencia()
        elif opcion == "b":
            raiz_cuadrada()
        elif opcion == "c":
            modulo()
        elif opcion == "d":
            break
        else:
            print("Opción no válida. Inténtalo de nuevo.")


def menu():
    """
    Muestra el menú principal de la calculadora
    y permite realizar operaciones hasta que el usuario decida salir.
    """
    while True:
        print("\n=========================")
        print("  CALCULADORA AVANZADA  ")
        print("=========================")
        print("1) Sumar")
        print("2) Restar")
        print("3) Multiplicar")
        print("4) Dividir")
        print("5) Operaciones avanzadas")
        print("6) Salir")

        opcion = input("Elige una opción: ")

        if opcion == "1":
            sumar()
        elif opcion == "2":
            restar()
        elif opcion == "3":
            multiplicar()
        elif opcion == "4":
            dividir()
        elif opcion == "5":
            menu_avanzado()
        elif opcion == "6":
            print("Fin del programa. ¡Hasta pronto! 👋")
            break
        else:
            print("Opción no válida. Inténtalo de nuevo.")


menu()
