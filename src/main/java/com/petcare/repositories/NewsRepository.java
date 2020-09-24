package com.petcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.entities.News;

public interface NewsRepository extends JpaRepository<News, Long>{

}