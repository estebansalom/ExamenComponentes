package com.componentes.examen.service;

import java.util.List;

import com.componentes.examen.domain.Category;

public interface CategoryService {
	public void save(Category category);
	
	public List<Category> getAll();
}
