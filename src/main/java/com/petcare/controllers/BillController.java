package com.petcare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.payload.request.BillRequest;
import com.petcare.services.IBillService;

@RestController
@RequestMapping("/api/bill")
public class BillController {
	@Autowired
	private IBillService billService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createBill(@RequestBody BillRequest request){
		String result = billService.save(request);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updateBill(@RequestBody BillRequest request, @PathVariable Long id){
		request.setId(id);
		String result = billService.save(request);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteBill(@RequestParam(name = "id") long id){
		billService.delete(id);
		return ResponseEntity.ok("Success");
	}
}
