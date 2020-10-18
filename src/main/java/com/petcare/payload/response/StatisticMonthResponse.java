package com.petcare.payload.response;

import java.util.List;

public class StatisticMonthResponse {
	private List<String> label;
	private List<Long> data;
	
	public List<String> getLabel() {
		return label;
	}
	public void setLabel(List<String> label) {
		this.label = label;
	}
	public List<Long> getData() {
		return data;
	}
	public void setData(List<Long> data) {
		this.data = data;
	}

	
	
}
