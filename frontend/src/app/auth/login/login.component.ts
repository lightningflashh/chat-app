import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { User } from '../../core/interfaces/user';
import { CommonModule } from '@angular/common';
import { UserService } from '../../core/services/user.service';
import { Router } from '@angular/router';
import { StyleClassModule } from 'primeng/styleclass';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, ButtonModule, InputTextModule, PasswordModule, CommonModule, StyleClassModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  user: User = {
    username: '',
    password: ''
  }

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  login() {
    if (!this.user.username || !this.user.password) return;

    this.user.username = this.user.username.trim();
    this.user.password = this.user.password.trim();

    this.userService.login(this.user).subscribe({
      next: (user: User) => {
        this.userService.saveToLocalStorage(user);
        this.router.navigate(['/']);
      },
      error: (error) => {
        console.error('Login failed', error);
      }
    });
  }
}

