import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Evento, EventoCrear } from '@/interfaces';

@Injectable({ providedIn: 'root' })
export class EventoService {
  private eventos$ = new BehaviorSubject<Evento[]>([]);

  constructor() {}

  getAll(): Observable<Evento[]> {
    return new Observable(observer => {
      const ordenados = this.eventos$.value.sort((a, b) => a.fecha.getTime() - b.fecha.getTime());
      observer.next(ordenados);
      observer.complete();
    });
  }

  getById(id: string): Observable<Evento | undefined> {
    return new Observable(observer => {
      const evento = this.eventos$.value.find(e => e.id === id);
      observer.next(evento);
      observer.complete();
    });
  }

  confirmar(eventoId: string, userId: string): void {
    const eventos = this.eventos$.value;
    const evento = eventos.find(e => e.id === eventoId);
    if (evento && !evento.asistentes.includes(userId)) {
      evento.asistentes.push(userId);
      evento.totalAsistentes++;
      this.eventos$.next([...eventos]);
    }
  }

  cancelar(eventoId: string, userId: string): void {
    const eventos = this.eventos$.value;
    const evento = eventos.find(e => e.id === eventoId);
    if (evento) {
      evento.asistentes = evento.asistentes.filter(id => id !== userId);
      evento.totalAsistentes = Math.max(0, evento.totalAsistentes - 1);
      this.eventos$.next([...eventos]);
    }
  }

  yaAsiste(eventoId: string, userId: string): Observable<boolean> {
    return new Observable(observer => {
      const evento = this.eventos$.value.find(e => e.id === eventoId);
      const asiste = evento?.asistentes.includes(userId) ?? false;
      observer.next(asiste);
      observer.complete();
    });
  }

  crear(datos: EventoCrear): void {
    const nuevoEvento: Evento = {
      ...datos,
      id: `e${Date.now()}`,
      asistentes: [],
      totalAsistentes: 0,
      fechaCreacion: new Date(),
      activo: true,
    };
    const eventos = this.eventos$.value;
    this.eventos$.next([...eventos, nuevoEvento]);
  }
}
