# ============================================================
# Nombre: [Tu Nombre Aquí]
# Apellidos: [Tus Apellidos Aquí]
# Grupo: [Tu Grupo Aquí]
# Archivo: objetivo6_fase12.py
# Descripción: Programa que simula la gestión de una biblioteca
#              usando clases, objetos y métodos en Python.
# ============================================================

# ------------------------------------------------------------
# CLASE AUTOR
# ------------------------------------------------------------
class Autor:
    """Representa al autor de un libro."""

    def __init__(self, nombre, apellidos):
        self.nombre = nombre
        self.apellidos = apellidos

    def mostrar_autor(self):
        """Muestra el nombre completo del autor."""
        return f"{self.nombre} {self.apellidos}"


# ------------------------------------------------------------
# CLASE LIBRO
# ------------------------------------------------------------
class Libro:
    """Representa un libro con título, ISBN y autor."""

    def __init__(self, titulo, isbn):
        self.titulo = titulo
        self.isbn = isbn
        self.autor = None  # Se asociará después con un objeto Autor

    def añadir_autor(self, autor):
        """Asocia un autor al libro."""
        self.autor = autor

    def mostrar_libro(self):
        """Muestra toda la información del libro."""
        if self.autor:
            print(f"Título: {self.titulo} | ISBN: {self.isbn} | Autor: {self.autor.mostrar_autor()}")
        else:
            print(f"Título: {self.titulo} | ISBN: {self.isbn} | Autor: No asignado")

    def obtener_titulo(self):
        """Devuelve el título del libro."""
        return self.titulo


# ------------------------------------------------------------
# CLASE BIBLIOTECA
# ------------------------------------------------------------
class Biblioteca:
    """Representa una colección de libros."""

    def __init__(self):
        self.lista_libros = []  # Lista que almacenará los objetos Libro

    def numero_libros(self):
        """Devuelve el número de libros en la biblioteca."""
        return len(self.lista_libros)

    def añadir_libro(self, libro):
        """Agrega un libro nuevo a la biblioteca."""
        self.lista_libros.append(libro)
        print("✅ Libro añadido correctamente.")

    def borrar_libro(self, titulo):
        """Elimina un libro a partir de su título."""
        for libro in self.lista_libros:
            if libro.obtener_titulo().lower() == titulo.lower():
                self.lista_libros.remove(libro)
                print("🗑️ Libro eliminado correctamente.")
                return
        print("❌ No se encontró un libro con ese título.")

    def mostrar_biblioteca(self):
        """Muestra todos los libros registrados."""
        if not self.lista_libros:
            print("📚 La biblioteca está vacía.")
        else:
            print("\n--- Libros en la biblioteca ---")
            for libro in self.lista_libros:
                libro.mostrar_libro()


# ------------------------------------------------------------
# FUNCIONES AUXILIARES
# ------------------------------------------------------------

def mostrar_menu():
    """Muestra las opciones del menú principal."""
    print("\nMenú")
    print("1) Añadir libro a la biblioteca")
    print("2) Mostrar biblioteca")
    print("3) Borrar libro")
    print("4) ¿Número de libros?")
    print("5) Salir")


def añadir_libro_a_biblioteca(biblioteca):
    """Permite introducir un nuevo libro y añadirlo a la biblioteca."""
    titulo = input("Introduzca el título del libro: ")
    isbn = input("Introduzca el ISBN del libro: ")
    nombre_autor = input("Introduzca el nombre del autor: ")
    apellidos_autor = input("Introduzca el apellido del autor: ")

    autor = Autor(nombre_autor, apellidos_autor)
    libro = Libro(titulo, isbn)
    libro.añadir_autor(autor)

    biblioteca.añadir_libro(libro)


def borrar_libro_de_biblioteca(biblioteca):
    """Elimina un libro de la biblioteca según su título."""
    titulo = input("Introduzca el título del libro que desea borrar: ")
    biblioteca.borrar_libro(titulo)


def mostrar_numero_libros(biblioteca):
    """Muestra cuántos libros hay actualmente en la biblioteca."""
    print(f"El número de libros en la biblioteca es: {biblioteca.numero_libros()}")


# ------------------------------------------------------------
# PROGRAMA PRINCIPAL
# ------------------------------------------------------------
def main():
    """Controla el flujo principal del programa."""
    biblioteca = Biblioteca()

    while True:
        mostrar_menu()
        opcion = input("Seleccione opción: ")

        if opcion == "1":
            añadir_libro_a_biblioteca(biblioteca)
        elif opcion == "2":
            biblioteca.mostrar_biblioteca()
        elif opcion == "3":
            borrar_libro_de_biblioteca(biblioteca)
        elif opcion == "4":
            mostrar_numero_libros(biblioteca)
        elif opcion == "5":
            print("👋 Fin del programa. ¡Hasta pronto!")
            break
        else:
            print("❌ Opción no válida. Intente de nuevo.")



main()
