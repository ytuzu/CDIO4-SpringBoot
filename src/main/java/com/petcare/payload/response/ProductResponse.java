package com.petcare.payload.response;

public class ProductResponse {
	private Long id;
	private String title;
	private Long price;
	private String description;
	private String imgUrl;
	private String categoryCode;

	public ProductResponse() {
	}

	public ProductResponse(Long id, String title, Long price, String description, String imgUrl, String categoryCode) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.imgUrl = imgUrl;
		this.categoryCode = categoryCode;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
