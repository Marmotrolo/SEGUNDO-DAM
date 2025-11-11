#MANUEL PARRADO TORRES
# Este widget se usa para mostrar visualmente el avance de una tarea utilizando QTimer para solicitar al usuario, cada 2 segundos a través de la consola, si desea aumentar o disminuir el progreso. La barra se actualiza con 'setValue()' y el título de la ventana refleja el porcentaje.
from PySide6.QtWidgets import QApplication, QMainWindow, QProgressBar
from PySide6.QtCore import QTimer

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.progreso_actual = 0
        self.setWindowTitle("Progreso: 0%")

        self.barra = QProgressBar()
        self.barra.setRange(0, 100)
        self.barra.setValue(self.progreso_actual)
        self.setCentralWidget(self.barra)

        self.temporizador= QTimer(self)
        self.temporizador.timeout.connect(self.menu_consola)
        self.temporizador.start(2000)

    def menu_consola(self):
        print("\n1 Aumentar   2 Disminuir   0 Salir")
        opcion = input("Opción: ")

        if opcion == "1":
            self.cambiar_progreso("aumentar")
        elif opcion == "2":
            self.cambiar_progreso("disminuir")
        elif opcion == "0":
            self.temporizador.stop()
            self.close()

    def cambiar_progreso(self, modo):
        if modo == "aumentar":
            self.progreso_actual = min(100, self.progreso_actual + 20)
        elif modo == "disminuir":
            self.progreso_actual = max(0, self.progreso_actual - 20)

        self.barra.setValue(self.progreso_actual)

        if self.progreso_actual == 100:
            self.setWindowTitle("Tarea completada")
        else:
            self.setWindowTitle("Progreso: " + str(self.progreso_actual) + "%")

app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()
