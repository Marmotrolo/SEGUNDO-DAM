import sys
from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QLineEdit,QLCDNumber,QLabel,QTextEdit, QComboBox, QRadioButton, QPushButton, QStackedLayout,QVBoxLayout,QHBoxLayout,QGridLayout,QFormLayout, QToolBar, QStatusBar, QMessageBox,QCheckBox, QInputDialog, QDockWidget)
    # TODO: aÃ±adir aquÃ­ los widgets que necesites (QLineEdit, QTextEdit...)

from PySide6.QtGui import QAction
from PySide6.QtCore import Qt,QSize


class VentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()

        # TODO: tÃ­tulo y tamaÃ±o mÃ­nimo de la ventana
        self.setWindowTitle("Encuesta de satisfaccion")
        self.setMinimumSize(QSize(600,400))

        # TODO: declarar atributos de widgets (title, categoria, prioridad, area de texto)
        self.nombre = QLineEdit()
        self.numerotelefono= QLineEdit()
        self.compania= QComboBox()
        self.compania.addItems(["MovilPlus", "Movistar","Vodafone"])
        self.satisfaccion= QComboBox()
        self.satisfaccion.addItems(["Buena", "Normal","Mala"])
        self.cobertura= QComboBox()
        self.cobertura.addItems(["Buena", "Normal","Mala"])
        self.velocidad= QComboBox()
        self.velocidad.addItems(["Buena", "Normal","Mala"])
        self.atencion= QComboBox()
        self.atencion.addItems(["Buena", "Normal","Mala"])
        self.calidadprecio= QComboBox()
        self.calidadprecio.addItems(["Buena", "Normal","Mala"])
        
        self.coberturaqueprecio=QCheckBox("Valoro más la cobertura que el precio")
        self.precioquevelocidad=QCheckBox("Valoro más el precio que la velocidad")
        self.ofertasypromociones=QCheckBox("Me interesan las ofertas y promociones")
        self.cambiodecompañia=QCheckBox("Estoy pensando en cambiarme de compañia")
    
        
        # ...

        # TODO: declarar acciones (limpiar, imprimir, salir, acerca de)

       

        # ...

        # ConstrucciÃ³n general
        self.crear_central()       # TODO: completar
        self.crear_acciones()      # TODO: completar
        self.crear_menus()         # TODO: completar
        self.crear_toolbar()       # TODO: completar
        self.crear_statusbar()     # TODO: completar

    # =========================
    # CREACIÃ“N DE LA ZONA CENTRAL
    # =========================
    def crear_central(self):
        self.pila = QStackedLayout()
        self.pila.addWidget(QLabel("Capa 1"))
        self.pila.addWidget(QLabel("Capa 2"))
        widget_central = QWidget()

        layout_form = QFormLayout()
        layout_recomedar= QHBoxLayout()
        self.afirmacion = QRadioButton("Si")
        self.negacion = QRadioButton("No")
        layout_recomedar.addWidget(self.afirmacion)
        layout_recomedar.addWidget(self.negacion)

        layout_principal = QVBoxLayout()
        layout_botones = QVBoxLayout()

        layout_form.addRow(self.pila)
        boton1 = QPushButton("Ver capa 1")
        boton1.clicked.connect(self.activar_capa1)
        boton2 = QPushButton("Ver capa 2")
        boton2.clicked.connect(self.activar_capa2)
        layout_form.addRow("Nombre:", self.nombre)
        self.prefernecias= QLabel()
        self.opiniones= QLabel()
        self.recomedarias= QLabel()
        self.resumenlabel= "Resumen\nCompañia", self.compania.currentText,"\nSatisfaccion" ,self.satisfaccion.currentText, self.recomiendacompañia() 

        layout_form.addRow("Telefono:", self.numerotelefono)
        self.numerotelefono.setPlaceholderText("Numero de telefono")
        layout_form.addRow("Compañia:", self.compania)
        layout_form.addRow("Opiniones del servicio",self.opiniones)

        layout_form.addRow("Satisfaccion Global:", self.satisfaccion)
        layout_form.addRow("Calidad de cobertura:", self.cobertura)
        layout_form.addRow("Velocidad de datos:", self.velocidad)

        layout_form.addRow("Atencion al cliente:", self.atencion)
        layout_form.addRow("Relacion calidad precio:", self.calidadprecio)
        layout_form.addRow("Preferencias del servicio", self.prefernecias)

        layout_form.addRow(self.coberturaqueprecio)
        layout_form.addRow(self.precioquevelocidad)
        layout_form.addRow(self.ofertasypromociones)
        layout_form.addRow(self.cambiodecompañia)
        layout_form.addRow("¿Recomendarias esta compañia a otra persona?", self.recomedarias)







        # TODO: aÃ±adir layouts al layout principal
        layout_principal.addLayout(layout_form)   
        layout_principal.addLayout(layout_recomedar)

        # TODO: setLayout del widget central
        widget_central.setLayout(layout_principal)
        self.setCentralWidget(widget_central)


    # =========================
    # ACCIONES, MENÃš Y TOOLBAR
    # =========================
    def crear_acciones(self):
        # TODO: crear acciones (QAction) con texto y atajos
        self.accion_nuevaencuenta = QAction( "Nueva encuesta", self)
        self.accion_nuevaencuenta.triggered.connect(self.slot_nuevaencuesta)
        self.accion_salir = QAction( "Salir", self)
        self.accion_salir.triggered.connect(self.slot_salir)
        self.accion_acercade= QAction("Acerca de",self)
        self.accion_acercade.triggered.connect(self.slot_acerca_de)
        self.resumen= QAction("Resumen",self)
        self.resumen.triggered.connect(self.slot_resumen)
        self.dock1 = QDockWidget("Notas internas", self)
        self.dock1.setWidget(QTextEdit(""))
        self.dock1.setMinimumWidth(50)
        self.addDockWidget(Qt.BottomDockWidgetArea, self.dock1)
        self.compania.currentTextChanged.connect(self.slot_compañia_cambiada)
        


    def crear_menus(self):
        barra_menus = self.menuBar()
        menu_archivo = barra_menus.addMenu("Encuesta")
        menu_archivo.addAction(self.accion_nuevaencuenta)
        menu_archivo.addAction(self.resumen)
        menu_archivo.addAction(self.accion_salir)
        menu_ayuda = barra_menus.addMenu("Ayuda")
        menu_ayuda.addAction(self.accion_acercade)


    def crear_toolbar(self):
        toolbar = QToolBar()
        toolbar.addAction(self.accion_nuevaencuenta)
        toolbar.addAction(self.resumen)
        self.addToolBar(toolbar)


    def crear_statusbar(self):
        # TODO: crear barra de estado y mostrar un mensaje inicial
        barra_estado = self.statusBar()
        barra_estado.showMessage("Listo. Esperando acción...", 3000)
        self.barra_estado= barra_estado

 
    # =========================
    # FUNCIONES DE UTILIDAD
    # =========================
    def activar_capa1(self):
        self.pila.setCurrentIndex(0)
    def activar_capa2(self):
        self.pila.setCurrentIndex(1)

    def limpiar_encuesta(self):
        self.numerotelefono.clear()
        self.dock1.clear()
        pass

   

        
    def recomiendacompañia(self):
        recomendar= ""
        if(self.afirmacion.isChecked()):
            recomendar="La persona recomienda esta compañia"
        else:
            recomendar="La persona NO recomienda esta compañia"
        return recomendar
    
    def slot_nuevaencuesta(self):
        respuesta = QMessageBox.question(
            self,
            "Nueva encuesta",
            "¿Seguro que quieres borrar los datos?",
            QMessageBox.Yes | QMessageBox.No
        )
        if respuesta == QMessageBox.Yes:
            self.nombre.clear()
            self.numerotelefono.clear()
            self.afirmacion.setChecked(False)
            self.negacion.setChecked(False)
            self.coberturaqueprecio.setChecked(False)
            self.precioquevelocidad.setChecked(False)
            self.ofertasypromociones.setChecked(False)

        

    def slot_salir(self):
    
        app.closeAllWindows()
        

    def slot_acerca_de(self):
        # TODO mostrar QMessageBox.information
           QMessageBox.information(
            self,
            "Mensaje de ayuda",
            "Encuesta satisfaccion")
         
        
    def slot_resumen(self):
        # TODO mostrar QMessageBox.information
        #PROBLEMA NO SOPORTA MÁS DE UN VALOR 
           QMessageBox.information(
            self,
            "Resumen",
            "Da error"
        #    self.resumenlabel

            )
         

    def slot_titulo_cambiado(self, nuevo_titulo):
        self.setWindowTitle(nuevo_titulo)
        self.barra_estado.showMessage(nuevo_titulo)
        

    def slot_compañia_cambiada(self, nueva_compañia):
        self.barra_estado.showMessage(nueva_compañia)

    def slot_prioridad_cambiada(self):
        self.barra_estado.showMessage()



if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()