import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-food-item-edit',
  templateUrl: './food-item-edit.component.html',
  styleUrls: ['./food-item-edit.component.css']
})
export class FoodItemEditComponent implements OnInit {

  foodItem: any;
  category: any[];
  constructor(private foodSer:FoodService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit() {

    this.route.paramMap.subscribe(params => {
      let id:any = params.get('id');
      this.foodSer.getMenuItem(id).subscribe((data) => {
        this.foodItem = data;
        this.category = this.foodSer.getAllCategory();
        console.log(this.foodItem);
      });
      /* for (let item of this.foodSer.getAllItems()) {
      if(id == item.id) {
        this.foodItem = item;
      }
    } */
    });
    

  }

  launchDate(date: string) {
    let str:string[] = date.split("/");
    let newDate: string = str[1]+'-'+str[0]+'-'+str[2];
    this.foodItem.dateOfLaunch = new Date(newDate);
  }

  onSaveClick(temp) {
    this.foodSer.save(this.foodItem).subscribe();
    this.router.navigate(['menu-list',"saved"]);
  }

}
