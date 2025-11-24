import os
import platform
import getpass
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtWidgets import QApplication, QMainWindow, QToolBar, QLabel, QStatusBar
from PySide6.QtCore import QTimer


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejercicio 12 - PySide6")

        # --- BARRA DE ESTADO ---
        self.status = QStatusBar()
        self.setStatusBar(self.status)

        # Mensaje inicial (2 segundos)
        self.status.showMessage("Aplicación iniciada correctamente", 2000)

        # Usuario permanente
        usuario = getpass.getuser()
        self.usuario_label = QLabel(f"Usuario: {usuario}")
        self.status.addPermanentWidget(self.usuario_label)

        # Mensajes alternados con QTimer
        self.mensajes = ["Esperando acción...", "Listo para trabajar"]
        self.index_mensaje = 0

        self.timer = QTimer()
        self.timer.timeout.connect(self.cambiar_mensaje)
        self.timer.start(4000)


        # --- MENÚ ---
        barra_menus = self.menuBar()
        menu = barra_menus.addMenu("&Archivo")

        ruta_icono = os.path.join(os.path.dirname(__file__), "console-log-icon.png")

        # Acción: Mostrar mensaje temporal
        self.accion_mostrar = QAction(QIcon(ruta_icono), "Mostrar mensaje temporal", self)
        self.accion_mostrar.setShortcut(QKeySequence("Ctrl+T"))
        self.accion_mostrar.triggered.connect(
            lambda: self.status.showMessage("Mensaje temporal: desaparece en 3 segundos", 3000)
        )

        # Acción: Limpiar mensaje
        self.accion_limpiar = QAction(QIcon(ruta_icono), "Limpiar mensaje", self)
        self.accion_limpiar.setShortcut(QKeySequence("Ctrl+L"))
        self.accion_limpiar.triggered.connect(self.status.clearMessage)

        # Acción: Mostrar información del sistema
        self.accion_sistema = QAction(QIcon(ruta_icono), "Mostrar información del sistema", self)
        self.accion_sistema.setShortcut(QKeySequence("Ctrl+I"))
        self.accion_sistema.triggered.connect(self.mostrar_sistema)

        # Añadir acciones al menú
        menu.addAction(self.accion_mostrar)
        menu.addAction(self.accion_limpiar)
        menu.addAction(self.accion_sistema)

        # --- BARRA DE HERRAMIENTAS ---
        barra_herramientas = QToolBar("Barra principal")
        barra_herramientas.addAction(self.accion_mostrar)
        barra_herramientas.addAction(self.accion_limpiar)
        barra_herramientas.addAction(self.accion_sistema)
        self.addToolBar(barra_herramientas)


    # --- MÉTODOS ACCIONES ---
    def mostrar_sistema(self):
        etiqueta = QLabel(f"Sistema: {platform.system()}")
        self.status.addWidget(etiqueta)

    def cambiar_mensaje(self):
        self.status.showMessage(self.mensajes[self.index_mensaje], 3000)
        self.index_mensaje = (self.index_mensaje + 1) % len(self.mensajes)


if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
