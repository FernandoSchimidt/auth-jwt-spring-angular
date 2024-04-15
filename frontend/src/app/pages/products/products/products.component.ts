import { Component } from '@angular/core';
import { ProductService } from '../../../services/product.service';
import { error } from 'console';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [],
  templateUrl: './products.component.html',
  styleUrl: './products.component.scss',
})
export class ProductsComponent {
  constructor(private productService: ProductService) {
    this.findAll();
  }

  products: any[] = [];
  findAll() {
    // debugger;
    this.productService.findAll().subscribe(
      (res: any) => {
        this.products = res.data;
        // console.log(this.products);
      },
      (error) => {
        alert('Error from API');
      }
    );
  }

  displayedColumns: string[] = ['name', 'value'];
}
