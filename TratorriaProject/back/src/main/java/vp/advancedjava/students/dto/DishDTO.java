package vp.advancedjava.students.dto;

import vp.advancedjava.students.model.Dish;

public class DishDTO {

	private long id;
	
	private String name;
	
	private double price;
	
	private DishCategoryDTO category;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public DishCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(DishCategoryDTO category) {
		this.category = category;
	}

	public DishDTO(long id, String name, double price, DishCategoryDTO category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public DishDTO(Dish dish) {
		super();
		this.id = dish.getId();
		this.name = dish.getName();
		this.price = dish.getPrice();
		this.category = new DishCategoryDTO(dish.getCategory());
	}

	public DishDTO() {
		
	}
}
