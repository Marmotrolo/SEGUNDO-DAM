# MANUEL PARRADO TORRES
#Este widget se usa para organizar contenido en pestañas dentro de una misma ventana, mejorando la navegación. Se implementó añadiendo tres pestañas con contenido simple y conectando la señal currentChanged(int) para que el título de la ventana refleje la pestaña activa.
from PySide6.QtWidgets import QApplication, QMainWindow, QTabWidget, QWidget, QLabel

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Pestaña 1")
        self.setGeometry(100, 100, 400, 300)

        self.tabs = QTabWidget()
        self.tabs.currentChanged.connect(self.cambio_pestaña)

        pestaña1 = QWidget()
        QLabel("Bienvenido",  pestaña1)
        
        pestaña2 = QWidget()
        QLabel("Segunda pestaña",  pestaña2)

        pestaña3 = QWidget()
        QLabel("Tercera pestaña", pestaña3)

        self.tabs.addTab( pestaña1, "Pestaña 1")
        self.tabs.addTab( pestaña2, "Pestaña 2")
        self.tabs.addTab( pestaña3, "Pestaña 3")

        self.setCentralWidget(self.tabs)

    def cambio_pestaña(self, s):
        nombre = self.tabs.tabText(s)
        print("Índice seleccionado: " + str(s))
        self.setWindowTitle(nombre)

app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()