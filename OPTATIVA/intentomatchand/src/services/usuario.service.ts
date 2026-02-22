import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Usuario, UsuarioRecomendado, FiltroUsuario } from '@/interfaces';

@Injectable({ providedIn: 'root' })
export class UsuarioService {
  private usuarioActualId = 'u1';
  private usuarios$ = new BehaviorSubject<Usuario[]>([
    {
      id: 'u1',
      nombre: 'Manuel Parrado',
      username: 'manolo_p',
      email: 'manuel@matchband.com',
      passwordHash: '1234',
      rol: 'musico',
      instrumentoPrincipal: 'Guitarra eléctrica',
      instrumentosSecundarios: ['Voz', 'Sintetizador'],
      generosMusicals: ['Indie Rock', 'Alternative', 'Post-Punk'],
      nivel: 'intermedio',
      ciudad: 'Sevilla',
      pais: 'España',
      biografia: 'Músico autodidacta buscando banda estable. Me gustan los proyectos serios con ensayos regulares.',
      fotoPerfil: 'https://i.pravatar.cc/150?img=11',
      redesSociales: { instagram: 'manolo_p' },
      verificado: true,
      activo: true,
      ultimaConexion: new Date('2026-02-22'),
      fechaRegistro: new Date('2025-09-01'),
    },
    {
      id: 'u2',
      nombre: 'Carlos Ruiz',
      username: 'carlos_r',
      email: 'carlos@matchband.com',
      passwordHash: '1234',
      rol: 'musico',
      instrumentoPrincipal: 'Guitarra',
      instrumentosSecundarios: [],
      generosMusicals: ['Rock', 'Blues'],
      nivel: 'avanzado',
      ciudad: 'Madrid',
      pais: 'España',
      biografia: 'Guitarrista con 10 años de experiencia. Busco proyecto de rock serio.',
      fotoPerfil: 'https://i.pravatar.cc/150?img=3',
      redesSociales: { soundcloud: 'carlos_ruiz' },
      verificado: true,
      activo: true,
      ultimaConexion: new Date('2026-02-21'),
      fechaRegistro: new Date('2025-08-10'),
    },
    {
      id: 'u3',
      nombre: 'Victoria Garcia',
      username: 'vic_garcia',
      email: 'victoria@matchband.com',
      passwordHash: '1234',
      rol: 'musico',
      instrumentoPrincipal: 'Voz',
      instrumentosSecundarios: ['Piano'],
      generosMusicals: ['Pop', 'Soul', 'Jazz'],
      nivel: 'avanzado',
      ciudad: 'Madrid',
      pais: 'España',
      biografia: 'Cantante con formación clásica. Busco banda o proyecto musical colaborativo.',
      fotoPerfil: 'https://i.pravatar.cc/150?img=5',
      redesSociales: { instagram: 'vic_garcia', youtube: 'VictoriaGarciaMusic' },
      verificado: true,
      activo: true,
      ultimaConexion: new Date('2026-02-20'),
      fechaRegistro: new Date('2025-10-01'),
    },
    {
      id: 'u4',
      nombre: 'Mr White',
      username: 'mrwhite',
      email: 'mrwhite@matchband.com',
      passwordHash: '1234',
      rol: 'musico',
      instrumentoPrincipal: 'Batería',
      instrumentosSecundarios: [],
      generosMusicals: ['Metal', 'Hard Rock', 'Punk'],
      nivel: 'profesional',
      ciudad: 'Barcelona',
      pais: 'España',
      biografia: 'Baterista profesional. Disponible para directos y grabaciones.',
      fotoPerfil: 'https://i.pravatar.cc/150?img=8',
      redesSociales: {},
      verificado: true,
      activo: true,
      ultimaConexion: new Date('2026-02-19'),
      fechaRegistro: new Date('2025-07-15'),
    },
    {
      id: 'u5',
      nombre: 'Luis Parrado',
      username: 'luis_p',
      email: 'luis@matchband.com',
      passwordHash: '1234',
      rol: 'musico',
      instrumentoPrincipal: 'Guitarra',
      instrumentosSecundarios: ['Bajo'],
      generosMusicals: ['Rock', 'Alternative'],
      nivel: 'intermedio',
      ciudad: 'Sevilla',
      pais: 'España',
      biografia: 'Guitarrista sevillano. Organizador de eventos y jams locales.',
      fotoPerfil: 'https://i.pravatar.cc/150?img=15',
      redesSociales: { instagram: 'luis_p' },
      verificado: true,
      activo: true,
      ultimaConexion: new Date('2026-02-22'),
      fechaRegistro: new Date('2025-09-20'),
    },
  ]);

  constructor() {}

  getAll(): Observable<Usuario[]> {
    return this.usuarios$.asObservable();
  }

  getById(id: string): Observable<Usuario | undefined> {
    return new Observable(observer => {
      const usuario = this.usuarios$.value.find(u => u.id === id);
      observer.next(usuario);
      observer.complete();
    });
  }

  getUsuarioActual(): Observable<Usuario> {
    return new Observable(observer => {
      const usuario = this.usuarios$.value.find(u => u.id === this.usuarioActualId);
      if (usuario) {
        observer.next(usuario);
      }
      observer.complete();
    });
  }

  actualizar(usuario: Usuario): void {
    const usuarios = this.usuarios$.value;
    const index = usuarios.findIndex(u => u.id === usuario.id);
    if (index !== -1) {
      usuarios[index] = usuario;
      this.usuarios$.next([...usuarios]);
    }
  }

  getRecomendados(actualId: string): Observable<UsuarioRecomendado[]> {
    return new Observable((observer: any) => {
      const actual = this.usuarios$.value.find(u => u.id === actualId);
      if (!actual) {
        observer.next([]);
        observer.complete();
        return;
      }

      const recomendados = this.usuarios$.value
        .filter((u: Usuario) => u.id !== actualId && u.activo && u.verificado)
        .map((u: Usuario) => {
          let pts = 0;
          pts += u.generosMusicals.filter((g: string) => actual.generosMusicals.includes(g)).length * 2;
          if (u.ciudad.toLowerCase() === actual.ciudad.toLowerCase()) pts += 3;
          return { usuario: u, pts };
        })
        .filter((r: any) => r.pts > 0)
        .sort((a: any, b: any) => b.pts - a.pts);

      observer.next(recomendados);
      observer.complete();
    });
  }

  filtrar(filtro: FiltroUsuario): Observable<Usuario[]> {
    return new Observable((observer: any) => {
      const resultado = this.usuarios$.value.filter((u: Usuario) => {
        if (filtro.ciudad && !u.ciudad.toLowerCase().includes(filtro.ciudad.toLowerCase())) return false;
        if (filtro.genero && !u.generosMusicals.some((g: string) => g.toLowerCase().includes(filtro.genero!.toLowerCase())))
          return false;
        if (
          filtro.instrumento &&
          !u.instrumentoPrincipal.toLowerCase().includes(filtro.instrumento.toLowerCase()) &&
          !u.instrumentosSecundarios.some((i: string) => i.toLowerCase().includes(filtro.instrumento!.toLowerCase()))
        )
          return false;
        if (filtro.nivel && u.nivel !== filtro.nivel) return false;
        return true;
      });

      observer.next(resultado);
      observer.complete();
    });
  }
}
