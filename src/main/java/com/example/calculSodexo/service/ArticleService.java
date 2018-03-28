package com.example.calculSodexo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.calculSodexo.model.Article;
import com.example.calculSodexo.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Article save(Article article) {
		return articleRepository.save(article);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Article get(Integer id) {
		return articleRepository.getOne(id);
	}
}
