package com.petcare.payload.request;

import java.util.List;

import javax.validation.constraints.NotNull;

public class BillRequest {
	private Long id;
	@NotNull
	private String address;
	@NotNull
	private String city;
	@NotNull
	private String email;
	@NotNull
	private String phoneNumber;
	@NotNull
	private List<BillDetailRequest> billDetail;
	@NotNull
	private String payment;
	@NotNull
	private Long total;
	@NotNull
	private String userName;
	@NotNull
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<BillDetailRequest> getBillDetail() {
		return billDetail;
	}

	public void setBillDetail(List<BillDetailRequest> billDetail) {
		this.billDetail = billDetail;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
