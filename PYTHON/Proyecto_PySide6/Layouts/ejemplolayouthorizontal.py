from PySide6.QtWidgets import(
    QApplication,QMainWindow,QWidget,QVBoxLayout,QHBoxLayout,QPushButton
)
class VentanaPrincipal (QMainWindow):
    def __init__ (self):
        super().__init__()
        self.setWindowTitle("Layout horizontal")
        layout_horizontal= QHBoxLayout()

        componente_principal= QWidget()
        componente_principal.setLayout(layout_horizontal)
        self.setCentralWidget(componente_principal)

        layout_horizontal.addWidget(QPushButton("Uno"))
        layout_horizontal.addWidget(QPushButton("dos"))
        layout_horizontal.addWidget(QPushButton("tres"))
        layout_horizontal.addWidget(QPushButton("cuatro"))

app = QApplication([])
window= VentanaPrincipal()
window.show()
app.exec()
