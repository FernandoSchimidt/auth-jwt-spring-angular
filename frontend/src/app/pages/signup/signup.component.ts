import { Component } from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { RegisterService } from '../../services/register.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';


interface singpForm {
  name: FormControl;
  login: FormControl;
  password: FormControl;
  passwordConfirm: FormControl;
  role: FormControl;
}

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule
  ],
  providers: [RegisterService],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss',
})
export class SignupComponent {
  signupForm!: FormGroup<singpForm>;
  hide = true;
  hide2 = true;

  constructor(
    private router: Router,
    private registerService: RegisterService,
    private toastService: ToastrService
  ) {
    this.signupForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(3)]),
      login: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(3),
      ]),
      passwordConfirm: new FormControl('', [
        Validators.required,
        Validators.minLength(3),
      ]),
      role: new FormControl('USER'),
    });
  }

  submit() {
    this.registerService
      .register(
        this.signupForm.value.name,
        this.signupForm.value.login,
        this.signupForm.value.password,
        this.signupForm.value.role
      )
      .subscribe({
        next: () => {
          this.toastService.success('Success!'), this.navigate();
        },
        error: () => this.toastService.error('Error to create!'),
      });
  }

  navigate() {
    this.router.navigate(['/login']);
  }
}
