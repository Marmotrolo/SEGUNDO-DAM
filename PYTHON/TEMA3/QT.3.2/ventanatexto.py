
from PySide6.QtWidgets import QApplication,QMainWindow,QVBoxLayout, QWidget, QTextEdit, QLabel, QPushButton, QStatusBar
from PySide6.QtCore import Signal
from PySide6.QtGui import QPalette, QColor

'''class personalizada(Qloquetoqe)
        variable = Signal(lo que emite(int, str))
        def init()
            parametros

            self.clicket/textchange/presed.connect(self.funcion)

        def funcion(self)
            self.variable.emit(lo que quieres q emita(parametro))'''

class AreaTextoLimitada(QTextEdit):
    cantidad_letras = Signal(int)

    def __init__(self, parent = None):
        super().__init__()
        self.__contador = 0
        self.limite = 200

        self.textChanged.connect(self.contar_letras)

    # metodo para contar letras
    def contar_letras(self):
        #pasa a texto plano y cuenta los caracteres
        texto = self.toPlainText()
        self.__contador = len(texto)
        #hace una division y en funcion del resultado cambia el color
        paleta = self.palette()
        
        paleta.setColor(QPalette.Text, QColor("Black"))
        if self.__contador/self.limite < 0.8:
            paleta.setColor(QPalette.Base, QColor("white"))
        elif 0.8 <= self.__contador/self.limite <= 1:
            paleta.setColor(QPalette.Base, QColor("#F5EFA3"))
        elif 1 < self.__contador/self.limite:
            paleta.setColor(QPalette.Base, QColor("#F5B9B9"))
        self.setPalette(paleta)

        #emite una señal con el numero de caracteres actual
        self.cantidad_letras.emit(self.__contador)

    # metodo para borrar el texto actual
    def limpiartexto(self):
        self.setText("")




class EtiquetaContadorCaracteres(QLabel):
    def __init__(self, parent = None):
        super().__init__("Caracteres: 0 /200", parent)

    #metodo para actualizar el contador, recibe la cantidad de la señal del QTextEdit
    def actualizar_contador(self, cantidad):
        
        #cambia el texto del QLabel
        self.setText("Caracteres: " + str(cantidad) + " /200")

        #en funcion de la cantidad modifica el color del texto
        paleta = self.palette()
        if cantidad/200 < 0.8:
            paleta.setColor(QPalette.WindowText, QColor("white"))
        elif 0.8 <= cantidad/200 <= 1:
            paleta.setColor(QPalette.WindowText, QColor("#D39015"))
        elif 1 < cantidad/200:
            paleta.setColor(QPalette.WindowText, QColor("#EC5656"))
        self.setPalette(paleta)



        
class BotonLimpiarAviso(QPushButton):
    texto_limpiado = Signal(str)
    def __init__(self, parent = None):
        super().__init__("Limpiar texto", parent)
        # texto y color original al crear el boton
        self.__valor= "Texto Limpiado"
        self.paleta = self.palette()
        self.paleta.setColor(QPalette.Button, QColor("#8F8E8E"))
        self.setPalette(self.paleta)

        #al hacer click ejecuta el metodo limpiar
        self.clicked.connect(self.limpiar)

    #metodo para cambiar el color del boton y emitir una señal de pulsado
    def limpiar(self):
        self.texto_limpiado.emit(self.__valor)

        self.paleta.setColor(QPalette.Button, QColor("#56EC7B"))
        self.setPalette(self.paleta)


    
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Editor de notas con avisos")

        contenedor = QWidget()
        layout = QVBoxLayout()

        self.etiqueta = EtiquetaContadorCaracteres()
        self.areatexto = AreaTextoLimitada()
        self.boton = BotonLimpiarAviso()
        self.barra_estado = QStatusBar()
        self.barra_estado.showMessage("listo esperando", 3000)

        #al modificar el texto conecta con el Qlabel para cambiar el texto
        self.areatexto.cantidad_letras.connect(self.etiqueta.actualizar_contador)

        #al pulsar el boton conecta con el QEditText para limpiar el texto
        self.boton.texto_limpiado.connect(self.areatexto.limpiartexto)

        #al pulsar el boton ejecuta el metodo de mostrar mensaje por la barra de estado
        self.boton.texto_limpiado.connect(self.mostrar_mensaje)

        layout.addWidget(self.etiqueta)
        layout.addWidget(self.areatexto)
        layout.addWidget(self.boton)
        layout.addWidget(self.barra_estado)

        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)

    def mostrar_mensaje(self, mensaje):
        self.barra_estado.showMessage(mensaje, 10000)

app=QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()
                
