import { inject, Service, signal } from "@angular/core";
import { User } from "../../models/user";
import { from, Observable } from "rxjs";
import { Router } from "@angular/router";

@Service()
export class AuthenticationService {
    path: string = 'http://localhost:8080/users';
    userSignal = signal(new User());
    isAuthenticated = signal(false);
    router = inject(Router);

    login(user: User): Observable<User> {
        return from(
            fetch(`${this.path}/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            }).then(response => {
                if (!response.ok) {
                    throw new Error('Login failed');
                }
                return response.json().then(data => {
                    const user = data as User;
                    this.userSignal.set(user);
                    this.isAuthenticated.set(true);
                    return user;
                });
            })
        );
    }

    register(user: User): Observable<User> {
        return from(
            fetch(`${this.path}/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        }).then(response => {
            if (!response.ok) {
                throw new Error('Registration failed');
            }
            return response.json();
        }));
    }

    logOut() {
        this.userSignal.set(new User());
        this.isAuthenticated.set(false);
        this.router.navigate(['/shop']);
    }
}