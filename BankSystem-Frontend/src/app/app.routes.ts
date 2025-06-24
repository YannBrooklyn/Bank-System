import {RouterModule, Routes} from '@angular/router';
import {AboutComponent} from './components/about/about.component';
import {HomeComponent} from './components/home/home.component';
import {NgModule} from '@angular/core';
import {AccountInfoComponent} from './components/account-info/account-info.component';
import { FormComponent } from './components/form/form.component';

export const routes: Routes = [
  {path: '', redirectTo: 'home',pathMatch: 'full'},
  {path: 'home',component:HomeComponent},
  {path:'about',component:AboutComponent},
  {path:'info',component:AccountInfoComponent},
  {path:'form',component:FormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
