"""
TAREA 3.2 - Editor de notas con avisos
Autor: [Tu nombre y apellidos]

Aplicación sencilla con tres widgets derivados usando QPalette.

ARCHIVO: apellido1_nombre_T3.2.py
"""

import sys
from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QTextEdit,
    QLabel,
    QPushButton
)
from PySide6.QtCore import Signal
from PySide6.QtGui import QPalette, QColor


# ==========================================
# 1. AREA DE TEXTO CON LÍMITE
# ==========================================
class AreaTextoLimitada(QTextEdit):
    """
    Un área de texto que solo permite escribir 200 caracteres.
    Cambia de color cuando te acercas al límite.
    """
    
    # Creamos una señal que envía un número (los caracteres escritos)
    longitud_cambiada = Signal(int)
    
    def __init__(self, parent=None):
        super().__init__(parent)
        
        # El límite máximo es 200 caracteres
        self.__limite = 200
        
        # Cada vez que escribo algo, llamo a mi método
        self.textChanged.connect(self.__cuando_escribo)
        
        # Empiezo con fondo blanco
        self.__poner_color_blanco()
      
    
    def __cuando_escribo(self):
        """
        Este método se ejecuta cada vez que escribo o borro algo.
        """
        # Obtengo lo que he escrito

        mi_texto = self.toPlainText()
        # Cuento cuántas letras/números/espacios tengo
        cuantos_caracteres = len(mi_texto)
        
        # Si escribí más de 200, corto el texto
        if cuantos_caracteres > self.__limite:
            # Corto el texto a 200 caracteres exactos
            texto_cortado = mi_texto[:200]
            self.setPlainText(texto_cortado)
            cuantos_caracteres = 200
        
        # Cambio el color según cuántos caracteres tengo
        if cuantos_caracteres < 160:  # Menos de 160 (80% de 200)
            self.__poner_color_blanco()
        elif cuantos_caracteres < 200:  # Entre 160 y 199
            self.__poner_color_amarillo()
        else:  # Exactamente 200
            self.__poner_color_rojo()
        
        # Envío una señal con el número de caracteres
        self.longitud_cambiada.emit(cuantos_caracteres)
    
    def __poner_color_blanco(self):
        """
        Pongo el fondo de color blanco (estado normal).
        """
        # Creo una paleta de colores
        paleta = self.palette()
    

        # Cambio el color de fondo a blanco
        paleta.setColor(QPalette.ColorRole.Base, QColor(255, 255, 255))
        paleta.setColor(QPalette.ColorRole.Text, QColor(0, 0, 0))

        
        # Aplico la paleta
        self.setPalette(paleta)
    
    def __poner_color_amarillo(self):
        """
        Pongo el fondo de color amarillo suave (advertencia).
        """
        # Creo una paleta de colores
        paleta = self.palette()
        
        # Cambio el color de fondo a amarillo suave
        paleta.setColor(QPalette.ColorRole.Base, QColor(255, 250, 205))
        
        # Aplico la paleta
        self.setPalette(paleta)
    
    def __poner_color_rojo(self):
        """
        Pongo el fondo de color rojo suave (límite alcanzado).
        """
        # Creo una paleta de colores
        paleta = self.palette()
        
        # Cambio el color de fondo a rojo suave
        paleta.setColor(QPalette.ColorRole.Base, QColor(255, 204, 204))
        
        # Aplico la paleta
        self.setPalette(paleta)
    
    def obtener_limite(self):
        """
        Devuelvo cuál es mi límite máximo.
        """
        return self.__limite


# ==========================================
# 2. ETIQUETA QUE CUENTA CARACTERES
# ==========================================
class EtiquetaContadorCaracteres(QLabel):
    
    def __init__(self, parent=None):
        super().__init__(parent)
        
        # Guardo el límite máximo
        self.__limite = 200
        
        # Muestro el texto inicial
        self.setText("Caracteres: 0 / 200")
        
        # Empiezo con texto negro
        self.__poner_texto_negro()
    
    def establecer_limite(self, limite):
        self.__limite = limite
    
    def actualizar_contador(self, cuantos_caracteres):
        # Actualizo el texto que muestro
        texto = "Caracteres: " + str(cuantos_caracteres) + " / " + str(self.__limite)
        self.setText(texto)
        
        # Cambio mi color según cuántos caracteres hay
        if cuantos_caracteres < 160:  # Menos de 160 (80% de 200)
            self.__poner_texto_negro()
        elif cuantos_caracteres < 200:  # Entre 160 y 199
            self.__poner_texto_naranja()
        else:  
            self.__poner_texto_rojo()
    
    def __poner_texto_negro(self):
   
        # Creo una paleta de colores
        paleta = self.palette()
        
        # Cambio el color del texto a negro
        self.setPalette(paleta)
    
    def __poner_texto_naranja(self):
 
        # Creo una paleta de colores
        paleta = self.palette()
        
        # Cambio el color del texto a naranja
        paleta.setColor(QPalette.ColorRole.WindowText, QColor(255, 140, 0))
        
        self.setPalette(paleta)
    
    def __poner_texto_rojo(self):
       
        # Creo una paleta de colores
        paleta = self.palette()
        
        # Cambio el color del texto a rojo
        paleta.setColor(QPalette.ColorRole.WindowText, QColor(220, 20, 60))
        
        self.setPalette(paleta)


# 3. BOTÓN PARA LIMPIAR

class BotonLimpiarAviso(QPushButton):
   
    
    # Creamos una señal para avisar cuando limpiamos
    texto_limpiado = Signal()
    
    def __init__(self, parent=None):
        super().__init__("Limpiar texto", parent)
        
        # Aquí guardaré el área de texto que voy a limpiar
        self.__area_texto = None
        
        # Cuando me pulsen, ejecuto mi método
        self.clicked.connect(self.__cuando_me_pulsan)
        
        # Empiezo con color gris
        self.__poner_color_gris()
        
        # Activo el autoFillBackground para que se vea el color
        self.setAutoFillBackground(True)
    
    def vincular_area_texto(self, area_texto):
        """
        Me dicen cuál es el área de texto que tengo que limpiar.
        """
        self.__area_texto = area_texto
    
    def __cuando_me_pulsan(self):

        # Si tengo un área de texto vinculada, la limpio
        if self.__area_texto is not None:
            self.__area_texto.clear()
            
            # Me pongo de color verde
            self.__poner_color_verde()
            
            # Envío una señal avisando que limpié
            self.texto_limpiado.emit()
    
    def __poner_color_gris(self):
        paleta = self.palette()
        
        # Cambio el color del botón a gris claro
        paleta.setColor(QPalette.ColorRole.Button, QColor(220, 220, 220))
        
        self.setPalette(paleta)
    
    def __poner_color_verde(self):
        
        paleta = self.palette()
        
        # Cambio el color del botón a verde suave
        paleta.setColor(QPalette.ColorRole.Button, QColor(144, 238, 144))
        
        self.setPalette(paleta)


# ==========================================
# VENTANA PRINCIPAL
# ==========================================
class VentanaPrincipal(QMainWindow):
    
    def __init__(self):
        super().__init__()
        
        # Pongo el título de la ventana
        self.setWindowTitle("Editor de notas con avisos")
        
        # Hago que la ventana tenga un tamaño mínimo
        self.setMinimumSize(500, 400)
        
        # Creo un contenedor para poner cosas dentro
        contenedor = QWidget()
        
        # Creo un layout vertical (las cosas se ponen una debajo de otra)
        layout = QVBoxLayout()
        
        # Creo mis tres widgets personalizados
        self.etiqueta_contador = EtiquetaContadorCaracteres()
        self.area_texto = AreaTextoLimitada()
        self.boton_limpiar = BotonLimpiarAviso()
        
        # Creo una etiqueta para mostrar mensajes
        self.etiqueta_info = QLabel("Estado: Listo para escribir")
        
        # Le digo al botón cuál área de texto debe limpiar
        self.boton_limpiar.vincular_area_texto(self.area_texto)
        
        # Le digo a la etiqueta cuál es el límite máximo
        limite = self.area_texto.obtener_limite()
        self.etiqueta_contador.establecer_limite(limite)
        
        # Añado todos los widgets al layout (uno debajo del otro)
        layout.addWidget(self.etiqueta_contador)
        layout.addWidget(self.area_texto)
        layout.addWidget(self.boton_limpiar)
        layout.addWidget(self.etiqueta_info)
        
        # Pongo el layout dentro del contenedor
        contenedor.setLayout(layout)
        
        # Pongo el contenedor en el centro de la ventana
        self.setCentralWidget(contenedor)
        
        # Conecto las señales
        self.__conectar_senales()
    
    def __conectar_senales(self):
        # Cuando cambie la longitud del texto, actualizo el contador
        self.area_texto.longitud_cambiada.connect(
            self.etiqueta_contador.actualizar_contador
        )
        
        # Cuando cambie la longitud del texto, actualizo el mensaje
        self.area_texto.longitud_cambiada.connect(self.__actualizar_mensaje)
        
        # Cuando limpie el texto, muestro un mensaje
        self.boton_limpiar.texto_limpiado.connect(self.__cuando_limpio)
    
    def __actualizar_mensaje(self, cuantos_caracteres):
        if cuantos_caracteres >= 200:
            self.etiqueta_info.setText("Estado: Límite alcanzado")
        else:
            self.etiqueta_info.setText("Estado: Listo para escribir")
    
    def __cuando_limpio(self):
      
        self.etiqueta_info.setText("Estado: Texto limpiado")


# INICIO DEL PROGRAMA
if __name__ == "__main__":
    # Creo la aplicación
    app = QApplication(sys.argv)
    
    # Creo la ventana
    ventana = VentanaPrincipal()
    
    # Muestro la ventana
    ventana.show()
    
    # Ejecuto la aplicación
    app.exec()