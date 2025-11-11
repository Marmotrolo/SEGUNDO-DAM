#MANUEL PARRADO TORES
# Este widget se usa para permitir al usuario seleccionar y editar valores de fecha y hora. Se implementó configurando un formato de visualización específico setDisplayFormat y conectando la señal dateTimeChanged() para que el título de la ventana se actualice automáticamente con la nueva fecha y hora seleccionada.
from PySide6.QtWidgets import QApplication, QMainWindow, QDateTimeEdit
from PySide6.QtCore import QDateTime

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QDateTimeEdit")

        self.fechaeditar = QDateTimeEdit()
        self.fechaeditar.setDateTime(QDateTime.currentDateTime())
        self.fechaeditar.setDisplayFormat("dddd, d 'de' MMMM 'de' yyyy hh:mm")
        
        self.fechaeditar.dateTimeChanged.connect(self.fecha_hora_modificada)

        self.setCentralWidget(self.fechaeditar)

    def fecha_hora_modificada(self, s):
        fecha = s.toString("dddd, d 'de' MMMM 'de' yyyy hh:mm")
        print("Fecha elegida: " + fecha)
        self.setWindowTitle(fecha)

app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()
