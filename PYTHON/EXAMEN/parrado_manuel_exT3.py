import sys
import os
from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QMainWindow,
    QVBoxLayout,
    QPushButton, QLabel
)
from PySide6.QtGui import QPainter, QColor, QPen, QPalette
from PySide6.QtCore import QRect, Qt, Signal


class IndicadorIncidencias(QWidget):
    def __init__(self):
        super().__init__()
        self.color=QColor("White")
        self._texto = "OK"
        
    def setTexto(self, texto):
        self._texto = texto
        # update() avisa a Qt de que debe volver a dibujar el widget.
        self.update()

    def paintEvent(self, event):
        # QPainter es el objeto que permite dibujar dentro del widget.
        painter = QPainter(self)

        # Activamos el suavizado de bordes para evitar formas “dentadas”.
        painter.setRenderHint(QPainter.Antialiasing)

        # Configuramos el color de relleno del círculo
        painter.setBrush(self.color)

        # Borde del círculo en color negro.
        painter.setPen(QPen(Qt.black))

        # Calculamos el tamaño máximo posible de un cuadrado dentro del widget.
        # Esto asegura que el círculo no se deforme aunque el widget no sea cuadrado.
        lado = min(self.width(), self.height())

        # Creamos un rectángulo cuadrado, centrado en el widget.
        recto = QRect(
            (self.width() - lado) // 2,   # posición X centrada
            (self.height() - lado) // 2,  # posición Y centrada
            lado,                         # ancho del cuadrado
            lado                          # alto del cuadrado
        )

        # Dibujamos el círculo dentro del rectángulo calculado.
        painter.drawEllipse(recto)

        painter.setPen(QPen(Qt.black))

        # Dibujamos el texto centrado dentro del círculo mediante AlignCenter.
        painter.drawText(recto, Qt.AlignCenter, self._texto)

    def cambiacolor(self,cantidad):
        if cantidad >0 and cantidad <3:
            self.color="Green"
        elif cantidad>4 and cantidad<7:
            self.color="Yellow"       
        elif cantidad >8 :
           self.color="Red" 
        self.update()
    def reiniciar (self,cantidad):
        cantidad=0
        self.color="White"

        
class BotonSumaIndicente(QPushButton):
    incidencias= Signal(int)
    
    def __init__(self, parent= None):
        super().__init__("Añade incidencia")
        self.__contador=0

        self.clicked.connect(self.__incrementar)
    def __incrementar(self):
        # Actualizamos el contador interno
        self.__contador = self.__contador + 1

        # Emitimos la señal con el nuevo valor
        self.incidencias.emit(self.__contador)
    def contador(self):
        return self.__contador

class EtiquetaContadorIncidencias(QLabel):
    def __init__(self, parent = None):
        super().__init__("Incidencias abiertas: ", parent)

    def actualizar_contador(self, cantidad):
        
        #cambia el texto del QLabel
        self.setText("Incidencias abiertas: " + str(cantidad) )

        

class Reset(QPushButton):
    reset = Signal()
    def __init__(self, parent = None):
        super().__init__("Reset", parent)
       
    def reiniciar(self,cantidad):
        self.color= "White"
        self.text
        self.reset.emit()
        self.update()


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        ruta_estilo= os.path.join(os.path.dirname(__file__), "parrado_manuel_estilos.qss")
        with open(ruta_estilo, "r") as f:
            app.setStyleSheet(f.read())

        self.setWindowTitle("Añadir Incidencias")
        self.resize(500, 400)

        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        self.indicador = IndicadorIncidencias()
        self.boton = BotonSumaIndicente("Añade Incidencia")
        self.etiqueta = EtiquetaContadorIncidencias()
        self.etiqueta.setAutoFillBackground(True)
        self.botonreiniciar= Reset()
        self.boton.incidencias.connect(self.etiqueta.actualizar_contador)
        self.boton.incidencias.connect(self.indicador.cambiacolor)






        

        layout.addWidget(self.indicador)
        layout.addWidget(self.etiqueta)
        layout.addWidget(self.boton)
        layout.addWidget(self.botonreiniciar)

        contenedor.setLayout(layout)
       
       
        self.setCentralWidget(contenedor)


    

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()

  