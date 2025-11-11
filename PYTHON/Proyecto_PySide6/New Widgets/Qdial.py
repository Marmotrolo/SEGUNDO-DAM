# MANUEL PARRADO TORRES
# Este widget (QDial) se usa como un control giratorio.Se implementó con rango 0-10, a señal 'valueChanged' actualiza el título de la ventana con el nivel de volumen y muestra un mensaje en consola al alcanzar el valor máximo (10).
from PySide6.QtWidgets import QApplication, QMainWindow, QDial

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Volumen: 2 / 10")

        self.rueda = QDial()
        self.rueda.setRange(0, 10)
        self.rueda.setValue(2)
        self.rueda.setNotchesVisible(True)
        
        self.rueda.valueChanged.connect(self.valor_modificado)
        
        self.valor_modificado(self.rueda.value())

        self.setCentralWidget(self.rueda)

    def valor_modificado(self, valor):
        titulo = "Volumen: " + str(valor) + " / 10"
        self.setWindowTitle(titulo)
        
        if valor == 10:
            print("¡Volumen máximo alcanzado!")

app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()