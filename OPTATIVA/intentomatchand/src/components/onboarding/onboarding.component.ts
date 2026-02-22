import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-onboarding',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './onboarding.component.html',
  styleUrl: './onboarding.component.css'
})
export class OnboardingComponent {
  generos: string = '';
  nivel: string = '';
  ciudad: string = '';
  biografia: string = '';

  constructor(private router: Router) {}

  completarPerfil(): void {
    if (this.generos && this.nivel && this.ciudad && this.biografia) {
      this.router.navigate(['/home']);
    }
  }
}
