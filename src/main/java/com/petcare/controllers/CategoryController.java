package com.petcare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.payload.request.CategoryRequest;
import com.petcare.payload.response.CategoryResponse;
import com.petcare.services.ICategoryService;



@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private	ICategoryService categoryService;
	
	@GetMapping("/categorys")
	@PreAuthorize("permitAll()")
	public ResponseEntity<?> getListCategory(){
		List<CategoryResponse> categorys = categoryService.getListCategory();
		return ResponseEntity.ok(categorys);
	}
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createCategory(@RequestBody CategoryRequest category){
		String result = categoryService.save(category);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryRequest category, @PathVariable("id") long id){
		category.setId(id);
		String result = categoryService.save(category);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deleteCategory(@RequestBody long[] ids){ 
		categoryService.delete(ids);
		return ResponseEntity.ok("Success");
	}
}
