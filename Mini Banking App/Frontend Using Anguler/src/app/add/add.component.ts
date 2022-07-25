import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  
  title:string="";
  name: string = ""
  balance: string = ""
  password:string=""

  constructor(public service: DataService) {
    this.title="Registration Here!!";
   }

  ngOnInit(): void {
  }

  addStudent(){
    let data={
      "name":this.name,
      "balance":Number(this.balance),
      "password":this.password
    }
    let details=this.service.addAccount(data);
    console.log(details);
  }
}
