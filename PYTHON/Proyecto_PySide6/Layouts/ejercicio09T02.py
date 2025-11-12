#MANUEL PARRADO TORRES
from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QPushButton,
    QStackedLayout, QLabel, QVBoxLayout, QHBoxLayout
)
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Layout apilado")
        layout_principal = QHBoxLayout()
        componente_principal = QWidget()
        componente_principal.setLayout(layout_principal)
        self.setCentralWidget(componente_principal)
      

        # Creamos un layout vertical con tres botones
        # Cada botón hará visible una capa a través de la ranura
        layout_botones = QHBoxLayout()
        layout_botonesverticales = QVBoxLayout()

        boton1vertical = QPushButton("V1")
        boton2vertical = QPushButton("V2")
        boton3vertical = QPushButton("V3")
        boton4vertical = QPushButton("V4")


        boton1 = QPushButton("H1")
        boton2 = QPushButton("H2")
        boton3 = QPushButton("H3")
        boton4 = QPushButton("H4")

        layout_botonesverticales.addWidget(boton1vertical)
        layout_botonesverticales.addWidget(boton2vertical)
        layout_botonesverticales.addWidget(boton3vertical)
        layout_botonesverticales.addWidget(boton4vertical)


        layout_botones.addWidget(boton1)
        layout_botones.addWidget(boton2)
        layout_botones.addWidget(boton3)
        layout_botones.addWidget(boton4)

        # Añadimos los layouts al layout principal
        layout_principal.addLayout(layout_botonesverticales)

        layout_principal.addLayout(layout_botones)

    

app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()