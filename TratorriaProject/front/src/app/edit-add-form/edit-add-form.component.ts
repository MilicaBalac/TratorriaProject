import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Dish } from '../model/Dish';
import { DishCategory } from '../model/DishCategory';

@Component({
  selector: 'app-edit-add-form',
  templateUrl: './edit-add-form.component.html',
  styleUrls: ['./edit-add-form.component.css']
})
export class EditAddFormComponent implements OnInit {

  @Output()
  savedDish: EventEmitter<Dish> = new EventEmitter();

  @Input()
  dishToAdd: Dish;
  
  @Input()
  categories: DishCategory[];
  
  constructor() { }

  ngOnInit() {
  }
  
  save(){
    console.log(this.dishToAdd);
    this.savedDish.next(this.dishToAdd);
  }

  reset(){
    this.dishToAdd = {
      name: '',
      price: 0,
      category: {
        name: ''
      }
    }
    }


}
