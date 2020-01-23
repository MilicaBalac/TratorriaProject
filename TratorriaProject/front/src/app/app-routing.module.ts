import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MainPageComponent } from './main-page/main-page.component';
import { CanActivateAuthGuard } from './service/security/can-activate-auth.guard';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Routes = [
     { path: 'login', component: LoginComponent },
     { path: 'dishes', component: MainPageComponent},
     { path: '', redirectTo: 'dishes', pathMatch: 'full' },
     { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
