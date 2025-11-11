# MANUEL PARRADO TORRES
# Este widget se usa para permitir al usuario seleccionar un numero dentro de un rango, ideal para ajustes como volumen o brillo. Se implementó estableciendo un rango de 0 a 100 y conectando la señal valueChanged() para que, al mover la barra, el valor se muestre inmediatamente en la consola y se vea en el título de la ventana.
from PySide6.QtWidgets import QApplication, QMainWindow, QSlider
from PySide6.QtCore import Qt

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QSlider Brillo")

        self.barra = QSlider(Qt.Orientation.Horizontal)
        self.barra.setRange(0, 100)
        self.barra.setValue(50)
        
        self.barra.valueChanged.connect(self.valor_modificado)
        
        self.valor_modificado(self.barra.value())

        self.setCentralWidget(self.barra)

    def valor_modificado(self, valor):
        mensaje = "Nivel de brillo: " + str(valor) + "%"
        print(mensaje)
        self.setWindowTitle(mensaje)

app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()
