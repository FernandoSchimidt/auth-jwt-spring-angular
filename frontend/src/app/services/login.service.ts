import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginResponse } from '../types/login-response';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  apiURL: string = 'http://localhost:8080/auth';
  constructor(private http: HttpClient) {}

  login(login: string, password: string) {
    return this.http.post<any>(this.apiURL, { login, password }).pipe(
      tap((value) => {
        sessionStorage.setItem('auth-token', value.token);
        sessionStorage.setItem('login', value.login);
      })
    );
  }
}
