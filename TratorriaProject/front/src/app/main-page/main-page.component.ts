import { Component, OnInit, ViewEncapsulation } from '@angular/core';

import { Dish } from '../model/Dish';
import { DishCategory } from '../model/DishCategory';
import { DishCategoryService } from '../dish-category.service';
import { DishService } from '../dish.service';
import { AuthenticationService } from '../service/security/authentication-service.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class MainPageComponent implements OnInit {

  dishes: Dish[]=[];

  isAdministrator: boolean;

  page = 0;

  category='';

  categories: DishCategory[] = [];

  dish: Dish ={
    id: 0,
    name: '',
    price: 0,
    category: {
      name: ''
    }
  }

  constructor(private dishService: DishService, private dishCategoryService: DishCategoryService, private autService: AuthenticationService) { }

  ngOnInit() {
    this.isAdministrator=this.autService.getCurrentUser() ?
    this.autService.getCurrentUser().roles.indexOf('ROLE_ADMIN') !== -1 : false;
    this.isLoggedIn();

    this.reset();
    this.loadData();
  }

  loadData(){
    this.dishService.getAll(this.page, this.category).subscribe(data => {this.dishes = data});
    this.dishCategoryService.getAll().subscribe(data => {this.categories = data});
  }

  
 

  search() {
    this.loadData();
    this.category ='';
  }

  prevPage(){
    if(this.page >= 0) {
      this.page -=1;
      this.loadData();
    }
  }
  nextPage() {
    this.page += 1;
    this.loadData();
  }
  reset() {
    this.dish = {
      name: '',
      price: 0,
      category: {
        name: ''
      }
    }
  }

  add(dish: Dish){
    this.dishService.add(this.dish).subscribe(res => this.loadData());
  }
  edit(dish: Dish){
    this.dishService.edit(this.dish).subscribe(res => this.loadData());
  }

  save(){
    if(this.dish.id) {
      this.edit(this.dish);
    } else {
      this.add(this.dish);
    }
  }

  markDishForEditing(dish: Dish){
    this.dish = {
      id: dish.id,
      name: dish.name,
      price: dish.price,
      category: dish.category
    }
  }
  delete(id: number){
    this.dishService.delete(id).subscribe(res => this.loadData());
  }

  isLoggedIn(): boolean{
    return this.autService.isLoggedIn();
  }
}
