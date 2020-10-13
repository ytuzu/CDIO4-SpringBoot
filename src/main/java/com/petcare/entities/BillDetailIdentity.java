package com.petcare.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BillDetailIdentity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long productId;
	private Long billId;

	public BillDetailIdentity() {
		
	}
	
	public BillDetailIdentity(Long productId, Long billId) {
		this.productId = productId;
		this.billId = billId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

}
