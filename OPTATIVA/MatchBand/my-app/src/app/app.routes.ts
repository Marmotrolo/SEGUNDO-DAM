import { Routes } from '@angular/router';

// MatchBand - Usuarios
import { Usuario } from './usuario/usuario';
/*import { DetalleUsuario } from './components/detalle-usuario/detalle-usuario';
import { CreateUsuario } from './components/create-usuario/create-usuario';
import { EditUsuario } from './components/edit-usuario/edit-usuario';

// MatchBand - Anuncios
import { Anuncio } from './components/anuncio/anuncio';
import { DetalleAnuncio } from './components/detalle-anuncio/detalle-anuncio';
import { CreateAnuncio } from './components/create-anuncio/create-anuncio';
import { EditAnuncio } from './components/edit-anuncio/edit-anuncio';

// MatchBand - Eventos
import { Evento } from './components/evento/evento';
import { DetalleEvento } from './components/detalle-evento/detalle-evento';
import { CreateEvento } from './components/create-evento/create-evento';
import { EditEvento } from './components/edit-evento/edit-evento';
*/
export const routes: Routes = [
  // Ruta por defecto: lista de músicos
  { path: '', component: Usuario, title: 'MatchBand - Músicos' },

  // Usuarios
  { path: 'usuarios', component: Usuario, title: 'Músicos' },
/*  { path: 'usuarios/create', component: CreateUsuario, title: 'Crear Músico' },
  { path: 'usuarios/detalle/:id', component: DetalleUsuario, title: 'Perfil Músico' },
  { path: 'usuarios/edit/:id', component: EditUsuario, title: 'Editar Músico' },

  // Anuncios
  { path: 'anuncios', component: Anuncio, title: 'Anuncios' },
  { path: 'anuncios/create', component: CreateAnuncio, title: 'Crear Anuncio' },
  { path: 'anuncios/detalle/:id', component: DetalleAnuncio, title: 'Detalle Anuncio' },
  { path: 'anuncios/edit/:id', component: EditAnuncio, title: 'Editar Anuncio' },

  // Eventos
  { path: 'eventos', component: Evento, title: 'Eventos' },
  { path: 'eventos/create', component: CreateEvento, title: 'Crear Evento' },
  { path: 'eventos/detalle/:id', component: DetalleEvento, title: 'Detalle Evento' },
  { path: 'eventos/edit/:id', component: EditEvento, title: 'Editar Evento' },
*/];