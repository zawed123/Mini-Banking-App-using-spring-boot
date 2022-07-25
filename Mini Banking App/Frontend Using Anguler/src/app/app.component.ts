import { Component, OnInit } from '@angular/core';
import { Data } from '@angular/router';
import { DataService } from './service/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  loggedin:boolean=false;
  title = 'student-spa';
  constructor(private service:DataService)
  {
    
  }
  ngOnInit(): void {
    this.loggedin=this.service.isLoggedin();
  }
}
