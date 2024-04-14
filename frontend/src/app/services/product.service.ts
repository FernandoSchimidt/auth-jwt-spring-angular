import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  apiURL: string = 'http://localhost:8080/products';
  constructor(private http: HttpClient) {}

  findAll() {
    return this.http.get<any>(this.apiURL).pipe(
      tap((value) => {
        console.log(value);
      })
    );
  }
}
