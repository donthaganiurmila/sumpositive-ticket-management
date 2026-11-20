import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router, RouterLink} from '@angular/router';
import {CommonModule} from '@angular/common';
import {Auth} from '../../../core/services/auth';

@Component({
  imports: [CommonModule,FormsModule,RouterLink],
  selector: 'app-login',
  styleUrl: './login.scss',
  templateUrl: './login.html',
})
export class Login {
  email: string = '';
  password: string = '';

  errorMessage: string = '';
  isLoading: boolean = false;

  constructor(private auth: Auth, private router: Router) {
  }

  login() {
    this.errorMessage = '';
    this.isLoading = true;
    const credentials = {
      email: this.email,
      password: this.password
    };

    this.auth.login(credentials).subscribe({
      next: (response) => {
        localStorage.setItem('token', response.token);
        this.isLoading = false;
        this.router.navigate(['/dashboard']);

      },
      error: (error) => {

        this.isLoading = false;

        this.errorMessage =
          error.error?.message || 'Invalid email or password';

      }

    });

  }
}
