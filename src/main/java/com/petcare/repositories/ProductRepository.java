package com.petcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petcare.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
