export class Compte {
  id: number;
  accountHolderName: string;
  balance: number;
  type: 'current' | 'savings';

  constructor(
    id: number,
    accountHolderName: string,
    balance: number,
    type: 'current' | 'savings'
  ) {
    this.id = id;
    this.accountHolderName = accountHolderName;
    this.balance = balance;
    this.type = type;
  }

  deposit(montant: number): void {
    if (montant > 0) {
      this.balance += montant;
    }
  }

  withdraw(montant: number): void {
    if (montant > 0 && montant <= this.balance) {
      this.balance -= montant;
    }
  }
}
