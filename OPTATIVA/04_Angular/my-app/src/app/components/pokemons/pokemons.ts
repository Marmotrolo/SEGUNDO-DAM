import { Component, Input } from '@angular/core';
import { Pokemonsinterface } from '../pokemonsinterface';
@Component({
  selector: 'app-pokemons',
  imports: [],
  templateUrl: './pokemons.html',
  styleUrl: './pokemons.css',
})
export class Pokemons {
  title: string="Mira mi webo"
  
    @Input() pokemons!: Pokemonsinterface;
   }


