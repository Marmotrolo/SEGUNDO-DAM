import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioService, ValoracionService } from '@/services';
import { Usuario, Valoracion } from '@/interfaces';

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css'
})
export class PerfilComponent implements OnInit {
  usuario: Usuario | undefined;
  valoraciones: Valoracion[] = [];
  promedioValoraciones: number = 0;

  constructor(private usuarioService: UsuarioService, private valoracionService: ValoracionService) {}

  ngOnInit(): void {
    this.usuarioService.getUsuarioActual().subscribe(usuario => {
      this.usuario = usuario;
      this.valoracionService.getByReceptor(usuario.id).subscribe(valoraciones => {
        this.valoraciones = valoraciones;
      });
      this.valoracionService.getPromedioReceptor(usuario.id).subscribe(promedio => {
        this.promedioValoraciones = promedio;
      });
    });
  }
}
