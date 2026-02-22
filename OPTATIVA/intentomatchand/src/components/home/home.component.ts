import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioService } from '@/services';
import { UsuarioRecomendado } from '@/interfaces';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
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
