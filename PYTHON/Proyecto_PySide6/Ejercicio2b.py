#MANUEL PARRADO TORRES
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton


class VentanaPrincipal (QMainWindow):
    def __init__ (self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        self.boton= QPushButton("Púlsame ")
        self.boton.clicked.connect(self.cambia_titulo)
        self.boton.pressed.connect(self.cambia_texto_botonpulsado)
        self.boton.released.connect(self.cambia_texto_botonliberado)


        self.setCentralWidget(self.boton)

        
    def cambia_titulo(self,checked):
        if(checked):
            self.setWindowTitle("Ventana Encendida")
        else:
            self.setWindowTitle("Ventana apagada")

    def cambia_texto_botonpulsado(self):
        self.boton.setText("Sueltame ")
        print("Boton pulsado")


    def cambia_texto_botonliberado(self):
        self.boton.setText("Pulsame más")
        print("Boton liberado")


app = QApplication()
window= VentanaPrincipal()
window.show()
app.exec()