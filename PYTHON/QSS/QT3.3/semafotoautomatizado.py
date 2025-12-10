import sys
from PySide6.QtWidgets import QApplication, QWidget, QMainWindow, QVBoxLayout, QPushButton
from PySide6.QtGui import QPainter, QColor, QPen, QBrush
from PySide6.QtCore import QRect, Qt, QTimer 


class Semaforo(QWidget):
    def __init__(self):
        super().__init__()

        self.estado_actual = "rojo"

        self.rojo=  QColor ("Red")
        self.amarillo= QColor("Gray")
        self.verde= QColor("Gray")
        #self.amarillo= QColor("Yellow")
        #self.verde= QColor("Green")
    def paintEvent(self,event):
        painter = QPainter(self)

        painter.setRenderHint(QPainter.Antialiasing)

        painter.setBrush(QColor("DarkGray"))
        painter.setPen(QColor("Black"))

            #dimesiones

        alta= (self.height() // 5) *4
        ancho=(alta//  2)
            #en el centro siempre
        x= (self.width()- ancho)//2
        y= (self.height()- alta)//2
            #pintamos el retangulo
        painter.drawRect(x,y,ancho,alta)

        #pintar circulo

        diametro= ancho* 0.60
        
        #separar circulos
        espacioentrecirculos= (alta-diametro*3)/4

        #posicion circulos
        x_circulo= x + (ancho - diametro)//2
        y_circulo= y + espacioentrecirculos 

        y_circulo2= y + espacioentrecirculos*2 + diametro
        
        y_circulo3= y + espacioentrecirculos*3 + diametro*2

        #pintar circulos 
        painter.setBrush(self.rojo)
        painter.drawEllipse(x_circulo,y_circulo,diametro,diametro)
        painter.setBrush(self.amarillo)
        painter.drawEllipse(x_circulo,y_circulo2,diametro,diametro)
        painter.setBrush(self.verde)
        painter.drawEllipse(x_circulo,y_circulo3,diametro,diametro)

    def cambiarcolorcojone(self):
        if(self.estado_actual=="rojo"):
            self.amarillo= QColor("Yellow")
            self.estado_actual="amarillo"
            self.rojo= QColor("Gray")
        elif(self.estado_actual=="amarillo"):

            self.verde= QColor("Green")
            self.estado_actual="verde"
            self.amarillo= QColor("Gray")
        elif(self.estado_actual=="verde"):

            self.rojo= QColor("Red")
            self.estado_actual="rojo"
            self.verde= QColor("Gray")

        self.update()
        print(self.estadoporconsolacojones())

    def estadoporconsolacojones(self):
        return self.estado_actual





class VentanaPrincipal(QMainWindow):
   

    def __init__(self):
        super().__init__()
        temporizador= QTimer(self)
        temporizador.timeout.connect(self.cambiacolorostia)
        temporizador.setInterval(1)
        temporizador.start()
        self.setWindowTitle("Semáforo 100% Automático")
        self.resize(300, 350) 

        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        self.semaforo= Semaforo()
   

        layout.addWidget(self.semaforo)

        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)

    def cambiacolorostia(self):
        self.semaforo.cambiarcolorcojone()
 
  
if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()

