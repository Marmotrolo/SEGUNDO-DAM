import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MensajeService } from '@/services';
import { Conversacion } from '@/interfaces';

@Component({
  selector: 'app-mensajes',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="mensajes-container">
      <h1>Mensajes</h1>
      <div class="conversaciones-list">
        <div class="conversacion-item" *ngFor="let conv of conversaciones" (click)="seleccionarConversacion(conv)">
          <div class="conversacion-header">
            <h3>Conversación {{ conv.id }}</h3>
            <span class="no-leidos" *ngIf="conv.noLeidos > 0">{{ conv.noLeidos }}</span>
          </div>
          <p class="ultimo-mensaje">{{ conv.ultimoMensaje }}</p>
          <p class="fecha">{{ conv.ultimaFecha | date:'short' }}</p>
        </div>
      </div>
      <div class="conversacion-detalle" *ngIf="conversacionSeleccionada">
        <h2>Conversación</h2>
        <div class="mensajes">
          <div class="mensaje" *ngFor="let msg of conversacionSeleccionada.mensajes">
            <strong>{{ msg.emisorNombre }}</strong>
            <p>{{ msg.texto }}</p>
            <small>{{ msg.fecha | date:'short' }}</small>
          </div>
        </div>
        <div class="enviar-mensaje">
          <input type="text" [(ngModel)]="nuevoMensaje" placeholder="Escribe un mensaje..." class="input-mensaje">
          <button (click)="enviarMensaje()" class="btn-enviar">Enviar</button>
        </div>
      </div>
    </div>
  `,
  styles: [`
    .mensajes-container { padding: 20px; }
    .conversaciones-list { display: flex; flex-direction: column; gap: 10px; margin-bottom: 20px; }
    .conversacion-item { border: 1px solid #30363d; border-radius: 8px; padding: 12px; cursor: pointer; transition: background 0.2s; }
    .conversacion-item:hover { background: #161b22; }
    .conversacion-header { display: flex; justify-content: space-between; align-items: center; }
    .conversacion-header h3 { margin: 0; }
    .no-leidos { background: #00d4e8; color: #0d1117; border-radius: 50%; width: 24px; height: 24px; display: flex; align-items: center; justify-content: center; font-size: 12px; font-weight: bold; }
    .ultimo-mensaje { margin: 5px 0; color: #8b949e; font-size: 14px; }
    .fecha { margin: 5px 0; color: #6e7681; font-size: 12px; }
    .conversacion-detalle { border-top: 1px solid #30363d; padding-top: 20px; margin-top: 20px; }
    .mensajes { display: flex; flex-direction: column; gap: 10px; margin-bottom: 20px; max-height: 300px; overflow-y: auto; }
    .mensaje { border: 1px solid #30363d; border-radius: 6px; padding: 10px; }
    .mensaje strong { color: #00d4e8; }
    .mensaje p { margin: 5px 0; }
    .mensaje small { color: #6e7681; }
    .enviar-mensaje { display: flex; gap: 10px; }
    .input-mensaje { flex: 1; padding: 10px; border: 1px solid #30363d; border-radius: 6px; background: #0d1117; color: #c9d1d9; }
    .btn-enviar { padding: 10px 20px; background: #00d4e8; color: #0d1117; border: none; border-radius: 6px; cursor: pointer; font-weight: bold; }
    .btn-enviar:hover { background: #00b8d4; }
  `]
})
export class MensajesComponent implements OnInit {
  conversaciones: Conversacion[] = [];
  conversacionSeleccionada: Conversacion | null = null;
  nuevoMensaje: string = '';

  constructor(private mensajeService: MensajeService) {}

  ngOnInit(): void {
    this.mensajeService.getConversaciones('u1').subscribe(conversaciones => {
      this.conversaciones = conversaciones;
    });
  }

  seleccionarConversacion(conversacion: Conversacion): void {
    this.conversacionSeleccionada = conversacion;
    this.mensajeService.marcarLeida(conversacion.id, 'u1');
  }

  enviarMensaje(): void {
    if (this.nuevoMensaje.trim() && this.conversacionSeleccionada) {
      this.mensajeService.enviar({
        emisorId: 'u1',
        receptorId: this.conversacionSeleccionada.participantes.find(p => p !== 'u1') || '',
        emisorNombre: 'Usuario Actual',
        emisorFoto: 'https://i.pravatar.cc/150?img=11',
        texto: this.nuevoMensaje,
      });
      this.nuevoMensaje = '';
      this.mensajeService.getConversaciones('u1').subscribe(conversaciones => {
        this.conversaciones = conversaciones;
      });
    }
  }
}
