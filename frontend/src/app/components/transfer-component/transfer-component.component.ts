import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../../services/account.service';
import { Transaction } from '../../interface/transaction';

@Component({
  selector: 'app-transfer-component',
  imports: [CommonModule, FormsModule],
  templateUrl: './transfer-component.component.html',
  styleUrl: './transfer-component.component.css'
})



export class TransferComponentComponent {

  transaction: Transaction = {
    sourceId: 0,
    targetId: 0,
    amount: 0
  }

  constructor(private accountService: AccountService) {}
 
  onSubmit() {
    console.log(this.transaction)
    this.accountService.transfer(this.transaction).subscribe({
      next: (res) => alert("Transaction realiser avec succès"),
      error: (err) => alert("Une erreur est survenu.")
    });
  }
}

