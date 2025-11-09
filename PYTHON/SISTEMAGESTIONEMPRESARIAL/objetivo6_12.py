#MANUEL PARRADO TORRES


class Autor:
    def __init__(self, nombre, apellidos):
        self.nombre = nombre
        self.apellidos = apellidos

    def mostrarAutor(self):
        print("Autor: ", self.nombre, self.apellidos)

class Libro:
    def __init__(self, titulo, isbn):
        self.titulo = titulo
        self.isbn = isbn
        self.autor = None
    
    def aniadirAutor(self, autor):
        self.autor = autor

    def mostrarLibro(self):
        print("------ Libro ------")
        print("Título: ", self.titulo)
        print("ISBN: ", self.isbn)
        autor.mostrarAutor()
    
    def obtenerTitulo(self):
        return self.titulo
    
class Biblioteca:
    def __init__(self):
        self.listaLibros = []

    def numeroLibros(self):
        return len(self.listaLibros)
    
    def añadirLibro(self, libro):
        return self.listaLibros.append(libro)
    
    def deletelibro(self, titulo):
        for libro in self.listaLibros:
            if libro.titulo == titulo:
                self.listaLibros.remove(libro)
    
    def mostrarBiblioteca(self):
        for libro in self.listaLibros:
            print(libro.mostrarLibro())



def menu():
    print("Menu")
    print("1) Añadir libro")
    print("2) Mostrar biblioteca")
    print("3) Borrar libro")
    print("4) Consultar número de libros")
    print("5) Salir")

biblioteca = Biblioteca()
salir = False

while not salir:
    menu()

    opcion = int(input("Elige que operacion deseas realizar: "))

    if opcion == 1:
        titulo = input("Introduzca el título del libro: ")
        isbn = input("Introduzca el ISBN del libro: ")
        nombre = input("Introduzca el nombre del autor: ")
        apellido = input("Introduzca el apellido del autor: ")

        autor = Autor(nombre, apellido)
        libro = Libro(titulo, isbn)
        libro.aniadirAutor(autor)

        biblioteca.añadirLibro(libro)
    
    elif opcion == 2:
        biblioteca.mostrarBiblioteca()
        

    elif opcion == 3:
        borrar = input("Introduzca el título del libro a borrar: ")
        print("¡Libro borrado correctamente!", biblioteca.deletelibro(borrar))

    elif opcion == 4:
        print("El número de libros en la biblioteca es: ", biblioteca.numeroLibros())
    
    elif opcion == 5:
        salir = True
        print("Programa finalizado ;)")