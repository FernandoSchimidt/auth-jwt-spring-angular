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

  poducts: any[] = [];
  findAll() {
    debugger;
    this.productService.findAll().subscribe((res:any) => {
      this.poducts = res.data;
      console.log(this.poducts);

    },error=>{
      alert("Error from API")
    });
  }
}
