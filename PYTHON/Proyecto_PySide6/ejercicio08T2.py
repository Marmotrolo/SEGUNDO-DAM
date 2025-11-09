from PySide6.QtWidgets import QApplication, QMainWindow, QTextEdit

class VentanaPrincipal (QMainWindow):
    def __init__ (self):
        super().__init__()
        self.setWindowTitle("QLineEdit")
        texto= QLineEdit()
        texto.setMaxLength(20)
        texto.setPlaceholderText("Introduce tu nombre")