import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '@/services';
import { Usuario, FiltroUsuario } from '@/interfaces';

@Component({
  selector: 'app-buscar',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="buscar-container">
      <h1>Buscar Músicos</h1>
      <div class="filtros">
        <input type="text" [(ngModel)]="filtro.ciudad" placeholder="Ciudad" class="filtro-input">
        <input type="text" [(ngModel)]="filtro.genero" placeholder="Género" class="filtro-input">
        <input type="text" [(ngModel)]="filtro.instrumento" placeholder="Instrumento" class="filtro-input">
        <select [(ngModel)]="filtro.nivel" class="filtro-input">
          <option value="">Nivel</option>
          <option value="principiante">Principiante</option>
          <option value="intermedio">Intermedio</option>
          <option value="avanzado">Avanzado</option>
          <option value="profesional">Profesional</option>
        </select>
        <button (click)="buscar()" class="btn-buscar">Buscar</button>
      </div>
      <div class="resultados">
        <div class="usuario-card" *ngFor="let usuario of usuarios">
          <img [src]="usuario.fotoPerfil" [alt]="usuario.nombre">
          <h3>{{ usuario.nombre }}</h3>
          <p>{{ usuario.instrumentoPrincipal }}</p>
          <p class="ciudad">{{ usuario.ciudad }}</p>
          <p class="generos">{{ usuario.generosMusicals.join(', ') }}</p>
          <p class="nivel">Nivel: {{ usuario.nivel }}</p>
        </div>
      </div>
    </div>
  `,
  styles: [`
    .buscar-container { padding: 20px; }
    .filtros { display: flex; flex-direction: column; gap: 10px; margin-bottom: 20px; }
    .filtro-input { padding: 10px; border: 1px solid #30363d; border-radius: 6px; background: #0d1117; color: #c9d1d9; }
    .btn-buscar { padding: 10px 20px; background: #00d4e8; color: #0d1117; border: none; border-radius: 6px; cursor: pointer; font-weight: bold; }
    .btn-buscar:hover { background: #00b8d4; }
    .resultados { display: flex; flex-direction: column; gap: 15px; }
    .usuario-card { border: 1px solid #30363d; border-radius: 8px; padding: 15px; }
    .usuario-card img { width: 100%; height: 200px; object-fit: cover; border-radius: 8px; }
    .usuario-card h3 { margin: 10px 0 5px; }
    .usuario-card p { margin: 5px 0; font-size: 14px; color: #8b949e; }
    .ciudad { font-weight: 500; }
    .generos { font-size: 12px; }
    .nivel { color: #00d4e8; font-weight: bold; }
  `]
})
export class BuscarComponent implements OnInit {
  usuarios: Usuario[] = [];
  filtro: FiltroUsuario = {};

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.buscar();
  }

  buscar(): void {
    this.usuarioService.filtrar(this.filtro).subscribe(usuarios => {
      this.usuarios = usuarios;
    });
  }
}
