import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthenticationService } from '../../services/authentication/authentication-service';
import { User } from '../../models/user';
import { Router } from '@angular/router';
import { RoleEnum } from '../../models/RoleEnum';

@Component({
  selector: 'app-login-page',
  imports: [ReactiveFormsModule],
  templateUrl: './login-page.html',
  styleUrl: './login-page.css',
})
export class LoginPage implements OnInit {
  formGroup = new FormGroup({});
  errorMessage: string = '';

  constructor(
    private authenticationService: AuthenticationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.formGroup.addControl('username', new FormControl('', [Validators.required]));
    this.formGroup.addControl('password', new FormControl('', [Validators.required]));
  }

  login() {
    this.formGroup.markAllAsTouched();
    if (this.formGroup.valid) {
      const username = this.formGroup.get('username')?.value ?? '';
      const password = this.formGroup.get('password')?.value ?? '';
      const user = new User(0, username, password);
      
      this.handleAuthentication(user);
    } else {
      this.handleErrors();
    }
  }

  private handleAuthentication(user: User) {
    this.authenticationService.login(user).subscribe(() => this.router.navigate(['/shop']));
  }

  private handleErrors() {
    let usernameMissing = this.formGroup.get('username')?.errors?.['required'];
    let passwordMissing = this.formGroup.get('password')?.errors?.['required'];

    if (usernameMissing) {
        this.errorMessage = 'Username is required.';
        if (passwordMissing) {
          this.errorMessage = 'Please enter your username and password.';
        }
      } else if (passwordMissing) {
        this.errorMessage = 'Password is required.';
      }
  }
}
