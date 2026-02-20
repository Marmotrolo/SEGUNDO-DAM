import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VehiculoService {

 private vehiculos = [
  {
    marca: 'BMW',
    modelo: 'Serie 1',
    precio: 25000,
    disponible: true,
    imagen: 'https://www.topgear.com/sites/default/files/cars-car/image/2022/09/1-BMW-3-Series.jpg?w=1280&h=720'
  },
  {
    marca: 'Audi',
    modelo: 'A3',
    precio: 23000,
    disponible: false,
    imagen: 'https://tse1.mm.bing.net/th/id/OIP.ORf0Ii4rUWD21UQGq6qN3gHaF4?rs=1&pid=ImgDetMain&o=7&rm=3'
  },
  {
    marca: 'Toyota',
    modelo: 'Yaris',
    precio: 18000,
    disponible: true,
    imagen: 'https://media.toyota.co.uk/wp-content/uploads/sites/5/2022/09/Yaris-GR_068-scaled.jpg  '
  }
];

  getVehiculos() {
    return this.vehiculos;
  }
}