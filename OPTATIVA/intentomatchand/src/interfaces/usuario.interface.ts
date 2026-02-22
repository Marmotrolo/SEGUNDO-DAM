export type NivelMusical = 'principiante' | 'intermedio' | 'avanzado' | 'profesional';
export type RolUsuario = 'musico' | 'profesional' | 'admin';

export interface Usuario {
  id: string;
  nombre: string;
  username: string;
  email: string;
  passwordHash: string;
  rol: RolUsuario;
  instrumentoPrincipal: string;
  instrumentosSecundarios: string[];
  generosMusicals: string[];
  nivel: NivelMusical;
  ciudad: string;
  pais: string;
  biografia: string;
  fotoPerfil: string;
  redesSociales: { soundcloud?: string; spotify?: string; youtube?: string; instagram?: string };
  servicios?: string;
  tarifas?: string;
  reputacion?: number;
  totalValoraciones?: number;
  verificado: boolean;
  activo: boolean;
  ultimaConexion: Date;
  fechaRegistro: Date;
}

export interface UsuarioRecomendado {
  usuario: Usuario;
  pts: number;
}

export interface FiltroUsuario {
  ciudad?: string;
  genero?: string;
  instrumento?: string;
  nivel?: string;
}
