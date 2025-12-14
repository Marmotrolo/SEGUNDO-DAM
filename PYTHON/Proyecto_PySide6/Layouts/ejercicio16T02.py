#Manuel Parrado Torres
from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QVBoxLayout, QPushButton,
    QLabel, QFileDialog, QColorDialog, QFontDialog
)
from PySide6.QtGui import QFont


class EditorVentana(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Administrador de Texto y Estilos")

        # Contenedor principal
        contenedor = QWidget()
        self.setCentralWidget(contenedor)

        layout = QVBoxLayout()
        contenedor.setLayout(layout)

        # Zona de visualización del texto
        self.area_texto = QLabel("")
        self.area_texto.setStyleSheet("background-color: white; padding: 10px;")
        layout.addWidget(self.area_texto)

        # Botones
        boton_cargar = QPushButton("Cargar archivo")
        boton_guardar = QPushButton("Guardar como...")
        boton_fondo = QPushButton("Cambiar fondo")
        boton_fuente = QPushButton("Modificar fuente")

        layout.addWidget(boton_cargar)
        layout.addWidget(boton_guardar)
        layout.addWidget(boton_fondo)
        layout.addWidget(boton_fuente)

        # Conexiones
        boton_cargar.clicked.connect(self.cargar_archivo)
        boton_guardar.clicked.connect(self.guardar_archivo)
        boton_fondo.clicked.connect(self.cambiar_color)
        boton_fuente.clicked.connect(self.cambiar_fuente)

    # Funciones principales

    def cargar_archivo(self):
        ruta, _ = QFileDialog.getOpenFileName(
            self,
            "Abrir archivo",
            "",
            "Texto (*.txt)"
        )

        if ruta:
            with open(ruta, "r", encoding="utf-8") as archivo:
                contenido = archivo.read()
            self.area_texto.setText(contenido)

    def guardar_archivo(self):
        ruta, _ = QFileDialog.getSaveFileName(
            self,
            "Guardar archivo",
            "",
            "Texto (*.txt)"
        )

        if ruta:
            with open(ruta, "w", encoding="utf-8") as archivo:
                archivo.write(self.area_texto.text())

    def cambiar_color(self):
        color = QColorDialog.getColor()

        if color.isValid():
            estilo = "background-color: " + color.name() + "; padding: 10px;"
            self.area_texto.setStyleSheet(estilo)

    def cambiar_fuente(self):
        fuente, ok = QFontDialog.getFont()

        if ok:
            self.area_texto.setFont(fuente)


# Programa principal
if __name__ == "__main__":
    app = QApplication([])
    ventana = EditorVentana()
    ventana.show()
    app.exec()
