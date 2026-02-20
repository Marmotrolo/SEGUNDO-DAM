import { Component } from '@angular/core';
import { VehiculoService } from '../../services/vehiculoservice';
import { CommonModule } from '@angular/common';
import { Vehiculo } from '../vehiculo/vehiculo';

@Component({
  selector: 'app-vehiculos',
  standalone: true,
  imports: [CommonModule,Vehiculo],
  templateUrl: './vehiculos.html'
})
export class Vehiculos {

  vehiculos: any[] = [];

  constructor(private vehiculoservice: VehiculoService) {
    this.vehiculos = this.vehiculoservice.getVehiculos();
  }
}