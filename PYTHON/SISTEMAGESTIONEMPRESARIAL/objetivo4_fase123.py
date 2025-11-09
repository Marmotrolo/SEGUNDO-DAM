
#MANUEL PARRADO TORRES
#Pequeño gestor de notas que registre las calificaciones de varios alumnos, calcule sus medias y determine si aprueban o suspenden.
while True:
    try:
        num_alumnos = int(input("Introduce el número de alumnos: "))
        if num_alumnos > 0:
            break
        else:
            print("El número de alumnos debe ser mayor que 0.")
    except ValueError:
        print("Por favor, introduce un número entero válido.")

suma_medias = 0
aprobados = 0
necesita_mejorar = 0
suspensos = 0

for i in range(1, num_alumnos + 1):
    print("\nAlumno", i)
    nombre = input("Nombre: ")

    while True:
        try:
            num_notas = int(input("¿Cuántas notas tiene " + nombre + "? "))
            if num_notas > 0:
                break
            else:
                print("Debe tener al menos una nota.")
        except ValueError:
            print("Por favor, introduce un número entero válido.")

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

    media = sum(notas) / len(notas)
    suma_medias += media  

    if media >= 5:
        estado = "Aprobado"
        aprobados += 1
    elif 4 <= media < 5:
        estado = "Necesita mejorar"
        necesita_mejorar += 1
    else:
        estado = "Suspenso"
        suspensos += 1

    print("Media de", nombre, ":", round(media, 2), "->", estado)

media_grupo = suma_medias / num_alumnos

print("\n--- RESUMEN FINAL ---")
print("Media del grupo:", round(media_grupo, 2))
print("Aprobados:", aprobados)
print("Necesita mejorar:", necesita_mejorar)
print("Suspensos:", suspensos)
