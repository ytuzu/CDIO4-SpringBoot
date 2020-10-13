package com.petcare.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "bill_detail")
public class BillDetail{
	// Khóa chính
	@EmbeddedId
    private BillDetailIdentity billDetailIdentity;
	
	@Column
    private Integer quantity;
	
	@Column
    private Long price;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @MapsId("billId")
    private Bill bill;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @MapsId("productId")
    private Product product;

	public BillDetailIdentity getBillDetailIdentity() {
		return billDetailIdentity;
	}

	public void setBillDetailIdentity(BillDetailIdentity billDetailIdentity) {
		this.billDetailIdentity = billDetailIdentity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
