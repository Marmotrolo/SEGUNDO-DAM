# ------------------------------------------------------------
# Nombre: [Tu Nombre y Apellidos]
# Grupo: [Tu Grupo]
# Archivo: objetivo4_fase123.py
# Descripción:
# Programa que gestiona las notas de varios alumnos, calcula sus medias,
# determina si aprueban o suspenden, y muestra un resumen final del grupo.
# ------------------------------------------------------------

# FASE 1-2-3: Gestor de notas con medias, validaciones y resumen

# Pedimos el número de alumnos, validando que sea mayor que 0
while True:
    try:
        num_alumnos = int(input("Introduce el número de alumnos: "))
        if num_alumnos > 0:
            break
        else:
            print("El número de alumnos debe ser mayor que 0.")
    except ValueError:
        print("Por favor, introduce un número entero válido.")

# Inicializamos listas y contadores para el resumen final
suma_medias = 0
aprobados = 0
necesita_mejorar = 0
suspensos = 0

# Recorremos cada alumno
for i in range(1, num_alumnos + 1):
    print("\nAlumno", i)
    nombre = input("Nombre: ")

    # Validamos el número de notas
    while True:
        try:
            num_notas = int(input("¿Cuántas notas tiene " + nombre + "? "))
            if num_notas > 0:
                break
            else:
                print("Debe tener al menos una nota.")
        except ValueError:
            print("Por favor, introduce un número entero válido.")

    # Recogemos las notas del alumno
    notas = []
    for j in range(1, num_notas + 1):
        while True:
            try:
                nota = float(input("Introduce la nota " + str(j) + ": "))
                if 0 <= nota <= 10:
                    notas.append(nota)
                    break
                else:
                    print("La nota debe estar entre 0 y 10.")
            except ValueError:
                print("Introduce un número válido (por ejemplo, 7.5).")

    # Calculamos la media del alumno
    media = sum(notas) / len(notas)
    suma_medias += media  # sumamos para calcular la media del grupo después

    # Determinamos el resultado según la media
    if media >= 5:
        estado = "Aprobado"
        aprobados += 1
    elif 4 <= media < 5:
        estado = "Necesita mejorar"
        necesita_mejorar += 1
    else:
        estado = "Suspenso"
        suspensos += 1

    # Mostramos el resultado del alumno
    print("Media de", nombre, ":", round(media, 2), "->", estado)

# Calculamos la media general del grupo
media_grupo = suma_medias / num_alumnos

# Mostramos el resumen final
print("\n--- RESUMEN FINAL ---")
print("Media del grupo:", round(media_grupo, 2))
print("Aprobados:", aprobados)
print("Necesita mejorar:", necesita_mejorar)
print("Suspensos:", suspensos)
