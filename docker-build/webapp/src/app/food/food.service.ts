import { Injectable } from '@angular/core';
import { FoodItem } from './food-menu/food-item/food-item-interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from '../site/user.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  menuItem:FoodItem[];
  category: any[];
  token: any;
  baseUrl = environment.baseUrl;

  httpOptions = {
    headers : new HttpHeaders({
      'Content-Type' : 'application/json'
    })
  };  


  constructor(private userSer: UserService ,private httpClient: HttpClient) { 
    /* this.menuItem = [{
      id: 1,
      name: "Sandwich",
      price: 99,
      active: true,
      date_Of_Launch: new Date ("2020-12-11"),
      category: "Maincourse",
      freedelivery: true,
      src: "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
    },
    {
      id: 2,
      name: "Burger",
      price: 199,
      active: false,
      date_Of_Launch: new Date ("2019-12-11"),
      category: "Maincourse",
      freedelivery: false,
      src: "https://images.unsplash.com/photo-1551615593-ef5fe247e8f7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
    },
    {
      id: 3,
      name: "Pizza",
      price: 399,
      active: true,
      date_Of_Launch: new Date ("2018-11-07"),
      category: "Maincourse",
      freedelivery: true,
      src: "https://images.unsplash.com/photo-1542282811-943ef1a977c3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
    },
    {
      id: 4,
      name: "FrenchFries",
      price: 129,
      active: false,
      date_Of_Launch: new Date ("2017-06-11"),
      category: "Starter",
      freedelivery: true,
      src: "https://images.unsplash.com/photo-1541592106381-b31e9677c0e5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80"
    },
    {
      id: 5,
      name: "Strawberry",
      price: 119,
      active: true,
      date_Of_Launch: new Date ("2020-02-11"),
      category: "Juice",
      freedelivery: false,
      src: "https://images.unsplash.com/photo-1502741224143-90386d7f8c82?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
    }
  ]; */

  this.category = [" ","Maincourse", "Starter", "Juice", "Dessert"] 

  }

 /*  getAllItems() {
    return this.menuItem;
  } */

  getAllHttpItems() {
    this.token = 'Bearer '+ this.userSer.getToken();

    this.httpOptions = {
      headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : this.token
      })
    };
    return this.httpClient.get(this.baseUrl+"menu-item-service/truyum/menu-items",this.httpOptions);
  }

  getMenuItem(id) {
    this.token = 'Bearer '+ this.userSer.getToken();

    this.httpOptions = {
      headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : this.token
      })
    };
    return this.httpClient.get(this.baseUrl+"menu-item-service/truyum/menu-items/"+id,this.httpOptions);
  }
  
  getAllCategory() {
    return this.category;
  }

  /* addToCart() {
    this.menuItem.push();
  }
 */
  save(updateItem) {

    this.token = 'Bearer '+ this.userSer.getToken();

    this.httpOptions = {
      headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : this.token
      })
    };
    return this.httpClient.put(this.baseUrl+"menu-item-service/truyum/menu-items/",updateItem,this.httpOptions);

    /*     for(let i = 0; i < this.menuItem.length; i++) {
      if(this.menuItem[i].id == updateItem.id) {
        this.menuItem[i].name = updateItem.name;
        this.menuItem[i].category = updateItem.category;
        this.menuItem[i].price = updateItem.price;
        this.menuItem[i].active = updateItem.active;
        this.menuItem[i].date_Of_Launch = updateItem.date_Of_Launch;
        this.menuItem[i].freedelivery = updateItem.freedelivery;
        break;
      }
    } */
  }
  
}
