export interface Anunciointerface {
  id?: string;
  titulo: string;
  descripcion: string;
  tipo: string;
  generoMusical: string;
  instrumento: string;
  ciudad: string;
  autorId: string;
  autorNombre: string;
  precio?: string;
  activo?: boolean;
  fechaPublicacion?: string;
}
