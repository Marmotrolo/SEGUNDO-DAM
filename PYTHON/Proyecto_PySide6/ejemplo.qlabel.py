#MANUEL PARRADO TORRES

from PySide6.QtWidgets import QApplication, QMainWindow, QLabel
from PySide6.QtCore import Qt
class Ventanapricipal(QMainWindow):
    def  __init__(self):
        super().__init__()

        self.setWindowTitle("Mia pliacion")
        sistema= QLabel("Sistema en espera")
        fuente = sistema.font()
        fuente.setPointSize(24)

        sistema.setFont(fuente)

        sistema.setAlignment(Qt.AlignHCenter | Qt.AlignVCenter)

        self.setCentralWidget(sistema)
        sistema.setText("Sistema operativo iniciado")

app=QApplication()
window=Ventanapricipal()
window.show()
app.exec()
    