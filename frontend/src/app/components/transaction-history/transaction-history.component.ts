import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TransactionHistoryService } from '../../services/transaction-history.service';

@Component({
  selector: 'app-transaction-history',
  imports: [CommonModule, FormsModule],
  templateUrl: './transaction-history.component.html',
  styleUrl: './transaction-history.component.css'
})
export class TransactionHistoryComponent {
  sourceId!: number;
  showDiv: boolean = false;
  result: any;


  constructor(private transactionHistoryService: TransactionHistoryService){}
  
  onSubmit() {
    this.transactionHistoryService.getHistoryById(this.sourceId).subscribe({
      next: (res)=> {
        this.showDiv = true;
        this.result = res;
      },
      error: (err) => console.error("Voici l'erreur", err)
    })
  }
}
