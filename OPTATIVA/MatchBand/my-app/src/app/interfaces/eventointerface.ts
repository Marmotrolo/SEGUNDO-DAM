export interface Eventointerface {
  id?: string;
  titulo: string;
  descripcion: string;
  tipo: string;
  ciudad: string;
  lugar: string;
  fecha: string;
  hora: string;
  organizadorId: string;
  organizadorNombre: string;
  generoMusical: string;
  aforo?: number;
  gratuito: boolean;
  precio?: string;
  imagen?: string;
}
