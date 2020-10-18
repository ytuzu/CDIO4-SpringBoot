package com.petcare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petcare.entities.Bill;
import com.petcare.entities.User;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	@Query(value = "SELECT DAY(a.created_date), SUM(a.total) "
			+ "FROM petcare.bill a, petcare.bill_status b "
			+ "WHERE a.bill_status = b.id "
			+ "		 AND b.status_name = 'PAID' "
			+ "	 	 AND MONTH(a.created_date) = ?1 "
			+ "		 AND YEAR(a.created_date) = ?2 "
			+ "GROUP BY DAY(a.created_date)", nativeQuery = true)
	List<Object[]> findAllByMonth(int month, int year);

	@Query(value = "SELECT MONTH(a.created_date), SUM(a.total) 	"
			+ "FROM petcare.bill a, petcare.bill_status b "
			+ "WHERE a.bill_status = b.id AND b.status_name = 'PAID' YEAR(a.created_date) = ?1 "
			+ "GROUP BY MONTH(a.created_date)", nativeQuery = true)
	List<Object[]> findAllByYear(int year);

	
	List<Bill> findAllByUser(User user);

}
