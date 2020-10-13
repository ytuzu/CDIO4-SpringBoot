package com.petcare.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill_status")
public class BillStatus extends BaseEntity{
	@Enumerated(EnumType.STRING)
	@Column
    private EBillStatus statusName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "billStatus")
    private List<Bill> bills;

	public EBillStatus getStatusName() {
		return statusName;
	}

	public void setStatusName(EBillStatus statusName) {
		this.statusName = statusName;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
    
    
}
