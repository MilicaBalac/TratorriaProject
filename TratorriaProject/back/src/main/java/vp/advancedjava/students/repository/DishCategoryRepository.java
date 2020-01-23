package vp.advancedjava.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.advancedjava.students.model.DishCategory;

@Component
public interface DishCategoryRepository extends JpaRepository<DishCategory, Long> {

}
