package com.petcare.services.impl;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petcare.payload.response.StatisticMonthResponse;
import com.petcare.payload.response.StatisticYearResponse;
import com.petcare.repositories.BillRepository;
import com.petcare.services.IStatisticService;

@Component
public class StatisticServiceImpl implements IStatisticService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Override
	public StatisticMonthResponse getByMonth(int month) {
		LocalDate date = LocalDate.of(LocalDate.now().getYear(), month, 1);
		StatisticMonthResponse result = new StatisticMonthResponse();
		// Tạo các field của result
		List<String> label = new ArrayList<String>();
		List<Long> data = new ArrayList<Long>();
		
		// Tìm kiếm ngày cuối cùng của tháng
		int endOfMonth = date.withDayOfMonth(date.lengthOfMonth()).getDayOfMonth();
		// Thêm dữ liệu tạm thời vào các field
		for (int i = 1; i <= endOfMonth; i++) {
			label.add("day " + i);
			data.add((long) 0);
		}
		
		// Lấy dữ liệu từ database
		List<Object[]> bills = billRepository.findAllByMonth(month, date.getYear());
		// Thay đổi dữ liệu của field:data theo database
		for (Object[] object : bills) {
			data.set(Integer.parseInt(object[0].toString()) - 1, Long.parseLong(object[1].toString()));
		}
		
		result.setData(data);
		result.setLabel(label);
		return result;
	}

	@Override
	public List<StatisticYearResponse> getByYear(int yearFirst, int yearSecond) {
		List<StatisticYearResponse> result = new ArrayList<StatisticYearResponse>();
		for (int i = yearFirst; i <= yearSecond; i++) {
			StatisticYearResponse tmp = new StatisticYearResponse();
			tmp.setLabel(i);
			tmp.setBorderColor(randomBorderColor());
			tmp.setFill(false);
			
			List<Object[]> bills = billRepository.findAllByYear(i);
			List<Long> data = new ArrayList<Long>();
			for (int j = 1; j <= 12; j++) {
				data.add((long) 0);
			}
			for (Object[] object : bills) {
				data.set(Integer.parseInt(object[0].toString()) - 1, Long.parseLong(object[1].toString()));
			}
			tmp.setData(data);
			result.add(tmp);
		}
		return result;
	}
	
	private String randomBorderColor() {
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color cl = new Color(r,g,b);
		return "#"+Integer.toHexString(cl.getRGB()).substring(0,6);
	}
}
