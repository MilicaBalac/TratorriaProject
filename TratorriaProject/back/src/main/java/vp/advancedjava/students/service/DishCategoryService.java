package vp.advancedjava.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.advancedjava.students.model.Dish;
import vp.advancedjava.students.model.DishCategory;
import vp.advancedjava.students.repository.DishCategoryRepository;

@Component
public class DishCategoryService {

	@Autowired
	DishCategoryRepository dishCategoryRepository;
	
	public List<DishCategory> findAll(){
		return dishCategoryRepository.findAll();
	}
	
	public DishCategory findOne(Long id) {
		return dishCategoryRepository.findOne(id);
	}

}
