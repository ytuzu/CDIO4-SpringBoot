package com.petcare.payload.response;

public class NewsResponse {
	private Long id;
	private String title;
	private String content;
	private String imgUrl;

	public NewsResponse() {
	}

	public NewsResponse(Long id, String title, String content, String imgUrl) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.imgUrl = imgUrl;
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
