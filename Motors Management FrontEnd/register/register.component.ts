
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { User } from '../model/user.model';
import { AuthService } from '../service/auth.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private auth: AuthService) {
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],
      verification: ['', Validators.required] // Add verification field
    });
  }

  User=new User();
  passConf!:string;


  ngOnInit(): void {
  }

  register() {
    if (this.registerForm.valid) {

    if(this.User.password != this.passConf) {
      Swal.fire({
        icon: 'error',
        title: 'Password not match',
      });
      return;
    }
    console.log(this.User)

    this.auth.Register(this.User).subscribe(
      data => {
        console.log(data);
        Swal.fire({
          icon: 'success',
          title: 'registred successfully',
          timer: 5000
        });
      },
      err => {
        console.log(err);
      }
    )
  }
}}
