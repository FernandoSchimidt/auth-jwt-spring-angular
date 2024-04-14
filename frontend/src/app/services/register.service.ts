import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginResponse } from '../types/login-response';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  apiURL: string = 'http://localhost:8080/users';

  constructor(private http: HttpClient) {}
  role: string = 'USER';
  register(name: string, login: string, password: string, role: string) {
    return this.http
      .post<LoginResponse>(this.apiURL, { name, login, password, role })
      .pipe(
        tap((value) => {
          sessionStorage.setItem('auth-token', value.token);
          sessionStorage.setItem('login', value.name);
        })
      );
  }
}
