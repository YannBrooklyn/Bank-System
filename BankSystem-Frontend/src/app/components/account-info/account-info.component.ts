import { Component } from '@angular/core';
import { Compte } from '../../models/compte.model';
import { AccountService } from '../../services/account.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-account-info',
  templateUrl: './account-info.component.html',
  imports:[FormsModule,CommonModule]
})
export class AccountInfoComponent {
  id!: number;
  type: 'current' | 'savings' = 'current';
  compte!: Compte;
  montant: number = 0;
  errorMessage = '';
  successMessage = '';
  result!:boolean;

  
  
  constructor(private accountService: AccountService) {}

  loadAccount() {
    this.clearMessages();

    if (!this.id || !this.type) {
      this.errorMessage = 'Veuillez saisir un ID et un type de compte.';
      return;
    }

    this.accountService.getAccount(this.id, this.type).subscribe({
      next: (data: any) => {
        this.compte = new Compte(data.id, data.accountHolderName, data.balance, data.type);
      },
      error: () => {
        this.errorMessage = "Compte introuvable.";
      }
    });
  }

 async deposit() {
  this.clearMessages();

  if (!this.compte || this.montant <= 0) {
    this.errorMessage = "Montant invalide.";
    return;
  }

  this.compte.deposit(this.montant);

  try {
    await this.saveUpdatedAccount();
    this.successMessage = "Dépôt effectué.";
    this.montant = 0;
  } catch (error) {
    this.errorMessage = "Erreur lors de l'enregistrement.";
    console.error(error);
  }
}

async withdraw() {
  this.clearMessages();

  if (!this.compte || this.montant <= 0 || this.montant > this.compte.balance) {
    this.errorMessage = "Retrait invalide.";
    return;
  }

  this.compte.withdraw(this.montant);

  try {
    await this.saveUpdatedAccount();
    this.successMessage = "Retrait effectué.";
    this.montant = 0;
  } catch (error) {
    this.errorMessage = "Erreur lors de l'enregistrement.";
    console.error(error);
  }
}

saveUpdatedAccount(): Promise<void> {
  return new Promise((resolve, reject) => {
    this.accountService.updateAccount(this.compte.id, this.compte, this.type).subscribe({
      next: () => resolve(),
      error: (err) => reject(err)
    });
  });
}


  clearMessages() {
    this.errorMessage = '';
    this.successMessage = '';
  }
}
