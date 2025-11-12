from PySide6.QtWidgets import(
    QApplication,QMainWindow,QWidget,QVBoxLayout,QPushButton
)
class VentanaPrincipal (QMainWindow):
    def __init__ (self):
        super().__init__()
        self.setWindowTitle("Layout vertical")
        layout_vertical= QVBoxLayout()

        componente_principal= QWidget()
        componente_principal.setLayout(layout_vertical)
        self.setCentralWidget(componente_principal)

        layout_vertical.addWidget(QPushButton("Uno"))
        layout_vertical.addWidget(QPushButton("dos"))
        layout_vertical.addWidget(QPushButton("tres"))
        layout_vertical.addWidget(QPushButton("cuatro"))

app = QApplication([])
window= VentanaPrincipal()
window.show()
app.exec()
