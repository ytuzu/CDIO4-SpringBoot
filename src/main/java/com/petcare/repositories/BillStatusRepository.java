package com.petcare.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petcare.entities.BillStatus;
import com.petcare.entities.EBillStatus;
@Repository
public interface BillStatusRepository extends JpaRepository<BillStatus, Long>{
	Optional<BillStatus> findByStatusName(EBillStatus name);
}
