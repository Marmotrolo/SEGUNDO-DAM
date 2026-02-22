import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Conversacion, Mensaje, MensajeEnviar } from '@/interfaces';

@Injectable({ providedIn: 'root' })
export class MensajeService {
  private conversaciones$ = new BehaviorSubject<Conversacion[]>([]);

  constructor() {}

  getConversaciones(userId: string): Observable<Conversacion[]> {
    return new Observable(observer => {
      const conversaciones = this.conversaciones$.value
        .filter(c => c.participantes.includes(userId))
        .sort((a, b) => b.ultimaFecha.getTime() - a.ultimaFecha.getTime());
      observer.next(conversaciones);
      observer.complete();
    });
  }

  getConversacion(id1: string, id2: string): Observable<Conversacion> {
    return new Observable(observer => {
      let conversacion = this.conversaciones$.value.find(
        c => (c.participantes.includes(id1) && c.participantes.includes(id2))
      );

      if (!conversacion) {
        conversacion = {
          id: `c${Date.now()}`,
          participantes: [id1, id2],
          mensajes: [],
          ultimoMensaje: '',
          ultimaFecha: new Date(),
          noLeidos: 0,
        };
        const conversaciones = this.conversaciones$.value;
        this.conversaciones$.next([...conversaciones, conversacion]);
      }

      observer.next(conversacion);
      observer.complete();
    });
  }

  getTotalNoLeidos(userId: string): Observable<number> {
    return new Observable(observer => {
      const total = this.conversaciones$.value.reduce((t, c) => {
        const noLeidos = c.mensajes.filter(m => m.receptorId === userId && m.estado === 'enviado').length;
        return t + noLeidos;
      }, 0);
      observer.next(total);
      observer.complete();
    });
  }

  enviar(datos: MensajeEnviar): void {
    const conversaciones = this.conversaciones$.value;
    let conversacion = conversaciones.find(
      c => (c.participantes.includes(datos.emisorId) && c.participantes.includes(datos.receptorId))
    );

    if (!conversacion) {
      conversacion = {
        id: `c${Date.now()}`,
        participantes: [datos.emisorId, datos.receptorId],
        mensajes: [],
        ultimoMensaje: '',
        ultimaFecha: new Date(),
        noLeidos: 0,
      };
      conversaciones.push(conversacion);
    }

    const mensaje: Mensaje = {
      id: `m${Date.now()}`,
      emisorId: datos.emisorId,
      receptorId: datos.receptorId,
      emisorNombre: datos.emisorNombre,
      emisorFoto: datos.emisorFoto,
      texto: datos.texto,
      estado: 'enviado',
      fecha: new Date(),
    };

    conversacion.mensajes.push(mensaje);
    conversacion.ultimoMensaje = datos.texto;
    conversacion.ultimaFecha = new Date();
    this.conversaciones$.next([...conversaciones]);
  }

  marcarLeida(convId: string, receptorId: string): void {
    const conversaciones = this.conversaciones$.value;
    const conversacion = conversaciones.find(c => c.id === convId);
    if (conversacion) {
      conversacion.mensajes.forEach(m => {
        if (m.receptorId === receptorId && m.estado === 'enviado') {
          m.estado = 'leido';
        }
      });
      this.conversaciones$.next([...conversaciones]);
    }
  }
}
