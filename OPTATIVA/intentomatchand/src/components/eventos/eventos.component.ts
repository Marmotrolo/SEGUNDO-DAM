import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventoService } from '@/services';
import { Evento } from '@/interfaces';

@Component({
  selector: 'app-eventos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './eventos.component.html',
  styleUrl: './eventos.component.css'
})
export class EventosComponent implements OnInit {
  eventos: Evento[] = [];

  constructor(private eventoService: EventoService) {}

  ngOnInit(): void {
    this.eventoService.getAll().subscribe(eventos => {
      this.eventos = eventos;
    });
  }

  confirmarAsistencia(eventoId: string): void {
    this.eventoService.confirmar(eventoId, 'u1');
    this.eventoService.getAll().subscribe(eventos => {
      this.eventos = eventos;
    });
  }
}
