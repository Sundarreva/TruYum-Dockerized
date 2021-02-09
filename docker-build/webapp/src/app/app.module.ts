import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'; 


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FoodItemComponent } from './food/food-menu/food-item/food-item.component';
import { FoodMenuComponent } from './food/food-menu/food-menu.component';
import { FoodSearchComponent } from './food/food-menu/food-search/food-search.component';
import { CartComponent } from './shopping/cart/cart.component';
import { FoodItemEditComponent } from './food/food-item-edit/food-item-edit.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    FoodItemComponent,
    FoodMenuComponent,
    FoodSearchComponent,
    CartComponent,
    FoodItemEditComponent,
    SignupComponent,
    LoginComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
