from PySide6.QtWidgets import QApplication,QMainWindow , QWidget, QPushButton
from PySide6.QtCore import QSize


class VentanaPrincipal (QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi application")
        self.setFixedSize(1000,500)

class OtraVentana (QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Segunda vetana")

        boton= QPushButton("Púlsame")
        self.setCentralWidget(boton)        
        self.setMinimumSize(200,100)
        self.setMaximumSize(1200,900)

app = QApplication([])

window = VentanaPrincipal()
window2=OtraVentana()
window2.show()
window.show()  
app.exec()

