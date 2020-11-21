package com.componentes.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.componentes.examen.repo.CategoryRepository;

@Service
public class CategoryServiceImpl {
	@Autowired
	CategoryRepository repo;
}
