import { Routes } from '@angular/router';
import { AppComponent } from './app.component';

export const routes: Routes = [
  {
    path: '',
    component: AppComponent,
    children: [
      { path: 'home', loadComponent: () => import('@/components/home/home.component').then(m => m.HomeComponent) },
      { path: 'buscar', loadComponent: () => import('@/components/buscar/buscar.component').then(m => m.BuscarComponent) },
      { path: 'eventos', loadComponent: () => import('@/components/eventos/eventos.component').then(m => m.EventosComponent) },
      { path: 'mensajes', loadComponent: () => import('@/components/mensajes/mensajes.component').then(m => m.MensajesComponent) },
      { path: 'perfil', loadComponent: () => import('@/components/perfil/perfil.component').then(m => m.PerfilComponent) },
    ]
  },
  { path: 'login', loadComponent: () => import('@/components/login/login.component').then(m => m.LoginComponent) },
  { path: 'register', loadComponent: () => import('@/components/register/register.component').then(m => m.RegisterComponent) },
  { path: 'onboarding', loadComponent: () => import('@/components/onboarding/onboarding.component').then(m => m.OnboardingComponent) },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];
