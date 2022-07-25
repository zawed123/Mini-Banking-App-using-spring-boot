import { isNgTemplate } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-passbook',
  templateUrl: './passbook.component.html',
  styleUrls: ['./passbook.component.css']
})
export class PassbookComponent implements OnInit {

  transactions:any[]=[];
  constructor(private servce:DataService) {
    this.servce.getTransactions().subscribe(
      data=>{
        data.map(e1=>{
          this.transactions.push(e1);
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
