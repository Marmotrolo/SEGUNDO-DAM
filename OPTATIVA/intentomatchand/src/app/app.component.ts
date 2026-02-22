import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, CommonModule],
  styles: [`
    .app-shell { display:flex; flex-direction:column; min-height:100vh; max-width:430px; margin:0 auto; background:#0d1117; position:relative; }
    .bottom-nav { position:fixed; bottom:0; left:50%; transform:translateX(-50%); width:100%; max-width:430px; height:68px; background:#111820; border-top:1px solid rgba(255,255,255,0.07); display:flex; align-items:center; justify-content:space-around; z-index:100; }
    .nav-item { display:flex; flex-direction:column; align-items:center; gap:4px; cursor:pointer; padding:8px 16px; text-decoration:none; color:#7d8590; font-size:11px; font-family:'DM Sans',sans-serif; transition:color .2s; }
    .nav-item svg { width:22px; height:22px; stroke:#7d8590; transition:stroke .2s; }
    .nav-item.active { color:#00d4e8; }
    .nav-item.active svg { stroke:#00d4e8; }
    .content { flex:1; padding-bottom:68px; }
  `],
  template: `
    <div class="app-shell">
      <div class="content">
        <router-outlet/>
      </div>
      <nav class="bottom-nav" *ngIf="mostrarNav">
        <a routerLink="/eventos" routerLinkActive="active" class="nav-item">
          <svg viewBox="0 0 24 24" fill="none" stroke-width="1.8" stroke-linecap="round">
            <rect x="3" y="4" width="18" height="18" rx="2"/><line x1="16" y1="2" x2="16" y2="6"/><line x1="8" y1="2" x2="8" y2="6"/><line x1="3" y1="10" x2="21" y2="10"/>
          </svg>
          Eventos
        </a>
        <a routerLink="/buscar" routerLinkActive="active" class="nav-item">
          <svg viewBox="0 0 24 24" fill="none" stroke-width="1.8" stroke-linecap="round">
            <circle cx="11" cy="11" r="7"/><line x1="21" y1="21" x2="16.65" y2="16.65"/>
          </svg>
          Buscar
        </a>
        <a routerLink="/home" routerLinkActive="active" class="nav-item">
          <svg viewBox="0 0 24 24" fill="none" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round">
            <path d="M3 9.5L12 3l9 6.5V20a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V9.5z"/>
          </svg>
          Inicio
        </a>
        <a routerLink="/mensajes" routerLinkActive="active" class="nav-item">
          <svg viewBox="0 0 24 24" fill="none" stroke-width="1.8" stroke-linecap="round">
            <path d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z"/>
          </svg>
          Mensajes
        </a>
        <a routerLink="/perfil" routerLinkActive="active" class="nav-item">
          <svg viewBox="0 0 24 24" fill="none" stroke-width="1.8" stroke-linecap="round">
            <circle cx="12" cy="8" r="4"/><path d="M4 20c0-4 3.6-7 8-7s8 3 8 7"/>
          </svg>
          Perfil
        </a>
      </nav>
    </div>
  `,
})
export class AppComponent {
  get mostrarNav(): boolean {
    const ruta = location.pathname;
    return !ruta.startsWith('/login') && !ruta.startsWith('/register') && !ruta.startsWith('/onboarding');
  }
}
