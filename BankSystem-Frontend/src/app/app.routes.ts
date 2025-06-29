import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {NgModule} from '@angular/core';
import {AccountInfoComponent} from './components/account-info/account-info.component';
import { FormComponent } from './components/form/form.component';
import { AccountCreateComponent } from './dashboard/accounts/account-create/account-create.component';
import { TransferComponentComponent } from './components/transfer-component/transfer-component.component';

export const routes: Routes = [
  {path: '', redirectTo: 'home',pathMatch: 'full'},
  {path: 'home',component:HomeComponent},
  {path:'info',component:AccountInfoComponent},
  {path:'form',component:FormComponent},
  {path:'transfer',component:TransferComponentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
