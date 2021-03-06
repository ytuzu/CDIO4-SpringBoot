package com.petcare.payload.request;

import javax.validation.constraints.NotNull;

public class BillDetailRequest {
	@NotNull
	private long idProduct;
	@NotNull
	private String nameProduct;
	@NotNull
	private int quantity;
	@NotNull
	private long price;

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
