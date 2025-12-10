import sys
from PySide6.QtWidgets import QApplication, QWidget, QMainWindow, QVBoxLayout
from PySide6.QtGui import QPainter, QColor, QPen, QBrush
from PySide6.QtCore import QRect, Qt, QTimer 

class IndicadorSemaforoSuperSimple(QWidget):
    # Configuración de Colores 
    
    ORDEN_ESTADOS = ["ROJO", "AMARILLO", "VERDE"]
    COLORES_LUZ = {
        "ROJO": QColor(255, 0, 0),
        "AMARILLO": QColor(255, 255, 0),
        "VERDE": QColor(0, 255, 0)
    }
    COLOR_GRIS = QColor(100, 100, 100) 
    DIAMETRO = 80  
    X_INICIO = 110 
    

    def __init__(self):
        super().__init__()
        self._estado_actual = self.ORDEN_ESTADOS[0] 

        self.temporizador = QTimer(self)
        
        self.temporizador.timeout.connect(self.avanzarEstado)
        
        self.temporizador.start(1000) 


    def avanzarEstado(self):
        if self._estado_actual == "ROJO":
            self._estado_actual = "AMARILLO"
        elif self._estado_actual == "AMARILLO":
            self._estado_actual = "VERDE"
        elif self._estado_actual == "VERDE":
            self._estado_actual = "ROJO"
            
        self.update() 

    def paintEvent(self, event):
        painter = QPainter(self)
        painter.setRenderHint(QPainter.Antialiasing)
                
        recto_base = QRect(100, 10, 100, 280)       

        painter.setPen(QPen(Qt.black, 3)) 
        painter.setBrush(QBrush(QColor(30, 30, 30))) 
        painter.drawRect(recto_base)
        
        # ROJA
       
        rect_rojo = QRect(self.X_INICIO, 20, self.DIAMETRO, self.DIAMETRO)
        
        if self._estado_actual == "ROJO":
            color_final = self.COLORES_LUZ["ROJO"]
        else:
            color_final = self.COLOR_GRIS
            
        painter.setBrush(QBrush(color_final))
        painter.drawEllipse(rect_rojo)

        
        rect_amarillo = QRect(self.X_INICIO, 110, self.DIAMETRO, self.DIAMETRO)
        
        if self._estado_actual == "AMARILLO":
            color_final = self.COLORES_LUZ["AMARILLO"]
        else:
            color_final = self.COLOR_GRIS
            
        painter.setBrush(QBrush(color_final))
        painter.drawEllipse(rect_amarillo)
        
       
        rect_verde = QRect(self.X_INICIO, 200, self.DIAMETRO, self.DIAMETRO)

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

        self.setWindowTitle("Semáforo 100% Automático")
        self.resize(300, 350) 

        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        self.semaforo = IndicadorSemaforoSuperSimple()

        layout.addWidget(self.semaforo)

        self.setCentralWidget(contenedor)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()