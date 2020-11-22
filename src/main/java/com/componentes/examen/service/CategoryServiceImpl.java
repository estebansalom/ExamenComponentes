package com.componentes.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.componentes.examen.domain.Category;
import com.componentes.examen.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository repo;

	@Override
	public void save(Category category) {
		repo.save(category);
	}

	@Override
	public List<Category> getAll() {
		return repo.findAll();
	}
}
