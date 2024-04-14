import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { ProductsComponent } from './pages/products/products/products.component';
import { SignupComponent } from './pages/signup/signup.component';
import { AuthGurdService } from './services/auth-gurd.service';
export const routes: Routes = [
  { path: '', component: LoginComponent, pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  {
    path: 'products',
    component: ProductsComponent,
    canActivate: [AuthGurdService],
  },
];
