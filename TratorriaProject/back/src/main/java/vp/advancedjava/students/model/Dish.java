package vp.advancedjava.students.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Dish {

	@Id
    @GeneratedValue
    private Long id;

    private String name;
    
    private double price;

	@ManyToOne(fetch = FetchType.EAGER) 
    private DishCategory category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public DishCategory getCategory() {
		return category;
	}

	public void setCategory(DishCategory category) {
		this.category = category;
	}
	public Dish() {
		
	}
	
	
}
