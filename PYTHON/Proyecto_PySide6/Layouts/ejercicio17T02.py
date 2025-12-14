#Manuel Parrado Torres
from PySide6.QtWidgets import (
    QApplication, QMainWindow, QDialog, QLabel, QPushButton,
    QVBoxLayout, QLineEdit, QMessageBox
)
from PySide6.QtCore import Qt


# --------------------------------------------------
#  Diálogo de autenticación
# --------------------------------------------------
class VentanaLogin(QDialog):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Acceso al sistema")

        # Crear layout
        contenedor = QVBoxLayout()
        self.setLayout(contenedor)

        # Campo de nombre de usuario
        self.input_user = QLineEdit()
        self.input_user.setPlaceholderText("Nombre de usuario")

        # Campo de contraseña
        self.input_pass = QLineEdit()
        self.input_pass.setPlaceholderText("Clave de acceso")
        self.input_pass.setEchoMode(QLineEdit.Password)

        # Botón para confirmar
        boton_acceder = QPushButton("Ingresar")
        boton_acceder.clicked.connect(self.comprobar_datos)

        # Añadir elementos
        contenedor.addWidget(self.input_user)
        contenedor.addWidget(self.input_pass)
        contenedor.addWidget(boton_acceder)

    # Verificar usuario/contraseña
    def comprobar_datos(self):
        nombre = self.input_user.text()
        clave = self.input_pass.text()

        # Validación simple
        if nombre == "admin" and clave == "admin":
            self.accept()
        else:
            QMessageBox.warning(
                self,
                "Aviso",
                "Credenciales incorrectas"
            )



#  Ventana principal
class InterfazPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Panel principal")

        etiqueta = QLabel("Bienvenido")
        etiqueta.setAlignment(Qt.AlignCenter)

        self.setCentralWidget(etiqueta)


#  Programa principal
app = QApplication([])

login = VentanaLogin()
resultado = login.exec()

if resultado == QDialog.Accepted:
    principal = InterfazPrincipal()
    principal.showMaximized()
    app.exec()
