package com.petcare.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.petcare.payload.request.CategoryRequest;
import com.petcare.payload.response.CategoryResponse;

@Service
public interface ICategoryService {
	List<CategoryResponse> getListCategory();
	String save(CategoryRequest category);
	void delete(long[] ids);
}
