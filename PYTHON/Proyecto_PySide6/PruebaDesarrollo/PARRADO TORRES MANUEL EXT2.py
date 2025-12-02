import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QDialog, QInputDialog   
# Importar lo necesario


# ===================================================================
#                            LOGIN
# ===================================================================
class DialogoLogin(QDialog):
    def __init__(self, parent=None):
        super().__init__(parent)

        self.setWindowTitle("Iniciar sesión")

        # TODO: Crear el diseño y los widgets del diálogo de login


# ===================================================================
#                        VENTANA PRINCIPAL
# ===================================================================
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Encuesta de satisfacción")
        self.setMinimumSize(800, 600)

        # TODO: declarar variables necesarias

        self.crear_central()
        self.crear_acciones()
        self.crear_menus()
        self.crear_toolbar()
        self.crear_statusbar()
        self.crear_dock_notas()
        self.conectar_senales()

    # ---------------------------------------------------------------
    def crear_central(self):
        # TODO: Crear las pestañas, formularios y widgets
        pass

    # ---------------------------------------------------------------
    def crear_dock_notas(self):
        # TODO: Crear el dock inferior con un área de texto
        pass

    # ---------------------------------------------------------------
    def crear_acciones(self):
        # TODO: Crear las acciones del menú y la toolbar
        pass

    # ---------------------------------------------------------------
    def crear_menus(self):
        # TODO: Crear los menús y añadir las acciones
        pass

    # ---------------------------------------------------------------
    def crear_toolbar(self):
        # TODO: Crear la toolbar y añadir las acciones
        pass

    # ---------------------------------------------------------------
    def crear_statusbar(self):
        # TODO: Crear la barra de estado
        pass

    # ---------------------------------------------------------------
    def conectar_senales(self):
        # TODO: Conectar señales a los distintos slots
        pass

    # ---------------------------------------------------------------
    def slot_login(self):

        iniciasesion= nombre, contraseña = QInputDialog.getItem(
        self,
        "Iniciar sesion",
        "Nombre",
        "Contraseña"

    )

    if seleccionado:
        print(mes)        
        pass

    # ---------------------------------------------------------------
    def slot_nueva_encuesta(self):
        # TODO: Limpiar los datos tras confirmación
        pass

    # ---------------------------------------------------------------
    def slot_ver_resumen(self):
        # TODO: Mostrar un resumen de la encuesta
        pass

    # ---------------------------------------------------------------
    def slot_salir(self):
        # TODO: Confirmar y cerrar la aplicación
        pass

    # ---------------------------------------------------------------
    def slot_acerca_de(self):
        # TODO: Mostrar información sobre la aplicación
        pass

    # ---------------------------------------------------------------
    def slot_compania_cambiada(self, nueva):
        # TODO: Mensaje en la barra de estado
        pass

    # ---------------------------------------------------------------
    def slot_satisfaccion_cambiada(self, nueva):
        # TODO: Mensaje en la barra de estado
        pass

    # ---------------------------------------------------------------
    def slot_recomienda_cambiado(self, checked):
        # TODO: Mensaje en la barra de estado
        pass

    # ---------------------------------------------------------------
    def slot_nombre_cambiado(self, nuevo_nombre):
        # TODO: Actualizar el título de la ventana
        pass


# ===================================================================
#                       EJECUCIÓN DE LA APP
# ===================================================================
if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()

