import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../../services/account.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-form',
  imports: [FormsModule,CommonModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css',
  standalone : true
})
export class FormComponent {
  constructor(private accountService : AccountService){}
 
  step=1;  
  finalPayload:any;
  formData = {
      accountHolderName:"",
      balance:"",
      type:""
  }
  
  nextStep() {
    this.step++;
  }

  previousStep() {
    this.step--;
  }

    onSubmit(){
      this.finalPayload = {
        "accountHolderName":this.formData.accountHolderName,
        "balance":this.formData.balance,
        "overdraftLimit":1800
      };
      this.accountService.createAccount(this.finalPayload,this.formData.type).subscribe({
        next: (response) =>{
          alert("Compte créé avec succés");
          console.log(response);
        },
        error: (err)=>{
          console.error("Erreur lors de la création du compte",err);
        }
      })
    }
}
