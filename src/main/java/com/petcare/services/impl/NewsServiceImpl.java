package com.petcare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petcare.entities.News;
import com.petcare.payload.request.NewsRequest;
import com.petcare.payload.response.NewsResponse;
import com.petcare.repositories.NewsRepository;
import com.petcare.services.INewsService;

@Component
public class NewsServiceImpl implements INewsService {

	@Autowired
	NewsRepository newsRepository;

	@Override
	public List<NewsResponse> getListNews() {
		List<NewsResponse> result = new ArrayList<NewsResponse>();
		List<News> newsS = newsRepository.findAll();
		for (News news : newsS) {
			result.add(new NewsResponse(news.getId(), news.getTitle(), news.getContent(), news.getImgUrl()));
		}
		return result;
	}

	@Override
	public String save(NewsRequest model) {
		News news = new News();
		if (model.getId() != null) {
			news = newsRepository.getOne(model.getId());
		}
		news.setContent(model.getContent());
		news.setTitle(model.getTitle());
		news.setImgUrl(model.getImgUrl());

		news = newsRepository.save(news);
		return news != null ? "Thao tác thành công" : "Thao tác thất bại";
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newsRepository.deleteById(id);
		}

	}

	@Override
	public NewsResponse getById(long id) {
		News news = newsRepository.getOne(id);
		return new NewsResponse(news.getId(), news.getTitle(), news.getContent(), news.getImgUrl());
	}

}