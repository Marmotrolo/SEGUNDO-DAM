# MANUEL PARRADO TORRES 2ºDAM       

# Programa que realiza un análisis completo de una frase introducida por el usuario aplicando los principales métodos de cadenas de Python



frase = input("Introduce una frase o palabra: ")

    # Mostrar la frase en distintos formatos
print("\n--- FORMATO DEL TEXTO ---")
print("Capitalizada:", frase.capitalize())
print("Mayúsculas:", frase.upper())
print("Minúsculas:", frase.lower())
print("Invertida:", frase.swapcase())

    # Información sobre el contenido de la frase
print("\n--- ANÁLISIS DEL CONTENIDO ---")
print("¿Solo letras?:", frase.isalpha())
print("¿Solo números?:", frase.isdigit())
print("¿Letras y números?:", frase.isalnum())
print("¿Está en minúsculas?:", frase.islower())
print("¿Está en mayúsculas?:", frase.isupper())

    # Número total de caracteres y caracteres sin espacios
print("\n--- LONGITUD ---")
print("Número total de caracteres:", len(frase))
print("Caracteres reales (sin espacios):", len(frase.replace(" ", "")))

    # Frase sin espacios sobrantes (strip, lstrip, rstrip)
print("\n--- LIMPIEZA ---")
print("Sin espacios al principio:", frase.lstrip())
print("Sin espacios al final:", frase.rstrip())
print("Sin espacios en ambos lados:", frase.strip())

    # Reemplazo de una palabra en la frase
palabra_a_buscar = input("\nPalabra a buscar: ")
palabra_nueva = input("Palabra nueva: ")
frase_modificada = frase.replace(palabra_a_buscar, palabra_nueva)
print("Frase modificada:", frase_modificada)

    # Carácter alfabéticamente mayor y menor
print("\n--- CARACTERES ---")
if len(frase) > 0:
    print("Carácter mayor:", max(frase))
    print("Carácter menor:", min(frase))
else:
    print("La frase está vacía, no se pueden obtener caracteres mayor y menor.")

    # Lista de palabras y número
print("\n--- LISTA DE PALABRAS ---")
palabras = frase.split()
print("Lista:", palabras)
print("Número de palabras:", len(palabras))

    # División del texto usando '/' como separador
print("\n--- DIVISIÓN POR '/' ---")
partes = frase.split("/")
print("Resultado del split('/'):", partes)

print("\n--- ANÁLISIS COMPLETO FINALIZADO ---")


