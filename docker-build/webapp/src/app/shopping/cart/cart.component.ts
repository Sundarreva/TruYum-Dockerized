import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';
import { Router } from '@angular/router';
import { UserService } from 'src/app/site/user.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: any;
  user: String;
  cartTotal:any = 0;
  deleted:boolean;

  constructor(private cartItem: CartService, private router:Router, private userSer: UserService ) { }

  ngOnInit() {
    this.user = this.userSer.getName();
    this.cartItem.getAllCartItem().subscribe((data) => {
      this.cart = data;
      for (let item of this.cart) {
        this.cartTotal += item.price;
      }
      this.deleted = false;
    },
    (error) => {
    
    }
    );
    
  }
  onDeleteClick(menuItemId) {
    this.cartItem.deleteCartItem(this.userSer.getName(), menuItemId).subscribe((data) => {
      this.cartTotal = 0;
      this.cart = data;
      for (let item of this.cart) {
        this.cartTotal += item.price;
      }
    });
    this.deleted = true;
  }

}
