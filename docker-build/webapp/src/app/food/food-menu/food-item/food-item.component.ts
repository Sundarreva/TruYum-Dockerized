import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/site/auth.service';

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {
  @Input() item: any;
  @Input() added: number;
  @Input() mask: string;
  @Output() addItem: any;
  @Output() editItem: any;

  constructor(private router:Router, private authSer: AuthService) {
    this.addItem = new EventEmitter();
    this.editItem = new EventEmitter();
   }

  ngOnInit() {
  }

  onAddToCartClick(menuItemId){
    if(!this.authSer.isLoggedIn()) {
      this.authSer.setAnonymousMenuItemId(menuItemId);
      this.router.navigate(['login',"true"]);
    }
    this.addItem.emit(menuItemId);
  }

  edit(){
    this.editItem.emit(this.item);
  }
  

}
