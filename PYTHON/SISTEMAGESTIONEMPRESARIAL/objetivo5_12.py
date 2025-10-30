# ============================================================
# Nombre: [Tu Nombre Aquí]
# Apellidos: [Tus Apellidos Aquí]
# Grupo: [Tu Grupo Aquí]
# Archivo: objetivo5_fase12.py
# Descripción: Calculadora interactiva con operaciones básicas
#              y avanzadas, estructurada mediante funciones.
# ============================================================

import math  # Se importa para usar raíz cuadrada y potencia

# ------------------------------------------------------------
# FUNCIONES DE OPERACIONES BÁSICAS
# ------------------------------------------------------------

def pedir_numero(mensaje):
    """
    Solicita un número al usuario y controla entradas no numéricas.
    """
    while True:
        try:
            return float(input(mensaje))
        except ValueError:
            print("❌ Error: introduce un número válido.")


def sumar():
    """Realiza la suma de dos números."""
    a = pedir_numero("Introduce el primer número: ")
    b = pedir_numero("Introduce el segundo número: ")
    resultado = a + b
    print(f"Resultado de la suma: {resultado:.2f}")


def restar():
    """Realiza la resta de dos números."""
    a = pedir_numero("Introduce el primer número: ")
    b = pedir_numero("Introduce el segundo número: ")
    resultado = a - b
    print(f"Resultado de la resta: {resultado:.2f}")


def multiplicar():
    """Realiza la multiplicación de dos números."""
    a = pedir_numero("Introduce el primer número: ")
    b = pedir_numero("Introduce el segundo número: ")
    resultado = a * b
    print(f"Resultado de la multiplicación: {resultado:.2f}")


def dividir():
    """Realiza la división entre dos números, controlando la división entre cero."""
    a = pedir_numero("Introduce el dividendo: ")
    b = pedir_numero("Introduce el divisor: ")
    if b == 0:
        print("❌ Error: no se puede dividir entre cero.")
        return
    resultado = a / b
    print(f"Resultado de la división: {resultado:.2f}")


# ------------------------------------------------------------
# FUNCIONES DE OPERACIONES AVANZADAS
# ------------------------------------------------------------

def potencia():
    """Calcula la potencia de un número (base ^ exponente)."""
    base = pedir_numero("Base: ")
    exponente = pedir_numero("Exponente: ")
    resultado = math.pow(base, exponente)
    print(f"Resultado: {resultado:.2f}")


def raiz_cuadrada():
    """Calcula la raíz cuadrada de un número, evitando valores negativos."""
    numero = pedir_numero("Introduce un número: ")
    if numero < 0:
        print("❌ Error: no se puede calcular la raíz cuadrada de un número negativo.")
        return
    resultado = math.sqrt(numero)
    print(f"Resultado: {resultado:.2f}")


def modulo():
    """Calcula el módulo (resto) de la división entre dos números."""
    a = pedir_numero("Introduce el primer número: ")
    b = pedir_numero("Introduce el segundo número: ")
    if b == 0:
        print("❌ Error: no se puede calcular el módulo con divisor cero.")
        return
    resultado = a % b
    print(f"Resultado: {resultado:.2f}")


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
            print("❌ Opción no válida. Inténtalo de nuevo.")


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
            print("❌ Opción no válida. Inténtalo de nuevo.")


# ------------------------------------------------------------
# EJECUCIÓN DEL PROGRAMA
# ------------------------------------------------------------
if __name__ == "__main__":
    menu()
