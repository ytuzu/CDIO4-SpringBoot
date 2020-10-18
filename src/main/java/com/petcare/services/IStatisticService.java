package com.petcare.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petcare.payload.response.StatisticMonthResponse;
import com.petcare.payload.response.StatisticYearResponse;
@Service
public interface IStatisticService {
	StatisticMonthResponse getByMonth(int month);
	List<StatisticYearResponse> getByYear(int yearFirst, int yearSecond);
}
