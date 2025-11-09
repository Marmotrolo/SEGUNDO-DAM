
#MANUEL PARRADO TORRES

class Video:
    def __init__(self, titulovideo = "", min_duracion = 0, categoria = ""):
        self.__titulovideo= titulovideo
        self.__min_duracion = min_duracion
        self.__categoria = categoria
    
    def SetTitulovideo(self, titulovideo):
        self.__titulovideo = titulovideo
    
    def GetTitulovideo(self):
        return self.__titulovideo
    
    def SetDuracion(self, min_duracion):
        self.__min_duracion= min_duracion
    
    def GetDuracion(self):
        return self.__min_duracion
    
    def SetCategoria(self, categoria):
        self.__categoria = categoria
    
    def GetCategoria(self):
        return self.__categoria
    
    def mirar_video(self):
        print("Iniciando video")
        print("El video se llama: ", self.GetTitulovideo(), " con duracion de ", self.GetDuracion(), " y su categoria es ", self.GetCategoria())

    def detener_video(self):
        print("Deteniendo el video")

class Audio:
    def __init__(self, tituloaudio= "", nombre = ""):
        self.__tituloaudio = tituloaudio
        self.__nombre = nombre

    def SetTituloaudio(self, tituloaudio):
        self.__tituloaudio = tituloaudio
    
    def GetTituloaudio(self):
        return self.__tituloaudio
    
    def SetNombre(self, nombre):
        self.__nombre = nombre
    
    def GetNombre(self):
        return self.__nombre
    
    def escuchar_audio(self):
        print("Escuchando audio")
        print(" Audio ",self.GetTituloaudio(), " Artista ", self.GetNombre())
    
    def detener_audio(self):
        print("Finalizando reproduccion de audio")

class Media(Video, Audio):
    def __init__(self, titulo, categoria, duracion, nombre):
        Video.__init__(self, titulo, duracion, categoria)
        Audio.__init__(self, titulo, nombre)

    def mostrar_media(self):
        
        self.mirar_video()
        self.detener_video()
        self.escuchar_audio()
        self.detener_audio()

medio1 = Media("faint", "nu metal", 180, "linkin park")
medio1.escuchar_audio()
medio1.mirar_video()
medio1.detener_audio()
medio1.detener_video()