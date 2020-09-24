package com.petcare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.payload.request.NewsRequest;
import com.petcare.payload.response.NewsResponse;
import com.petcare.services.INewsService;


@RestController
@RequestMapping("/api/news")
public class NewsController {

	@Autowired
	private INewsService newsService;

	@GetMapping("/news")
	public ResponseEntity<?> getListNews() {
		List<NewsResponse> news = newsService.getListNews();
		return ResponseEntity.ok(news);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> getByNewsId(@RequestParam(name = "id") long id) {
		NewsResponse news = newsService.getById(id);
		return ResponseEntity.ok(news);
	}
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createNews(@RequestBody NewsRequest model) {
		String result = newsService.save(model);
		return ResponseEntity.ok(result);
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updateNews(@RequestBody NewsRequest model, @PathVariable("id") long id) {
		model.setId(id);
		String result = newsService.save(model);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deleteNews(@RequestBody long[] ids) {
		newsService.delete(ids);
		return ResponseEntity.ok("Success");
	}
}