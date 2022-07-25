import { Component, OnInit } from '@angular/core';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  title:string="Admin Login";
  name:string="";
  password:string="";
  constructor(private service:DataService) { }

  ngOnInit(): void {
  }

  adminLogin()
  {
   let data={
     "userName":this.name,
     "password":this.password
   }
   this.service.adminLogin(data);
  }

}
