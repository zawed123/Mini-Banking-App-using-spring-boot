import { Component, OnInit } from '@angular/core';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  title:string="Transaction";
  amount:string="";
  deposit:boolean=false;
  withdraw:boolean=false;
  transaction:string="";
  constructor(private service:DataService) {

   }

  ngOnInit(): void {
    
  }

  doTransaction()
  {
    if(this.deposit)
    {
      this.transaction="Deposit";
    }
    else
    {
      this.transaction="Withdraw";
    }
    let data={
      "amount":Number(this.amount),
      "type":this.transaction
    }
    this.service.doTransaction(data);
  }

}
