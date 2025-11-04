import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QComboBox

class VentanaPrincipal (QMainWindow):
    def __init__ (self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        combo= QComboBox()
        combo.addItems(["Uno","Dos","Tres"])
        combo.setEditable(True)
        combo.setInsertPolicy(QComboBox.InsertAlphabetically)
        combo.setMaxCount(5)

        combo.currentIndexChanged.connect(self.cambio_indice)
        combo.currentTextChanged.connect(self.cambio_text)

        self.setCentralWidget(combo)

    def cambio_indice (self, i):
        print("Indice seleccionado", i)

    def cambio_text (self , i):
        print ("Texto seleccionado", i)

app = QApplication([])
vetana= VentanaPrincipal()
vetana.show()
app.exec()