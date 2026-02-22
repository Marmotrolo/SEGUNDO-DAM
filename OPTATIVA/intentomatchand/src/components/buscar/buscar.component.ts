import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '@/services';
import { Usuario, FiltroUsuario } from '@/interfaces';

@Component({
  selector: 'app-buscar',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './buscar.component.html',
  styleUrl: './buscar.component.css'
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
