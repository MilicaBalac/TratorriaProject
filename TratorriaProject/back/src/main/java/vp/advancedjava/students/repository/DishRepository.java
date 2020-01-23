package vp.advancedjava.students.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.advancedjava.students.model.Dish;

@Component
public interface DishRepository extends JpaRepository<Dish, Long>  {

	Page<Dish> findByCategoryNameContains(String category, Pageable page);
}
