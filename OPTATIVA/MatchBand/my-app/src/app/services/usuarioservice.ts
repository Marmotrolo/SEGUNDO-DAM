import { Injectable } from '@angular/core';
import { Usuariointerface } from '../interfaces/usuariointerface';

@Injectable({
  providedIn: 'root',
})
export class Usuarioservice {
  constructor() {}

  url = 'http://localhost:3000/usuarios';

  async getallusuarios(): Promise<Usuariointerface[]> {
    try {
      const response = await fetch(this.url);
      if (!response.ok) throw new Error('Error al obtener usuarios');
      return await response.json();
    } catch (error) {
      console.error('Error en getallusuarios:', error);
      return [];
    }
  }

  async getusuariopornombre(nombre: string): Promise<Usuariointerface | undefined> {
    try {
      const response = await fetch(`${this.url}/${nombre}`);
      if (!response.ok) throw new Error('Error al buscar usuario');
      return await response.json();
    } catch (error) {
      console.error('Error en getusuariopornombre:', error);
      return undefined;
    }
  }

  async createUsuario(usuario: Usuariointerface): Promise<Usuariointerface | null> {
    try {
      const response = await fetch(this.url, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          ...usuario,
          verificado: false,
          activo: true,
          reputacion: 0,
        })
      });
      if (!response.ok) throw new Error('Error al crear usuario');
      const created = await response.json();
      console.log('Usuario creado:', created);
      return created;
    } catch (error) {
      console.error('Error en createUsuario:', error);
      return null;
    }
  }

  async updateUsuario(nombre: string, usuarioActualizado: Usuariointerface): Promise<Usuariointerface | null> {
    try {
      const response = await fetch(`${this.url}/${nombre}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ ...usuarioActualizado, nombre })
      });
      if (!response.ok) throw new Error('Error al actualizar usuario');
      const updated = await response.json();
      console.log('Usuario actualizado:', updated);
      return updated;
    } catch (error) {
      console.error('Error en updateUsuario:', error);
      return null;
    }
  }

  async deleteUsuario(nombre: string): Promise<boolean> {
    try {
      const response = await fetch(`${this.url}/${nombre}`, { method: 'DELETE' });
      if (!response.ok) throw new Error('Error al eliminar usuario');
      console.log('Usuario eliminado correctamente');
      return true;
    } catch (error) {
      console.error('Error en deleteUsuario:', error);
      return false;
    }
  }
}
