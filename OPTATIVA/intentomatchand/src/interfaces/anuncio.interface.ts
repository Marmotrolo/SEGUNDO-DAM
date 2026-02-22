export type TipoAnuncio = 'busco_musico' | 'busco_banda' | 'ofrezco_servicio' | 'proyecto' | 'general';
export type EstadoAnuncio = 'activo' | 'cerrado' | 'eliminado';

export interface Anuncio {
  id: string;
  autorId: string;
  autorNombre: string;
  autorFoto: string;
  titulo: string;
  descripcion: string;
  tipo: TipoAnuncio;
  generoMusical: string;
  instrumentoBuscado?: string;
  nivelRequerido?: string;
  ciudad: string;
  precio?: string;
  esServicioProfesional: boolean;
  estado: EstadoAnuncio;
  likes: number;
  comentarios: number;
  fechaPublicacion: Date;
  fechaEdicion?: Date;
  vistas: number;
}

export interface AnuncioCrear {
  autorId: string;
  autorNombre: string;
  autorFoto: string;
  titulo: string;
  descripcion: string;
  tipo: TipoAnuncio;
  generoMusical: string;
  instrumentoBuscado?: string;
  nivelRequerido?: string;
  ciudad: string;
  precio?: string;
  esServicioProfesional: boolean;
}
