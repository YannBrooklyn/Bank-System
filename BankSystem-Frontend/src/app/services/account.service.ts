import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http:HttpClient) {}
  

  createAccount(data:any,type:string){
    return this.http.post(`http://localhost:8080/api/accounts/${type}`, data);
  }

  operation(data:any,type:string){
    return this.http.post(`http://localhost:8080/api/accounts/${type}`, data);
  }

  getAccount(id:number,type:string){
    return this.http.get(`http://localhost:8080/api/accounts/${type}/${id}`);
  }

  updateAccount(id:number,data:any,type:string){
    return this.http.put(`http://localhost:8080/api/accounts/${type}/${id}`,data);
  }

  
}
