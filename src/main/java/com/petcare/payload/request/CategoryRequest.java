package com.petcare.payload.request;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {
	@NotBlank
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String code;
	@NotBlank
	private String categoryCode;
	@NotBlank
	private String isToggle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getIsToggle() {
		return isToggle;
	}

	public void setIsToggle(String isToggle) {
		this.isToggle = isToggle;
	}

}
