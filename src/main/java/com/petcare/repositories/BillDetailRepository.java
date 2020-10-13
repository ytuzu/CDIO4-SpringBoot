package com.petcare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petcare.entities.BillDetail;
@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Long>{
	@Query(value = "SELECT * FROM bill_detail u where u.bill_id = ?1", nativeQuery = true)
	List<BillDetail> findAllByBillId(long billId);
	
	@Query(value = "SELECT * FROM bill_detail u where u.product_id = ?1", nativeQuery = true)
	List<BillDetail> findAllByProductId(long productId);
}
