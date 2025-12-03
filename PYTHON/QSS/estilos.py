from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QLabel,
    QLineEdit,
    QPushButton,
    QCheckBox,
    QComboBox,
    QRadioButton
)


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        with open("estilo.qss", "r") as f:
            app.setStyleSheet(f.read())
        self.setWindowTitle("Ejemplo de QSS")

        self.cajacheck = QCheckBox("Checkealo")
        self.boton = QPushButton("Pulsa")
        


        self.nombre = QLineEdit()
        self.nombre.setPlaceholderText("Nombre")
        self.crudo = QRadioButton("Crudo")
        self.crudo = QRadioButton("Frito")
        self.crudo = QRadioButton("Rotos")

        self.combobox= QComboBox()
        self.combobox.addItems(["Crudo", "Frito", "Rotos"])

        layout = QVBoxLayout()
        layout.addStretch() 
        layout.addWidget(QLabel("CHECKBOX"))
        layout.addWidget(self.cajacheck)
        layout.addSpacing(30)

        layout.addWidget(QLabel("BOTON"))

        layout.addWidget(self.boton)
        layout.addSpacing(30)
        layout.addWidget(QLabel("ENTRADA DE TEXTO"))

        layout.addWidget(self.nombre)
        layout.addSpacing(30)
        layout.addWidget(QLabel("COMBO BOX"))

        layout.addWidget(self.combobox)
        layout.addSpacing(30)
        layout.addWidget(QLabel("RADIO BUTTON"))

        layout.addWidget(self.crudo)
        
        layout.addStretch()

        contenedor = QWidget()
        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)


     

app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
