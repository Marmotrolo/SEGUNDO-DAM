import os
import platform
import getpass
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtWidgets import QApplication, QMainWindow, QToolBar, QLabel

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana con menú y barra de herramientas")

        # --- MENÚ ---
        barra_menus = self.menuBar()
        menu = barra_menus.addMenu("Archivo")

        # Ruta del icono
        ruta_icono = os.path.join(os.path.dirname(__file__), "impresora.png")

        # Acción con icono, texto y descripción
        accion = QAction(QIcon(ruta_icono), "Mostrar mensaje temporal", self)
        accion.setWhatsThis("Imprime un mensaje temporal al pulsar el botón o atajo") # Define un texto de ayuda que aparece si el usuario activa el modo What’s This? de Qt (atajo Shift + F1).
        accion.setShortcut(QKeySequence("Ctrl+P"))
        accion.triggered.connect(self.mensajetemporal)
        menu.addAction(accion)
        accion2 = QAction(QIcon(ruta_icono), "Limpiar mensaje", self)
        accion2.setWhatsThis("Borra mensaje de la barra") # Define un texto de ayuda que aparece si el usuario activa el modo What’s This? de Qt (atajo Shift + F1).
        accion2.setShortcut(QKeySequence("Ctrl+K"))
        accion2.triggered.connect(self.statusBar().clearMessage)
        menu.addAction(accion2)   
        accion3 = QAction(QIcon(ruta_icono), "Mostrar información del sistema", self)
        accion3.setWhatsThis("Muestra información del sistema") # Define un texto de ayuda que aparece si el usuario activa el modo What’s This? de Qt (atajo Shift + F1).
        accion3.setShortcut(QKeySequence("Ctrl+Q"))
        accion3.triggered.connect(self.mostrarsistema)
        menu.addAction(accion3)

        # --- BARRA DE HERRAMIENTAS ---
        barra_herramientas = QToolBar("Barra principal")
        barra_herramientas.addAction(accion) 
        barra_herramientas.addAction(accion2)
        barra_herramientas.addAction(accion3) 
 

         # Añadimos la misma acción
        self.addToolBar(barra_herramientas)

        barra_estado=self.statusBar()
        barra_estado.addPermanentWidget(QLabel(getpass.getuser()))


   
    def mensajetemporal(self):
        self.statusBar().showMessage("hola", 3000)
    def mostrarsistema(self):
        self.statusBar().addWidget(QLabel("Sistema: " + platform.system()))

if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()