import sys
from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QLineEdit, QLabel, QTextEdit,
    QComboBox, QRadioButton, QPushButton, QStackedLayout, QVBoxLayout,
    QHBoxLayout, QFormLayout, QToolBar, QMessageBox, QCheckBox,
    QDockWidget
)
from PySide6.QtGui import QAction
from PySide6.QtCore import Qt, QSize


class VentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Encuesta de satisfacción")
        self.setMinimumSize(QSize(600, 400))

        # Campos del formulario
        self.nombre = QLineEdit()
        self.numerotelefono = QLineEdit()

        self.compania = QComboBox()
        self.compania.addItems(["MovilPlus", "Movistar", "Vodafone"])

        self.satisfaccion = QComboBox()
        self.satisfaccion.addItems(["Buena", "Normal", "Mala"])

        self.cobertura = QComboBox()
        self.cobertura.addItems(["Buena", "Normal", "Mala"])

        self.velocidad = QComboBox()
        self.velocidad.addItems(["Buena", "Normal", "Mala"])

        self.atencion = QComboBox()
        self.atencion.addItems(["Buena", "Normal", "Mala"])

        self.calidadprecio = QComboBox()
        self.calidadprecio.addItems(["Buena", "Normal", "Mala"])

        # Checkboxes
        self.coberturaqueprecio = QCheckBox("Valoro más la cobertura que el precio")
        self.precioquevelocidad = QCheckBox("Valoro más el precio que la velocidad")
        self.ofertasypromociones = QCheckBox("Me interesan las ofertas y promociones")
        self.cambiodecompania = QCheckBox("Estoy pensando en cambiarme de compañía")

        # Radio buttons
        self.afirmacion = QRadioButton("Sí")
        self.negacion = QRadioButton("No")

        # Construcción
        self.crear_central()
        self.crear_acciones()
        self.crear_menus()
        self.crear_toolbar()
        self.crear_statusbar()

    # ============================
    # ZONA CENTRAL
    # ============================
    def crear_central(self):
        layout_principal = QVBoxLayout()
        layout_form = QFormLayout()

        # Recomendar
        layout_recomendar = QHBoxLayout()
        layout_recomendar.addWidget(self.afirmacion)
        layout_recomendar.addWidget(self.negacion)

        # Formulario
        layout_form.addRow("Nombre:", self.nombre)
        layout_form.addRow("Teléfono:", self.numerotelefono)
        layout_form.addRow("Compañía:", self.compania)
        layout_form.addRow("Satisfacción global:", self.satisfaccion)
        layout_form.addRow("Cobertura:", self.cobertura)
        layout_form.addRow("Velocidad de datos:", self.velocidad)
        layout_form.addRow("Atención al cliente:", self.atencion)
        layout_form.addRow("Relación calidad/precio:", self.calidadprecio)

        layout_form.addRow(self.coberturaqueprecio)
        layout_form.addRow(self.precioquevelocidad)
        layout_form.addRow(self.ofertasypromociones)
        layout_form.addRow(self.cambiodecompania)

        layout_form.addRow("¿Recomendarías esta compañía?", layout_recomendar)

        layout_principal.addLayout(layout_form)

        widget_central = QWidget()
        widget_central.setLayout(layout_principal)
        self.setCentralWidget(widget_central)

    # ============================
    # ACCIONES, MENÚS Y TOOLBAR
    # ============================
    def crear_acciones(self):
        self.accion_nueva = QAction("Nueva encuesta", self)
        self.accion_nueva.triggered.connect(self.slot_nuevaencuesta)

        self.accion_resumen = QAction("Resumen", self)
        self.accion_resumen.triggered.connect(self.slot_resumen)

        self.accion_salir = QAction("Salir", self)
        self.accion_salir.triggered.connect(self.slot_salir)

        self.accion_acerca_de = QAction("Acerca de", self)
        self.accion_acerca_de.triggered.connect(self.slot_acerca_de)

        # Dock
        self.dock1 = QDockWidget("Notas internas", self)
        self.dock1.setWidget(QTextEdit(""))
        self.addDockWidget(Qt.BottomDockWidgetArea, self.dock1)

    def crear_menus(self):
        barra_menus = self.menuBar()

        menu_encuesta = barra_menus.addMenu("Encuesta")
        menu_encuesta.addAction(self.accion_nueva)
        menu_encuesta.addAction(self.accion_resumen)
        menu_encuesta.addAction(self.accion_salir)

        menu_ayuda = barra_menus.addMenu("Ayuda")
        menu_ayuda.addAction(self.accion_acerca_de)

    def crear_toolbar(self):
        toolbar = QToolBar()
        toolbar.addAction(self.accion_nueva)
        toolbar.addAction(self.accion_resumen)
        self.addToolBar(toolbar)

    def crear_statusbar(self):
        self.statusBar().showMessage("Listo. Esperando acción...")

    # ============================
    # FUNCIONES PRINCIPALES
    # ============================
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
            self.cambiodecompania.setChecked(False)

    def recomiendacompañia(self):
        if self.afirmacion.isChecked():
            return "La persona recomienda esta compañía."
        else:
            return "La persona NO recomienda esta compañía."

    def slot_resumen(self):
        texto = ""
        texto += "Nombre: " + self.nombre.text() + "\n"
        texto += "Teléfono: " + self.numerotelefono.text() + "\n"
        texto += "Compañía: " + self.compania.currentText() + "\n"
        texto += "Satisfacción: " + self.satisfaccion.currentText() + "\n"
        texto += "Cobertura: " + self.cobertura.currentText() + "\n"
        texto += "Velocidad: " + self.velocidad.currentText() + "\n"
        texto += "Atención al cliente: " + self.atencion.currentText() + "\n"
        texto += "Relación calidad/precio: " + self.calidadprecio.currentText() + "\n\n"

        texto += "Preferencias:\n"
        texto += "- Cobertura > Precio: " + ("Sí" if self.coberturaqueprecio.isChecked() else "No") + "\n"
        texto += "- Precio > Velocidad: " + ("Sí" if self.precioquevelocidad.isChecked() else "No") + "\n"
        texto += "- Ofertas/promociones: " + ("Sí" if self.ofertasypromociones.isChecked() else "No") + "\n"
        texto += "- Pensando en cambiar: " + ("Sí" if self.cambiodecompania.isChecked() else "No") + "\n\n"

        texto += self.recomiendacompañia()

        QMessageBox.information(self, "Resumen de encuesta", texto)

    def slot_salir(self):
        QApplication.quit()

    def slot_acerca_de(self):
        QMessageBox.information(self, "Acerca de", "Aplicación de encuesta de satisfacción.")


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
