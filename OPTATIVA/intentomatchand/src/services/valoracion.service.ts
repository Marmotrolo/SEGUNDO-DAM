import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Valoracion, ValoracionCrear } from '@/interfaces';

@Injectable({ providedIn: 'root' })
export class ValoracionService {
  private valoraciones$ = new BehaviorSubject<Valoracion[]>([]);

  constructor() {}

  getAll(): Observable<Valoracion[]> {
    return this.valoraciones$.asObservable();
  }

  getByReceptor(receptorId: string): Observable<Valoracion[]> {
    return new Observable((observer: any) => {
      const valoraciones = this.valoraciones$.value.filter((v: Valoracion) => v.receptorId === receptorId);
      observer.next(valoraciones);
      observer.complete();
    });
  }

  crear(datos: ValoracionCrear): void {
    const nuevaValoracion: Valoracion = {
      ...datos,
      id: `v${Date.now()}`,
      fecha: new Date(),
    };
    const valoraciones = this.valoraciones$.value;
    this.valoraciones$.next([...valoraciones, nuevaValoracion]);
  }

  getPromedioReceptor(receptorId: string): Observable<number> {
    return new Observable((observer: any) => {
      const valoraciones = this.valoraciones$.value.filter((v: Valoracion) => v.receptorId === receptorId);
      if (valoraciones.length === 0) {
        observer.next(0);
        observer.complete();
        return;
      }
      const promedio = valoraciones.reduce((sum: number, v: Valoracion) => sum + v.puntuacion, 0) / valoraciones.length;
      observer.next(promedio);
      observer.complete();
    });
  }
}
