import { Component, inject, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Usuariointerface } from '../interfaces/usuariointerface';
import { Usuarioservice } from '../services/usuarioservice';
import { Usuarios } from '../usuarios/usuarios';

@Component({
  selector: 'app-usuario',
  imports: [CommonModule, Usuarios, RouterModule],
  templateUrl: './usuario.html',
  styleUrl: './usuario.css',
})
export class Usuario implements OnInit {
  usuariolista: Usuariointerface[] = [];
  filteredusuariolista: Usuariointerface[] = [];
  usuarioservice: Usuarioservice = inject(Usuarioservice);
  private cdr = inject(ChangeDetectorRef);

  constructor() {}

  ngOnInit(): void {
    this.usuarioservice.getallusuarios()
      .then((datos: Usuariointerface[]) => {
        this.usuariolista = datos;
        this.filteredusuariolista = datos;
        this.cdr.detectChanges();
      })
      .catch(error => {
        console.error('Error al cargar usuarios:', error);
      });
  }

  onsearch(busqueda: string) {
    if (!busqueda) {
      this.filteredusuariolista = this.usuariolista;
      return;
    }
    this.filteredusuariolista = this.usuariolista.filter(u =>
      u.nombre.toLowerCase().includes(busqueda.toLowerCase()) ||
      u.instrumento.toLowerCase().includes(busqueda.toLowerCase()) ||
      u.ciudad.toLowerCase().includes(busqueda.toLowerCase())
    );
  }
}