import { Component, OnInit } from '@angular/core';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {

  customers:any[]=[]
  constructor(private service:DataService) { 
    this.service.getCustomer().subscribe(
      data=>{
        data.map(e1=>{
          this.customers.push(e1);
        })

      },
      error=>{
        console.log(error);
      }
    )
  }

  ngOnInit(): void {
  }

}
