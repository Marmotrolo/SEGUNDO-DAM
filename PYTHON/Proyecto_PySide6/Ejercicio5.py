#MANUEL PARRADO TORRES
import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QLabel, QCheckBox
from PySide6.QtCore import Qt

class VentanaPrincipal (QMainWindow):
    def __init__ (self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        widget=QCheckBox("Esto es un checkbox")
        widget.setTristate(True)
        widget.setCheckState(Qt.PartiallyChecked)

        widget.stateChanged.connect(self.show_state)
    
        self.setCentralWidget(widget)

    def show_state(self,s):
       if(s == 0):
           print("Desmarcado")
       elif (s==2):
           print("Marcado")
       else:
           print("Marcado parcialmente")
       print(s)


app= QApplication(sys.argv)
window=VentanaPrincipal()
window.show()
app.exec()
