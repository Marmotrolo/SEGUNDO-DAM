#Manuel Parrado Torres
from PySide6.QtWidgets import (
    QApplication, QMainWindow, QPushButton, QMessageBox
)


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Gestión de tareas")

        boton = QPushButton("Gestionar tarea")
        boton.clicked.connect(self.gestionar_tarea)
        self.setCentralWidget(boton)

    def gestionar_tarea(self):
        respuesta = QMessageBox.question(
            self,
            "Tarea",
            "¿Qué quieres hacer?",
            QMessageBox.Yes | QMessageBox.No | QMessageBox.Ignore,
            QMessageBox.Ignore  
        )

        if respuesta == QMessageBox.Yes:
            QMessageBox.information(self, "Resultado", "Completada.")
        elif respuesta == QMessageBox.No:
            QMessageBox.information(self, "Resultado", "Pospuesto para más tarde.")
        else:  
            QMessageBox.information(self, "Resultado", "Sin cambios.")


app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()