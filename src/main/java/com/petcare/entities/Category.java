package com.petcare.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "category")
public class Category extends BaseEntity {
	@NotBlank
	private String name;
	
	@NotBlank
	private String code;
	
	@NotNull
	private Long categoryID;
	
	@NotBlank
	private String isToggle;
	
	@OneToMany(mappedBy = "category")
	private Set<Product> products = new HashSet<>();

	public Category() {
	}

	public Category(String name, String code, Long categoryID) {
		this.name = name;
		this.code = code;
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getIsToggle() {
		return isToggle;
	}

	public void setIsToggle(String isToggle) {
		this.isToggle = isToggle;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
