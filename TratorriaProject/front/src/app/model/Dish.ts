import { DishCategory } from './DishCategory';

export interface Dish {

    id?: number;
    name: string;
    category: DishCategory;
    price: number;
}