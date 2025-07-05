import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AccountService } from '../../../services/account.service';



@Component({
  selector: 'app-account-create',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './account-create.component.html',
  styleUrl: './account-create.component.css'
})
export class AccountCreateComponent implements OnInit {

  accountForm!: FormGroup;

  constructor(private fb: FormBuilder, private accountService: AccountService) {}

  ngOnInit(): void {
    this.accountForm = this.fb.group({
      nom: ['', Validators.required],
      type: ['', Validators.required],
      montant: [0, [Validators.required, Validators.min(0)]]
    })
  }

  onSubmit() {
    if (this.accountForm.valid) {
      this.accountService.createAccount(this.accountForm.value, 'text').subscribe({
        next: (res)=> {
          alert(res)
          
        },
        error: (err) => {
          alert("Erreur création de compte\n" + err)
        }
      })
    }
  }
}
