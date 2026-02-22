export interface Valoracion {
  id: string;
  autorId: string;
  autorNombre: string;
  receptorId: string;
  puntuacion: number;
  comentario: string;
  fecha: Date;
}

export interface ValoracionCrear {
  autorId: string;
  autorNombre: string;
  receptorId: string;
  puntuacion: number;
  comentario: string;
}
