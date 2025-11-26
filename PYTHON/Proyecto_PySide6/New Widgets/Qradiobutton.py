#MANUEL PARRADO TORRES
# Este widget se usa para permitir al usuario seleccionar una opción, aunque en este ejemplo funciona como un interruptor simple de activación/desactivación. Se implementó conectando la señal toggled del botón a un método que actualiza el título de la ventana para reflejar el estado (ACTIVADA/DESACTIVADA).
from PySide6.QtWidgets import QApplication, QMainWindow, QRadioButton

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Función DESACTIVADA")

        self.radio = QRadioButton("Activar función")

        self.radio.toggled.connect(self.cambiar_estado)

        self.setCentralWidget(self.radio)

    def cambiar_estado(self, checked):
        if checked:
            self.setWindowTitle("Función ACTIVADA")
        else:
            self.setWindowTitle("Función DESACTIVADA")
        print(checked)


app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()
