package com.petcare.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petcare.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	List<Category> findByCategoryID(Long categoryID);
	Category getOneByCode(String code);
}
