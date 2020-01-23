package vp.advancedjava.students.dto;

import vp.advancedjava.students.model.DishCategory;

public class DishCategoryDTO {
	private long id;
	private String name;
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
	public DishCategoryDTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public DishCategoryDTO(DishCategory dishCategory) {
		super();
		this.id = dishCategory.getId();
		this.name = dishCategory.getName();
	}
	public DishCategoryDTO() {
		
	}
	
}
