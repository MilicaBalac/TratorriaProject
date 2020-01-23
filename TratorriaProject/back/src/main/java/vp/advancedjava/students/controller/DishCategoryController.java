package vp.advancedjava.students.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vp.advancedjava.students.dto.DishCategoryDTO;
import vp.advancedjava.students.service.DishCategoryService;

@RestController
public class DishCategoryController {

	@Autowired
	DishCategoryService dishCategoryService;
	
    @GetMapping(value = "api/categories")
    public ResponseEntity<List<DishCategoryDTO>> getDishesPage() {
        return new ResponseEntity<>(dishCategoryService.findAll().stream()
        		.map(DishCategoryDTO::new).collect(Collectors.toList())
        		, HttpStatus.OK);
    }

}
