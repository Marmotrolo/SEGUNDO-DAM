import { Routes } from '@angular/router';
import { Inicio } from './components/inicio/inicio';
import { Quienessomos } from './components/quienessomos/quienessomos';
import { Vehiculos } from './components/vehiculos/vehiculos';
import { Contacto } from './components/contacto/contacto';

export const routes: Routes = [
  { path: '', component: Inicio },
  { path: 'quienes-somos', component: Quienessomos },
  { path: 'vehiculos', component: Vehiculos },
  { path: 'contacto', component: Contacto },
  { path: '**', redirectTo: '' }
];