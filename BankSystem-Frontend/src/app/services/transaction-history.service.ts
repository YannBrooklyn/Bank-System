import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TransactionHistoryService {

  constructor(private http:HttpClient) { }

  getHistoryById(id:number){
    return this.http.get(`http://localhost:8080/api/transaction/account/${id}`);
  }
}
