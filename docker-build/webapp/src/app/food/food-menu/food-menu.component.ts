import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { FoodItem } from './food-item/food-item-interface';
import { Router, ActivatedRoute } from '@angular/router';
import { CartService } from 'src/app/shopping/cart.service';
import { UserService } from 'src/app/site/user.service';


@Component({
  selector: 'app-food-menu',
  templateUrl: './food-menu.component.html',
  styleUrls: ['./food-menu.component.css']
})
export class FoodMenuComponent implements OnInit {
  menuItem: any;
  filteredFood: FoodItem[];
  foodId: number;
  userMask: string;
  saveStatus: string=null;

  constructor(private foodSer: FoodService, 
              private cartSer: CartService ,
              private router: Router,
              private route: ActivatedRoute, 
              private userSer: UserService) { }

  ngOnInit() {
    this.foodSer.getAllHttpItems().subscribe((data) => {
      this.menuItem = data;
      this.filteredFood = this.menuItem;
      this.route.paramMap.subscribe(params => {
      this.saveStatus = params.get('saveStatus');
    });
     })
  }

  filterData($event) {
    this.filteredFood = this.menuItem.
                                      filter( (item: FoodItem) => 
                                      item.name.toLocaleLowerCase()
                                      .indexOf($event.toLocaleLowerCase()) != -1 );
  }

  add($event) {
    this.cartSer.addCartItem(this.userSer.getName(),$event).subscribe();
    this.foodId = $event;
  }
  
  edit($event) {
    this.router.navigate(['edit-admin',$event.id]);
  }

  status() {
    return this.userSer.getRole();
  }

}
