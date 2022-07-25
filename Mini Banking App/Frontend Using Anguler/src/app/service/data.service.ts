import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders} from '@angular/common/http';

interface Admin{
  userName:string,
  password:string,
  found:boolean
}
@Injectable({
  providedIn: 'root'
})

export class DataService {
  constructor(private http: HttpClient, private router: Router) { }

  addAccount(data: any){
    let res = this.http.post("http://localhost:8080/api/v1/banking/log/addAccount",data).subscribe();
    this.router.navigate(['/', 'login']);
    return res;
  }

  login(data:any)
  {
    this.http.post("http://localhost:8080/api/v1/banking/log/login",data).subscribe((result) => {
         console.log(result);
         let tokn: string = JSON.stringify(result).split('"')[3];
         localStorage.setItem("token",tokn);
         localStorage.setItem("name",data.userName);
        window.location.href="/dashboard";
  });
  }
  logout()
  {
    localStorage.removeItem("token");
    localStorage.removeItem("name");
    this.router.navigate(['/', 'login']);
  }

  isLoggedin()
  {
    let token=localStorage.getItem("token");
    if(token==undefined || token==null || token==' ')
    {
      return false;
    }
    return true;
  }

  getTransactions(){
      var token= "Bearer "+localStorage.getItem("token");
    

    let name=localStorage.getItem("name");
    let url="http://localhost:8080/api/v1/account/"+name+"/transaction/all";
    return this.http.get<any[]>(url,{
       headers:new HttpHeaders({
         'Authorization':token
       })
    })
  }

  doTransaction(data:any)
  {
    const httpHeaders = new HttpHeaders({
      "Authorization" : "Bearer "+localStorage.getItem("token")
    });
    let name=localStorage.getItem('name');
    let url="http://localhost:8080/api/v1/account/"+name+"/transaction/start";
    let flag = this.http.post(url,data, {headers:httpHeaders}).subscribe();
    console.log(flag);
    window.location.href="/dashboard";
  }
  adminLogin(data:any)
  {
    const httpHeaders = new HttpHeaders({
      "Authorization" : "Bearer "+localStorage.getItem("token")
    });
    let url:string="http://localhost:8080/api/v1/admin/admin";
    this.http.get(url,{headers:httpHeaders}).subscribe((result)=>{
      let admin=<Admin>result;
      if(admin.userName==data.userName && admin.password==data.password)
      {
        console.log("Admin loggedin");
        this.router.navigate(['/', 'adminDash']);
      }
      else{
        alert("User Name and Password Invalid");
        this.router.navigate(['/', 'admin']);
      }
    });
  }

  getCustomer(){
    var token= "Bearer "+localStorage.getItem("token");
  let name=localStorage.getItem("name");
  let url="http://localhost:8080/api/v1/account/all";
  return this.http.get<any[]>(url,{
     headers:new HttpHeaders({
       'Authorization':token
     })
  })
}
adminLogout()
{
    localStorage.removeItem("token");
    localStorage.removeItem("name");
    this.router.navigate(['/', 'admin']);
}
}
