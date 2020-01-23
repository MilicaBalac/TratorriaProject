package vp.advancedjava.students.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.advancedjava.students.dto.DishCategoryDTO;
import vp.advancedjava.students.dto.DishDTO;
import vp.advancedjava.students.model.Dish;
import vp.advancedjava.students.model.DishCategory;
import vp.advancedjava.students.service.DishCategoryService;
import vp.advancedjava.students.service.DishService;

@RestController
public class DishController {

	@Autowired
	DishService dishService;
	@Autowired
	DishCategoryService dishCatService; 
	
// @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "api/dishes")
    public ResponseEntity<List<DishDTO>> getDishesPage( @RequestParam(defaultValue = "", name = "category") String category, Pageable page) {
        final Page<Dish> dishes = dishService.findByCategoryNameContains(category, page);
        final List<DishDTO> retVal = dishes.getContent().stream()
        		.map(DishDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
    
    @DeleteMapping(value="api/dishes/{id}")
    public ResponseEntity<Void> deleteDish (@PathVariable Long id){
    	Dish dish = dishService.findOne(id);
    	if (dish != null) {
			dishService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	
    }
    
    @RequestMapping(value = "api/dishes/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DishDTO> update(@PathVariable Long id, @RequestBody DishDTO dishDTO) {
		Dish dish = dishService.findOne(id);
		if (dish == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		dish.setId(id);
		dish.setName(dishDTO.getName());
		dish.setPrice(dishDTO.getPrice());
		DishCategory cat = dishCatService.findOne(dishDTO.getCategory().getId()); 
		
		dish.setCategory(cat);
		dish = dishService.save(dish);

		return new ResponseEntity<>(new DishDTO(dish), HttpStatus.OK);
	}
    
    @RequestMapping(value = "api/dishes", method = RequestMethod.POST)
	public ResponseEntity<DishDTO> create(@RequestBody DishDTO dishDTO) {
		Dish dish = new Dish();
		dish.setName(dishDTO.getName());
		dish.setPrice(dishDTO.getPrice());
		DishCategory cat = dishCatService.findOne(dishDTO.getCategory().getId());
		dish.setCategory(cat);
		dish = dishService.save(dish);

		return new ResponseEntity<>(new DishDTO(dish), HttpStatus.CREATED);
	}

}
