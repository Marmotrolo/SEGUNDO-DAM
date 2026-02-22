import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  nombre: string = '';
  username: string = '';
  email: string = '';
  password: string = '';
  instrumento: string = '';

  constructor(private router: Router) {}

  registrar(): void {
    if (this.nombre && this.username && this.email && this.password && this.instrumento) {
      this.router.navigate(['/onboarding']);
    }
  }

  irALogin(): void {
    this.router.navigate(['/login']);
  }
}
