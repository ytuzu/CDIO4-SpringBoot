package com.petcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petcare.entities.Bill;
@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{
	
}
