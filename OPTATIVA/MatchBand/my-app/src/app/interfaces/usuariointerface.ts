export interface Usuariointerface {
  id?: string;
  nombre: string;
  email: string;
  instrumento: string;
  generoMusical: string;
  nivel: string;
  ciudad: string;
  foto: string;
  rol: string;
  verificado?: boolean;
  activo?: boolean;
  reputacion?: number;
  bio?: string;
  redesSociales?: string;
  tarifa?: string;
}
