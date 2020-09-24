package com.petcare.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
	@NotBlank
	private String title;
	
	@NotNull
	private Long price;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String imgUrl;
	
	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;

	public Product() {
	}

	public Product(@NotBlank String title, @NotBlank Long price, @NotBlank String description, @NotBlank String imgUrl,
			Category category) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.imgUrl = imgUrl;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
