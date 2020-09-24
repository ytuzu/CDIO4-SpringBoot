package com.petcare.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petcare.payload.request.ProductRequest;
import com.petcare.payload.response.ProductResponse;

@Service
public interface IProductService {
	List<ProductResponse> getListProduct();
	List<ProductResponse> getListProductByCategoryCode(String code);
	String save(ProductRequest model);
	void delete(long[] ids);
	ProductResponse getProductByID(Long id);
}
