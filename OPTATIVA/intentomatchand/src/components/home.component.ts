import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioService } from '@/services';
import { Usuario, UsuarioRecomendado } from '@/interfaces';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="home-container">
      <h1>Inicio</h1>
      <div class="recomendados">
        <h2>Músicos Recomendados</h2>
        <div class="usuario-card" *ngFor="let rec of recomendados">
          <img [src]="rec.usuario.fotoPerfil" [alt]="rec.usuario.nombre">
          <h3>{{ rec.usuario.nombre }}</h3>
          <p>{{ rec.usuario.instrumentoPrincipal }}</p>
          <p class="ciudad">{{ rec.usuario.ciudad }}</p>
          <p class="puntos">Compatibilidad: {{ rec.pts }} pts</p>
        </div>
      </div>
    </div>
  `,
  styles: [`
    .home-container { padding: 20px; }
    .recomendados { margin-top: 20px; }
    .usuario-card { border: 1px solid #30363d; border-radius: 8px; padding: 15px; margin-bottom: 15px; }
    .usuario-card img { width: 100%; height: 200px; object-fit: cover; border-radius: 8px; }
    .usuario-card h3 { margin: 10px 0 5px; }
    .usuario-card p { margin: 5px 0; font-size: 14px; color: #8b949e; }
    .ciudad { font-weight: 500; }
    .puntos { color: #00d4e8; font-weight: bold; }
  `]
})
export class HomeComponent implements OnInit {
  recomendados: UsuarioRecomendado[] = [];

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.usuarioService.getRecomendados('u1').subscribe(recomendados => {
      this.recomendados = recomendados;
    });
  }
}
