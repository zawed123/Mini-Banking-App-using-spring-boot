import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, Router, RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { AddComponent } from '../add/add.component';
import { LoginComponent } from '../login/login.component';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { PassbookComponent } from '../passbook/passbook.component';
import { TransactionComponent } from '../transaction/transaction.component';
import { AdminComponent } from '../admin/admin.component';
import { AdminDashboardComponent } from '../admin-dashboard/admin-dashboard.component';
import { CustomerDetailsComponent } from '../customer-details/customer-details.component';

let routesMap: Route[] = [{path:'', component:HomeComponent}, 
                          {path:'home', component:HomeComponent},
                          {path:'registration', component:AddComponent}, 
                          {path:'login', component:LoginComponent},
                          {path:'dashboard', component:DashboardComponent},
                          {path:'passbook', component:PassbookComponent},
                          {path:'transaction', component:TransactionComponent},
                          {path:'admin', component:AdminComponent},
                          {path:'adminDash', component:AdminDashboardComponent},
                          {path:'customerDetails', component:CustomerDetailsComponent}]

@NgModule({
  declarations: [],
  imports: [
    CommonModule, RouterModule.forRoot(routesMap)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
