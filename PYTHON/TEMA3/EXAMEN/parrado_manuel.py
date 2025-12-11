


import sys
import os
from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QMainWindow,
    QVBoxLayout,
    QPushButton,
    QLabel
)
from PySide6.QtGui import QPainter, QColor, QPen, QPalette
from PySide6.QtCore import QRect, Qt, Signal


class IndicadorIncidencias(QWidget):
    def __init__(self):
        super().__init__()
        self._texto = "OK"
        self._color = QColor("White")
        # Tamaño mínimo de 120x120 píxeles
        self.setMinimumSize(120, 120)
        
    def setTexto(self, texto):
        self._texto = texto
        self.update()
    
    def setColor(self, color):
        self._color = color
        self.update()

    def paintEvent(self, event):
        painter = QPainter(self)
        painter.setRenderHint(QPainter.Antialiasing)

        # Color de relleno del círculo
        painter.setBrush(self._color)
        
        # Borde del círculo en negro
        painter.setPen(QPen(Qt.black, 2))

        # Calculamos un cuadrado centrado
        lado = min(self.width(), self.height())
        recto = QRect(
            (self.width() - lado) // 2,
            (self.height() - lado) // 2,
            lado,
            lado
        )

        # Dibujamos el círculo
        painter.drawEllipse(recto)

        # Dibujamos el texto centrado
        painter.setPen(QPen(Qt.black))
        painter.drawText(recto, Qt.AlignCenter, self._texto)


class BotonSumaIncidente(QPushButton):
    # Señal personalizada que envía el contador
    incidencias = Signal(int)
    
    def __init__(self, parent=None):
        super().__init__("Añadir incidencia", parent)
        self.__contador = 0
        # Conectamos el click a nuestro método
        self.clicked.connect(self.__incrementar)
    
    def __incrementar(self):
        self.__contador = self.__contador + 1
        self.incidencias.emit(self.__contador)
    
    def contador(self):
        return self.__contador
    
    def reset(self):
        self.__contador = 0


class EtiquetaContadorIncidencias(QLabel):
    def __init__(self, parent=None):
        super().__init__("Incidencias abiertas: 0", parent)
        # Necesario para que se vea el color de fondo
        self.setAutoFillBackground(True)

    def actualizar_contador(self, cantidad):
        # Actualizamos el texto
        self.setText("Incidencias abiertas: "+ str(cantidad))

     


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        
        ruta_estilo = os.path.join(os.path.dirname(__file__), "parrado_manuel_estilos.qss")
        if os.path.exists(ruta_estilo):
            with open(ruta_estilo, "r") as f:
                app.setStyleSheet(f.read())

        self.setWindowTitle("Añadir Incidencias")
        self.resize(500, 400)

        # Contenedor central
        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        # Creamos los widgets
        self.indicador = IndicadorIncidencias()
        self.etiqueta = EtiquetaContadorIncidencias()
        self.boton = BotonSumaIncidente()
        self.boton_reiniciar = QPushButton("Reset")

        # Conectamos señales
        self.boton.incidencias.connect(self.actualizar_interfaz)
        self.boton_reiniciar.clicked.connect(self.reset)

        # Añadimos widgets al layout
        layout.addWidget(self.indicador)
        layout.addWidget(self.etiqueta)
        layout.addWidget(self.boton)
        layout.addWidget(self.boton_reiniciar)

        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)

    def actualizar_interfaz(self, cantidad):
        # Actualizamos la etiqueta
        self.etiqueta.actualizar_contador(cantidad)
        
        # Actualizamos el indicador con el color y texto correspondiente
        if cantidad == 0:
            self.indicador.setColor(QColor("White"))
            self.indicador.setTexto("OK")
        elif cantidad >= 1 and cantidad <= 3:
            self.indicador.setColor(QColor("Green"))
            self.indicador.setTexto("OK")
        elif cantidad >= 4 and cantidad <= 7:
            self.indicador.setColor(QColor("Yellow"))
            self.indicador.setTexto("AVISO")
        elif cantidad >= 8:
            self.indicador.setColor(QColor("Red"))
            self.indicador.setTexto("ERROR")

    def reset(self):
        # Reiniciamos el contador del botón
        self.boton.reset()
        
        # Reiniciamos el indicador
        self.indicador.setColor(QColor("White"))
        self.indicador.setTexto("OK")
        
        # Reiniciamos la etiqueta
        self.etiqueta.setText("Incidencias abiertas: 0")
        paleta = self.etiqueta.palette()
        paleta.setColor(QPalette.Window, QColor("White"))
        self.etiqueta.setPalette(paleta)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
