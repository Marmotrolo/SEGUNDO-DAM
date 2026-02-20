import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-contacto',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './contacto.html'
})
export class Contacto {

  nombre: string = '';

  enviar() {
    alert('Mensaje enviado correctamente');
  }
}