import { Component } from '@angular/core';
import { Pokemonsinterface } from '../pokemonsinterface';
import { CommonModule } from '@angular/common';
import { Pokemons } from '../pokemons/pokemons';
@Component({
  selector: 'app-pokemon',
  imports: [CommonModule, Pokemons],
  templateUrl: './pokemon.html',
  styleUrl: './pokemon.css',
})
export class Pokemon {
  readonly imgBaseUrl = 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/';
  pokemonslista:Pokemonsinterface[]=[
{
      nombre: 'Zekrom',
      tipo: 'Dragón, Eléctrico',
      description: 'Está to guapo',
      photo: `${this.imgBaseUrl}644.png` // ID de Zekrom
    },
    {
      nombre: 'Reshiram',
      tipo: 'Dragón, Fuego',
      description: 'El portador de la realidad',
      photo: `${this.imgBaseUrl}643.png` // ID de Reshiram
    },
    {
      nombre: 'Pikachu',
      tipo: 'Eléctrico',
      description: 'El ratón amarillo',
      photo: `${this.imgBaseUrl}25.png`  // ID de Pikachu
    },
    {
      nombre: 'Charizard',
      tipo: 'Fuego, Volador',
      description: 'El clásico favorito',
      photo: `${this.imgBaseUrl}6.png`   // ID de Charizard
    },
    {
      nombre: 'Lucario',
      tipo: 'Lucha, Acero',
      description: 'Maestro del aura',
      photo: `${this.imgBaseUrl}448.png` // ID de Lucario
    }
]
}