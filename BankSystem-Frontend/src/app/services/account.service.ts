import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private apiUrl = `${environment.apiUrl}/hello`;

  constructor(private http: HttpClient) {}

  createAccount(data: any, responseType: 'json' | 'text' = 'json'): Observable<any> {
    return this.http.post(this.apiUrl, data, {responseType : responseType as 'json'})
  }

  getAccounts(): Observable<any[]> {

    return this.http.get<any[]>(this.apiUrl);
  }
}
