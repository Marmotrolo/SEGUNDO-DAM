import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Anuncio, AnuncioCrear } from '@/interfaces';

@Injectable({ providedIn: 'root' })
export class AnuncioService {
  private anuncios$ = new BehaviorSubject<Anuncio[]>([]);

  constructor() {}

  getAll(): Observable<Anuncio[]> {
    return new Observable(observer => {
      const activos = this.anuncios$.value.filter(a => a.estado === 'activo');
      observer.next(activos);
      observer.complete();
    });
  }

  getById(id: string): Observable<Anuncio | undefined> {
    return new Observable(observer => {
      const anuncio = this.anuncios$.value.find(a => a.id === id);
      observer.next(anuncio);
      observer.complete();
    });
  }

  getMisAnuncios(autorId: string): Observable<Anuncio[]> {
    return new Observable(observer => {
      const miAnuncios = this.anuncios$.value.filter(a => a.autorId === autorId);
      observer.next(miAnuncios);
      observer.complete();
    });
  }

  publicar(datos: AnuncioCrear): void {
    const nuevoAnuncio: Anuncio = {
      ...datos,
      id: `a${Date.now()}`,
      estado: 'activo',
      fechaPublicacion: new Date(),
      vistas: 0,
      likes: 0,
      comentarios: 0,
    };
    const anuncios = this.anuncios$.value;
    this.anuncios$.next([...anuncios, nuevoAnuncio]);
  }

  eliminar(id: string): void {
    const anuncios = this.anuncios$.value;
    const anuncio = anuncios.find(a => a.id === id);
    if (anuncio) {
      anuncio.estado = 'eliminado';
      this.anuncios$.next([...anuncios]);
    }
  }

  darLike(id: string): void {
    const anuncios = this.anuncios$.value;
    const anuncio = anuncios.find(a => a.id === id);
    if (anuncio) {
      anuncio.likes++;
      this.anuncios$.next([...anuncios]);
    }
  }
}
