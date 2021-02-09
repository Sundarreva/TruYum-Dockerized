import { Injectable } from '@angular/core';
import { FoodService } from '../food/food.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UserService } from '../site/user.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  token: any;
  httpOptions: any;
  cartItem: any;
  total: number = 0;
  baseUrl = environment.baseUrl;

  constructor(private userSer: UserService,
    private httpClient: HttpClient) {
    this.cartItem = [];
  }

  getAllCartItem() {
    this.token = 'Bearer ' + this.userSer.getToken();
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': this.token
      })
    };
    return this.httpClient.get(this.baseUrl+"menu-item-service/truyum/cart-items/" + this.userSer.getName(), this.httpOptions);
  }

  /* getTotal(){
    this.total = 0;
      for (let item of this.cartItem.getAllCartItem()) {
        this.total += item.price;
      }
      return this.total;
    }
  } */

  addCartItem(user, menuItemId) {
    this.token = 'Bearer ' + this.userSer.getToken();
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': this.token
      })
    };
    return this.httpClient.post(this.baseUrl+"menu-item-service/truyum/cart-items/" + user + "/" + menuItemId, {}, this.httpOptions);
    /* for(let item of this.foodSer.getAllItems()) {
      if(item == additem) {
        this.cartItem.push(item);
      }
    } */
  }

  deleteCartItem(user, menuItemId) {
    this.token = 'Bearer ' + this.userSer.getToken();
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': this.token
      })
    };
    return this.httpClient.delete(this.baseUrl+"menu-item-service/truyum/cart-items/" + user + "/" + menuItemId, this.httpOptions);
    /* 
    let rem = 0;
    for(let i = 0; i < this.cartItem.length; i++) {
      if(this.cartItem[i].id == id) {
        rem = this.cartItem[i].price;
        this.cartItem.splice(i,1);
        break;
      }
    }
    return this.total -= rem; */
  }

}
