from PySide6.QtWidgets import QApplication, QMainWindow, QLineEdit

class VentanaPrincipal (QMainWindow):
    def __init__ (self):
        super().__init__()
        self.setWindowTitle("QLineEdit")
        texto= QLineEdit()
        texto.setMaxLength(20)
        texto.setPlaceholderText("Introduce tu nombre")

        texto.returnPressed.connect(self.mostrar_mensaje)

        texto.textChanged.connect(self.texto_modificado)
        texto.textEdited.connect(self.texto_editado)

        self.setCentralWidget(texto)

        self.texto=texto

    def mostrar_mensaje(self):
        print("Se pulsó enter")
        self.texto.setText("Sin ciudad")
    
    def texto_modificado(self,s):
        print("Texto modificado", s)
    def texto_editado(self,s):
        print("Texto editado", s)
        self.setWindowTitle(s)


app = QApplication()
window= VentanaPrincipal()
window.show()
app.exec()
