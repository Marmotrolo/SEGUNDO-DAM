from PySide6.QtWidgets import QApplication, QMainWindow, QLineEdit


class VentanaPrincipal (QMainWindow):
    def __init__ (self):
        super().__init__()
        self.setWindowTitle("Hola mundo")

        self.texto= QLineEdit()

        self.texto.textChanged.connect(self.texto_modificado)

        self.setCentralWidget(self.texto)

    def texto_modificado(self):
        self.setWindowTitle(self.texto.text())

app=QApplication()
window=VentanaPrincipal()
window.show()
app.exec()