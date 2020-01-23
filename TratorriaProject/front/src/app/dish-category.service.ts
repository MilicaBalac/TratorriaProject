import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DishCategory } from './model/DishCategory';

@Injectable({
  providedIn: 'root'
})
export class DishCategoryService {
  private path = 'api/categories';

  constructor(private http: HttpClient) { }

  getAll(): Observable<DishCategory[]> {
    return this.http.get<DishCategory[]>(this.path);
  }
}
