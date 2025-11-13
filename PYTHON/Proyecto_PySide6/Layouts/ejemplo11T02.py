import os
from PySide6.QtCore import Qt
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtWidgets import QApplication, QMainWindow, QToolBar

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana principal - Ejercicio 11 T02")

        # --- MENÚ PRINCIPAL ---
        barra_menus = self.menuBar()
        menu_archivo = barra_menus.addMenu("&Archivo")

        # Ruta de los iconos (usa cualquier icono .png en la misma carpeta)
        ruta_base = os.path.dirname(__file__)
        icono_mensaje = os.path.join(ruta_base, "icono_mensaje.png")
        icono_titulo = os.path.join(ruta_base, "icono_titulo.png")
        icono_desactivar = os.path.join(ruta_base, "icono_desactivar.png")
        icono_activar = os.path.join(ruta_base, "icono_activar.png")

        # --- ACCIÓN 1: Mostrar mensaje ---
        self.accion_mostrar = QAction(QIcon(icono_mensaje), "Mostrar mensaje", self)
        self.accion_mostrar.setShortcut(QKeySequence("Ctrl+M"))
        self.accion_mostrar.setWhatsThis("Muestra el texto 'Hola' en la consola")
        self.accion_mostrar.triggered.connect(self.mostrar_mensaje)

        # --- ACCIÓN 2: Cambiar título ---
        self.accion_titulo = QAction(QIcon(icono_titulo), "Cambiar título", self)
        self.accion_titulo.setShortcut(QKeySequence("Ctrl+L"))
        self.accion_titulo.setWhatsThis("Cambia el título de la ventana a 'Título cambiado'")
        self.accion_titulo.triggered.connect(self.cambiar_titulo)

        # --- ACCIÓN 3: Desactivar acciones ---
        self.accion_desactivar = QAction(QIcon(icono_desactivar), "Desactivar acciones", self)
        self.accion_desactivar.setShortcut(QKeySequence("Ctrl+D"))
        self.accion_desactivar.setWhatsThis("Desactiva las acciones de Mostrar mensaje y Cambiar título")
        self.accion_desactivar.triggered.connect(self.desactivar_acciones)

        # Añadimos las acciones al menú
        menu_archivo.addAction(self.accion_mostrar)
        menu_archivo.addAction(self.accion_titulo)
        menu_archivo.addSeparator()
        menu_archivo.addAction(self.accion_desactivar)

        # --- BARRA DE HERRAMIENTAS PRINCIPAL ---
        barra_principal = QToolBar("Barra principal")
        barra_principal.addAction(self.accion_mostrar)
        barra_principal.addAction(self.accion_titulo)
        barra_principal.addSeparator()
        barra_principal.addAction(self.accion_desactivar)

        # Estilo: texto debajo del icono
        barra_principal.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)

        self.addToolBar(barra_principal)

        # --- BARRA DE HERRAMIENTAS SECUNDARIA ---
        self.accion_activar = QAction(QIcon(icono_activar), "Activar acciones", self)
        self.accion_activar.setShortcut(QKeySequence("Ctrl+A"))
        self.accion_activar.setWhatsThis("Vuelve a activar las acciones desactivadas")
        self.accion_activar.triggered.connect(self.activar_acciones)

        barra_secundaria = QToolBar("Barra secundaria")
        barra_secundaria.addAction(self.accion_activar)
        barra_secundaria.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)

        self.addToolBar(barra_secundaria)

    # --- MÉTODOS DE ACCIÓN ---
    def mostrar_mensaje(self):
        print("Hola")

    def cambiar_titulo(self):
        self.setWindowTitle("Título cambiado")

    def desactivar_acciones(self):
        self.accion_mostrar.setEnabled(False)
        self.accion_titulo.setEnabled(False)

    def activar_acciones(self):
        self.accion_mostrar.setEnabled(True)
        self.accion_titulo.setEnabled(True)


if __name__ == "__main__":
    app = QApplication([])

    # Opcional: no mostrar iconos en los menús (mantiene los menús más limpios)
    # app.setAttribute(Qt.AA_DontShowIconsInMenus)

    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
