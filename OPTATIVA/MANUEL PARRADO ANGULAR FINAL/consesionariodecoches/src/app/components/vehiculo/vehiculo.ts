import { Component, Input } from '@angular/core';
import { CommonModule  } from '@angular/common';

@Component({
  selector: 'app-vehiculo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './vehiculo.html'
})
export class Vehiculo  {

  @Input() vehiculo: any;
}