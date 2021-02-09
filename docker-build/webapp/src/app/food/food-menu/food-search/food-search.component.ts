import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-food-search',
  templateUrl: './food-search.component.html',
  styleUrls: ['./food-search.component.css']
})
export class FoodSearchComponent implements OnInit {
  
  searchString: string;
  @Output() search: any;

  constructor() {
    this.search = new EventEmitter();
  }

  ngOnInit() {

  }
  
  searching() {
    this.search.emit(this.searchString);
  }

}
