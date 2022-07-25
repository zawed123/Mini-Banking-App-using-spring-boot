import { Component, OnInit } from '@angular/core';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title:string="";
  name:string="";
  password:string="";
  constructor(private service:DataService) {
    this.title="Login Here!!";
   }

  ngOnInit(): void {
  }

  login()
  {
   let data={
     "userName":this.name,
     "password":this.password
   }

   this.service.login(data);
   console.log(data);
  }
}
