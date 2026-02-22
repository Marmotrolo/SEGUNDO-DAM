import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MensajeService } from '@/services';
import { Conversacion } from '@/interfaces';

@Component({
  selector: 'app-mensajes',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './mensajes.component.html',
  styleUrl: './mensajes.component.css'
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
