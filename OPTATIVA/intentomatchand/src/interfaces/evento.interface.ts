export type TipoEvento = 'concierto' | 'jam' | 'ensayo' | 'concurso' | 'taller';

export interface Evento {
  id: string;
  organizadorId: string;
  organizadorNombre: string;
  titulo: string;
  descripcion: string;
  tipo: TipoEvento;
  imagenPortada: string;
  fecha: Date;
  hora: string;
  lugar: string;
  ciudad: string;
  asistentes: string[];
  totalAsistentes: number;
  precio?: number;
  generoMusical?: string;
  aforo?: number;
  activo: boolean;
  fechaCreacion: Date;
}

export interface EventoCrear {
  organizadorId: string;
  organizadorNombre: string;
  titulo: string;
  descripcion: string;
  tipo: TipoEvento;
  imagenPortada: string;
  fecha: Date;
  hora: string;
  lugar: string;
  ciudad: string;
  precio?: number;
  generoMusical?: string;
  aforo?: number;
}
