import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FoodMenuComponent } from './food/food-menu/food-menu.component';
import { CartComponent } from './shopping/cart/cart.component';
import { FoodItemEditComponent } from './food/food-item-edit/food-item-edit.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { AuthGuard } from './site/auth.guard';

const routes: Routes = [
  {path: '', component: FoodMenuComponent},
  {path: 'login', component: LoginComponent},
  {path: 'login/:userAnonymous', component: LoginComponent, canActivate: [AuthGuard] },
  {path: 'login', component: LoginComponent},
  {path: 'cart', component: CartComponent,  canActivate: [AuthGuard]},
  {path: 'edit-admin/:id', component: FoodItemEditComponent, canActivate: [AuthGuard]},
  {path: 'menu-list', component: FoodMenuComponent},
  {path: 'menu-list/:saveStatus', component: FoodMenuComponent}, 
  {path: 'menu-list', component: FoodMenuComponent},
  {path: 'signup', component: SignupComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
