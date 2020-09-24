package com.petcare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petcare.entities.Category;
import com.petcare.payload.request.CategoryRequest;
import com.petcare.payload.response.CategoryResponse;
import com.petcare.repositories.CategoryRepository;
import com.petcare.services.ICategoryService;

@Component
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<CategoryResponse> getListCategory() {
		List<CategoryResponse> result = new ArrayList<CategoryResponse>();
		List<Category> categoryParent = categoryRepository.findByCategoryID((long) 0);
		for (Category category : categoryParent) {
			CategoryResponse categoryRes = new CategoryResponse(category.getId(), category.getName(),
					category.getCode(), category.getIsToggle());
			List<Category> categoryChild = categoryRepository.findByCategoryID(category.getId());
			List<Object> objects = new ArrayList<Object>();
			for (Category tmp : categoryChild) {
				CategoryTmp objectTmp = new CategoryTmp();
				objectTmp.setCode(tmp.getCode());
				objectTmp.setName(tmp.getName());

				objects.add(objectTmp);
			}

			categoryRes.setChild(objects);
			result.add(categoryRes);
		}
		return result;
	}

	@Override
	public String save(CategoryRequest category) {
		Category entity = new Category();
		if (category.getId() != null) {
			entity = categoryRepository.getOne(category.getId());
		}
		entity.setName(category.getName());
		entity.setCode(category.getCode());
		if (category.getCategoryCode().equals("0")) {
			entity.setCategoryID((long) 0);
		} else {
			entity.setCategoryID(categoryRepository.getOneByCode(category.getCategoryCode()) == null ? (long) 0
					: categoryRepository.getOneByCode(category.getCategoryCode()).getId());
		}
		entity.setIsToggle("True");
		entity = categoryRepository.save(entity);
		return entity == null ? "Thao tác thất bại" : "Thao tác thành công";
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			categoryRepository.deleteById(id);
		}
	}

}

class CategoryTmp {
	String code, name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
