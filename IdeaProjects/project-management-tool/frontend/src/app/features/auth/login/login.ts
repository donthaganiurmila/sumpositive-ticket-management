import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterLink} from '@angular/router';

@Component({
  imports: [FormsModule,RouterLink],
  selector: 'app-login',
  styleUrl: './login.scss',
  templateUrl: './login.html',
})
export class Login {
  email:string='';
  password:string='';
  login(){
    console.log('Email:', this.email);
    console.log('password entered');
  }
}
