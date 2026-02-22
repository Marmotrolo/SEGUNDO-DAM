import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="login-container">
      <div class="login-box">
        <h1>MatchBand</h1>
        <p class="subtitle">Red Social de Músicos</p>
        <form (ngSubmit)="login()">
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" [(ngModel)]="email" name="email" placeholder="tu@email.com" required>
          </div>
          <div class="form-group">
            <label for="password">Contraseña</label>
            <input type="password" id="password" [(ngModel)]="password" name="password" placeholder="••••••••" required>
          </div>
          <button type="submit" class="btn-login">Iniciar Sesión</button>
        </form>
        <p class="register-link">
          ¿No tienes cuenta? <a (click)="irARegistro()">Regístrate aquí</a>
        </p>
      </div>
    </div>
  `,
  styles: [`
    .login-container { display: flex; align-items: center; justify-content: center; min-height: 100vh; background: #0d1117; }
    .login-box { background: #161b22; border: 1px solid #30363d; border-radius: 12px; padding: 40px; width: 100%; max-width: 400px; }
    .login-box h1 { text-align: center; color: #00d4e8; margin: 0 0 5px; }
    .subtitle { text-align: center; color: #8b949e; margin: 0 0 30px; }
    .form-group { margin-bottom: 20px; }
    .form-group label { display: block; margin-bottom: 8px; color: #c9d1d9; font-weight: 500; }
    .form-group input { width: 100%; padding: 10px; border: 1px solid #30363d; border-radius: 6px; background: #0d1117; color: #c9d1d9; box-sizing: border-box; }
    .form-group input:focus { outline: none; border-color: #00d4e8; }
    .btn-login { width: 100%; padding: 12px; background: #00d4e8; color: #0d1117; border: none; border-radius: 6px; cursor: pointer; font-weight: bold; font-size: 16px; margin-top: 10px; }
    .btn-login:hover { background: #00b8d4; }
    .register-link { text-align: center; color: #8b949e; margin-top: 20px; }
    .register-link a { color: #00d4e8; cursor: pointer; text-decoration: none; }
    .register-link a:hover { text-decoration: underline; }
  `]
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private router: Router) {}

  login(): void {
    if (this.email && this.password) {
      this.router.navigate(['/home']);
    }
  }

  irARegistro(): void {
    this.router.navigate(['/register']);
  }
}
