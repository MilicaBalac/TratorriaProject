import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Dish } from './model/Dish';


@Injectable({
  providedIn: 'root'
})
export class DishService {

  private path = 'api/dishes';

  private pageSize = 10;

  constructor(private http: HttpClient) { }

  getAll(page: number, category: string): Observable<Dish[]> {
    return this.http.get<Dish[]>(`${this.path}?page=${page}&size=${this.pageSize}&category=${category}`);
  }

  add(dish: Dish): Observable<Dish> {
   return this.http.post<Dish>(this.path, dish);
  }

  edit(dish: Dish): Observable<Dish> {
    return this.http.put<Dish>(`${this.path}/${dish.id}`, dish);
  }

  delete(id: number): Observable<Dish> {
    return this.http.delete<Dish>(`${this.path}/${id}`);
  }
}