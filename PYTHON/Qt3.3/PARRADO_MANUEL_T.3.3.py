import sys
from PySide6.QtWidgets import QApplication, QWidget, QMainWindow, QVBoxLayout, QPushButton
from PySide6.QtGui import QPainter, QColor, QPen, QBrush
from PySide6.QtCore import QRect, Qt

class IndicadorSemaforoSuperSimple(QWidget):
    # Configuración de Colores 
    
    ORDEN_ESTADOS = ["ROJO", "AMARILLO", "VERDE"]
    COLORES_LUZ = {
        "ROJO": QColor(255, 0, 0),
        "AMARILLO": QColor(255, 255, 0),
        "VERDE": QColor(0, 255, 0)
    }
    COLOR_GRIS = QColor(100, 100, 100) 

    def __init__(self):
        super().__init__()
        self._estado_actual = self.ORDEN_ESTADOS[0] # Empieza en rojo

    def avanzarEstado(self):

    
        if self._estado_actual == "ROJO":
            self._estado_actual = "AMARILLO"
        elif self._estado_actual == "AMARILLO":
            self._estado_actual = "VERDE"
        elif self._estado_actual == "VERDE":
            self._estado_actual = "ROJO"
            
        self.update() # Vuelve a dibujar el semáforo con el nuevo estado

    def paintEvent(self, event):
        painter = QPainter(self)
        painter.setRenderHint(QPainter.Antialiasing)

        # Definición de Tamaño y Posición 
            
        DIAMETRO = 80  
        
        #La posición X donde empieza el dibujo.
        X_INICIO = 110 
        

        recto_base = QRect(100, 10, 100, 280)        

        painter.setPen(QPen(Qt.black, 3)) 
        painter.setBrush(QBrush(QColor(30, 30, 30))) 
        painter.drawRect(recto_base)

        # Dibujar las Tres Luces 
        
        
        rect_rojo = QRect(X_INICIO, 20, DIAMETRO, DIAMETRO)
        
        if self._estado_actual == "ROJO":
            color_final = self.COLORES_LUZ["ROJO"]
        else:
            color_final = self.COLOR_GRIS
            
        painter.setBrush(QBrush(color_final))
        painter.drawEllipse(rect_rojo)

        
        rect_amarillo = QRect(X_INICIO, 110, DIAMETRO, DIAMETRO)
        
        if self._estado_actual == "AMARILLO":
            color_final = self.COLORES_LUZ["AMARILLO"]
        else:
            color_final = self.COLOR_GRIS
            
        painter.setBrush(QBrush(color_final))
        painter.drawEllipse(rect_amarillo)
        
       
        rect_verde = QRect(X_INICIO, 200, DIAMETRO, DIAMETRO)

        if self._estado_actual == "VERDE":
            color_final = self.COLORES_LUZ["VERDE"]
        else:
            color_final = self.COLOR_GRIS
            
        painter.setBrush(QBrush(color_final))
        painter.drawEllipse(rect_verde)


# Ventana principal

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Semáforo")
        self.resize(300, 400) 

        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        self.semaforo = IndicadorSemaforoSuperSimple()

        btn_continuar = QPushButton("Continuar")
        btn_continuar.clicked.connect(self.semaforo.avanzarEstado)
        
        layout.addWidget(self.semaforo)
        layout.addWidget(btn_continuar)

        self.setCentralWidget(contenedor)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()