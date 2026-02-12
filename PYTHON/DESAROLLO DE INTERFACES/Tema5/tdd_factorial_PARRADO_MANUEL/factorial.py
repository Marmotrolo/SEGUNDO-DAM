#MANUEL PARRADO TORRES
def factorial(n):
    if type(n) is not int:
        raise TypeError("El valor debe ser un entero")

    if n < 0:
        raise ValueError("El valor no puede ser negativo")

    resultado=1
    for i in range (1,n+1 ):
        resultado= resultado*i

    return resultado


