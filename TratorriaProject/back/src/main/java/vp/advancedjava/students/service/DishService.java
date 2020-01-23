package vp.advancedjava.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.advancedjava.students.model.Dish;
import vp.advancedjava.students.repository.DishRepository;

@Component
public class DishService {

	@Autowired
	DishRepository dishRepository;

	public List<Dish> findAll() {
		return dishRepository.findAll();
	}
	
	public Page<Dish> findAll(Pageable page) {
		return dishRepository.findAll(page);
	}

	public Page<Dish> findByCategoryNameContains(String category, Pageable page){
		return dishRepository.findByCategoryNameContains(category, page);
	}
	
	public Dish findOne(Long id) {
		return dishRepository.findOne(id);
	}

	public Dish save(Dish dish) {
		return dishRepository.save(dish);
	}

	public void remove(Long id) {
		dishRepository.delete(id);
	}

}
