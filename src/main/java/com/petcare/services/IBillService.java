package com.petcare.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petcare.payload.request.BillRequest;
import com.petcare.payload.response.BillResponse;
@Service
public interface IBillService {
	String save(BillRequest billRequest);
	void delete(long id);
	List<BillResponse> getAllBill();
	List<BillResponse> getBillByUser(String un);
	
}
