import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router, RouterLink} from '@angular/router';
import {Auth} from '../../../core/services/auth';
import {CommonModule} from '@angular/common';

@Component({
  imports: [CommonModule,FormsModule,RouterLink],
  selector: 'app-register',
  styleUrl: './register.scss',
  templateUrl: './register.html',
})
export class Register {
  name:string='';
  email:string='';
  password:string='';
  confirmPassword:string='';

  errorMessage:string='';
  successMessage:string='';
  constructor(private auth:Auth,private router:Router){}
  register(){
    this.errorMessage='';
    this.successMessage='';
    if(this.password!==this.confirmPassword){
      this.errorMessage='Passwords do not match';
      return;
    }
    const user={
      name:this.name,
      email:this.email,
      password:this.password
    };
    this.auth.register(user).subscribe({
      next:(response)=>{
        this.successMessage=response.message;
        alert('Registration successful! Please login.');
        this.router.navigate(['/login']);
      },
      error:(error)=>{
        this.errorMessage=
          error.error?.message||'Registration failed. Please try again.';
      }
    })
  }
}
