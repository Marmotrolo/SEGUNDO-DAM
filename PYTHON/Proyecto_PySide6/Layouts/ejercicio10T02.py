from PySide6.QtWidgets import QApplication, QMainWindow
from PySide6.QtGui import QAction, QKeySequence

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana principal - Ejercicio 10 T02")

        # Crear barra de menú
        barra_menu = self.menuBar()

        # Crear menú "Archivo"
        menu_archivo = barra_menu.addMenu("&Archivo")

        # --- Acción 1: Mostrar mensaje ---
        accion_mostrar = QAction("Mostrar mensaje", self)
        accion_mostrar.setShortcut(QKeySequence("Ctrl+M"))
        accion_mostrar.triggered.connect(self.mostrar_mensaje)
        menu_archivo.addAction(accion_mostrar)

        # Añadir separador
        menu_archivo.addSeparator()

        # --- Acción 2: Cambiar título ---
        accion_cambiar = QAction("Cambiar título", self)
        accion_cambiar.setShortcut(QKeySequence("Ctrl+L"))
        accion_cambiar.triggered.connect(self.cambiar_titulo)
        menu_archivo.addAction(accion_cambiar)

        # Añadir separador
        menu_archivo.addSeparator()

        # --- Acción 3: Salir ---
        accion_salir = QAction("Salir", self)
        accion_salir.setShortcut(QKeySequence("Ctrl+Q"))
        accion_salir.triggered.connect(self.cerrar_aplicacion)
        menu_archivo.addAction(accion_salir)

    # Métodos asociados a las acciones
    def mostrar_mensaje(self):
        print("Hola desde el menú")

    def cambiar_titulo(self):
        self.setWindowTitle("Título cambiado desde el menú")

    def cerrar_aplicacion(self):
        self.close()


if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
