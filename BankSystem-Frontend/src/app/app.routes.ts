import {RouterModule, Routes} from '@angular/router';
import {AboutComponent} from './components/about/about.component';
import {HomeComponent} from './components/home/home.component';
import {NgModule} from '@angular/core';
import {AccountInfoComponent} from './components/account-info/account-info.component';

export const routes: Routes = [
  {path: '', redirectTo: 'home',pathMatch: 'full'},
  {path: 'home',component:HomeComponent},
  {path:'about',component:AboutComponent},
  {path:'info',component:AccountInfoComponent},
  {
    path: 'dashboard/accounts/create',
    loadComponent: () =>
      import('./dashboard/accounts/account-create/account-create.component')
        .then(m => m.AccountCreateComponent)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
