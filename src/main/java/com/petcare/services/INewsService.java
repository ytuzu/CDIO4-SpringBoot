package com.petcare.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petcare.payload.request.NewsRequest;
import com.petcare.payload.response.NewsResponse;

@Service
public interface INewsService {
	List<NewsResponse> getListNews();
	String save(NewsRequest model);
	void delete(long[] ids);
	NewsResponse getById(long id);
}
