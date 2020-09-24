package com.petcare.payload.request;

import javax.validation.constraints.NotBlank;

public class NewsRequest {
	@NotBlank
	private Long id;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	@NotBlank
	private String imgUrl;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
