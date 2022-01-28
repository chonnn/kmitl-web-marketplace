import { Component, OnInit } from '@angular/core';
import {Login, Token} from "../interface/auth";
import {AuthService} from "../common/auth/auth.service";
import { Router } from '@angular/router';
import {LoginService} from "../service/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData:Login = {
    username: "",
    password: ""
  };

  constructor(private authService:AuthService,
              private router:Router,
              private loginService:LoginService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.loginService.login(this.loginData).subscribe(response=>{
      let userToken:Token = response;
      this.authService.saveToken(userToken.token);
      this.router.navigate(['/']);
    },error=>{
      alert("Error");
    });
  }
}
