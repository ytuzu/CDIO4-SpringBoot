package com.petcare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.payload.response.StatisticMonthResponse;
import com.petcare.payload.response.StatisticYearResponse;
import com.petcare.services.IStatisticService;

@RestController
@RequestMapping("/api/statistic")
public class StatisticController {
	@Autowired
	private IStatisticService statisticService;
	
	@GetMapping("/getMonth")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllBillByMonth(@RequestParam(name = "month") int month){
		StatisticMonthResponse response = statisticService.getByMonth(month);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getYear")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllBillByYear(@RequestParam(name = "yearFirst") int yearFirst, @RequestParam(name = "yearSecond") int yearSecond){
		List<StatisticYearResponse> response = statisticService.getByYear(yearFirst, yearSecond);
		return ResponseEntity.ok(response);
	}
}
