export type EstadoMensaje = 'enviado' | 'leido';

export interface Mensaje {
  id: string;
  emisorId: string;
  receptorId: string;
  emisorNombre: string;
  emisorFoto: string;
  texto: string;
  estado: EstadoMensaje;
  fecha: Date;
}

export interface Conversacion {
  id: string;
  participantes: string[];
  mensajes: Mensaje[];
  ultimoMensaje: string;
  ultimaFecha: Date;
  noLeidos: number;
}

export interface MensajeEnviar {
  emisorId: string;
  receptorId: string;
  emisorNombre: string;
  emisorFoto: string;
  texto: string;
}
