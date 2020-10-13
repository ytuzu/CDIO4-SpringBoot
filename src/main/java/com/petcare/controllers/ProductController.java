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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.payload.request.ProductRequest;
import com.petcare.payload.response.ProductResponse;
import com.petcare.services.IProductService;


@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping("/products")
	public ResponseEntity<?> getListProduct() {
		List<ProductResponse> products = productService.getListProduct();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/products/{code}")
	public ResponseEntity<?> getListProductByCategory(@PathVariable("code") String code) {
		List<ProductResponse> products = productService.getListProductByCategoryCode(code);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/search")
	public ResponseEntity<?> getProductById(@RequestParam(name = "id") String id) {
		ProductResponse product = productService.getProductByID(Long.parseLong(id));
		return ResponseEntity.ok(product);
	}
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createProduct(@RequestBody ProductRequest model) {
		String result = productService.save(model);
		return ResponseEntity.ok(result);
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updateProduct(@RequestBody ProductRequest model, @PathVariable("id") long id) {
		model.setId(id);
		String result = productService.save(model);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deleteProduct(@RequestParam(name = "id") long id) {
		productService.delete(id);
		return ResponseEntity.ok("Success");
	}
}