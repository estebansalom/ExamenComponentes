package com.componentes.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.componentes.examen.domain.Workshop;
import com.componentes.examen.repo.WorkshopRepository;

@Service
public class WorkshopServiceImpl implements WorkshopService {

	@Autowired
	WorkshopRepository repo;

	@Override
	public List<Workshop> find(String name) {
		return repo.findByNameContaining(name);
	}

	@Override
	public List<Workshop> getAll() {
		return repo.findAll();
	}

	@Override
	public void save(Workshop ws) {
		repo.save(ws);
		
	}
	
	public Optional<Workshop> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public Optional<Workshop> get(Long id) {
		return Optional.ofNullable(repo.getOne(id));
	}
	
	public List<Workshop> findByAuthorContaining(String author){
		return repo.findByAuthorContaining(author);
	}
	
	public List<Workshop> findByKeywordsContaining(String keywords){
		return repo.findByKeywordsContaining(keywords);
	}
	
	public List<Workshop> findByCategoryContaining(String category){
		return repo.findByCategoryContaining(category);
	}
}