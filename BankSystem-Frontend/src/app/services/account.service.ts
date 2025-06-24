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
}
