package vp.advancedjava.students.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DishCategory {

	@Id
    @GeneratedValue
    private Long id;

	private String name;
	
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Dish> dishes = new HashSet<>();
    
    public DishCategory() {
    	
    }
    

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

	public Set<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}
    
    
}
