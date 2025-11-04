    #MANUEL PARRADO TORRES
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton


class VentanaPrincipal (QMainWindow):
    def __init__ (self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        boton= QPushButton("Púlsame ")
        boton.setCheckable(True)
        boton.clicked.connect(self.el_boton_fue_pulsado)
        boton.clicked.connect(self.el_boton_esta_on)
        boton.clicked.connect(self.cambia_titulo)

        self.setCentralWidget(boton)


    def el_boton_fue_pulsado(self):
        print("Púlsado")
    
    def el_boton_esta_on(self,checked):
        print("Está ON? ", checked)
        
    def cambia_titulo(self,checked):
        if(checked):
            self.setWindowTitle("Ventana Encendida")
        else:
            self.setWindowTitle("Ventana apagada")


    
app = QApplication()
window= VentanaPrincipal()
window.show()
app.exec()