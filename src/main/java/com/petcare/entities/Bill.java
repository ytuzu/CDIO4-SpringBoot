package com.petcare.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "bill")
public class Bill extends BaseEntity {
	@Column
	private Long total;

	@CreationTimestamp
	@Column(updatable = false)
	private Date createdDate;

	@Column
	private String email;

	@Column
	private String address;

	@Column
	private String city;

	@Column
	private String phoneNumber;

	@Column
	private String payment;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bill_status")
	private BillStatus billStatus;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
	List<BillDetail> billDetails;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BillStatus getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(BillStatus billStatus) {
		this.billStatus = billStatus;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

}
