package com.petcare.services;

import org.springframework.stereotype.Service;

import com.petcare.payload.request.BillRequest;
@Service
public interface IBillService {
	String save(BillRequest billRequest);
	void delete(long id);
	
}
