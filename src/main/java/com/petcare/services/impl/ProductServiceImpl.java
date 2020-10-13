package com.petcare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petcare.entities.BillDetail;
import com.petcare.entities.Category;
import com.petcare.entities.Product;
import com.petcare.payload.request.ProductRequest;
import com.petcare.payload.response.ProductResponse;
import com.petcare.repositories.BillDetailRepository;
import com.petcare.repositories.CategoryRepository;
import com.petcare.repositories.ProductRepository;
import com.petcare.services.IProductService;

@Component
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepository productRespository;

	@Autowired
	private CategoryRepository categoryRespository;
	
	@Autowired
	private BillDetailRepository billDetailRepository;
	
	@Override
	public List<ProductResponse> getListProduct() {
		List<ProductResponse> result = new ArrayList<ProductResponse>();
		List<Product> products = productRespository.findAll();
		for (Product product : products) {
			result.add(new ProductResponse(product.getId(),product.getTitle(),product.getPrice(),product.getDescription(),product.getImgUrl(),product.getCategory().getCode()));
		}
		return result;
	}

	@Override
	public List<ProductResponse> getListProductByCategoryCode(String code) {
		List<ProductResponse> result = new ArrayList<ProductResponse>();
		List<Product> products = productRespository.findAll();
		for (Product product : products) {
			if (product.getCategory().getCode().equals(code)) {
				result.add(new ProductResponse(product.getId(),product.getTitle(),product.getPrice(),product.getDescription(),product.getImgUrl(),product.getCategory().getCode()));
			}
		}
		return result;
	}

	@Override
	public String save(ProductRequest model) {
		Product product = new Product();
		if (model.getId() != null) {
			product = productRespository.getOne(model.getId());
		} 
		product.setDescription(model.getDescription());
		product.setImgUrl(model.getImgUrl());
		product.setTitle(model.getTitle());
		product.setPrice(model.getPrice());
		Category category = categoryRespository.getOneByCode(model.getCategoryCode());
		product.setCategory(category);
		product = productRespository.save(product);
		return product != null?"Thao tác thành công":"Thao tác thất bại";
	}

	@Override
	public void delete(long id) {
		List<BillDetail> billDetails = billDetailRepository.findAllByProductId(id);
		for (BillDetail billDetail : billDetails) {
			billDetailRepository.delete(billDetail);
		}
		
		productRespository.deleteById(id);
	}

	@Override
	public ProductResponse getProductByID(Long id) {
		Product product = productRespository.getOne(id);
		return new ProductResponse(product.getId(),product.getTitle(),product.getPrice(),product.getDescription(),product.getImgUrl(),product.getCategory().getCode());
	}

}
