package com.componentes.examen.service;

import java.util.List;
import java.util.Optional;

import com.componentes.examen.domain.Workshop;

public interface WorkshopService {
	public void save(Workshop ws);
	public Optional<Workshop> get(Long id);
	public List<Workshop> getAll();
	public List<Workshop> find(String name);
	public Optional<Workshop> findById(Long id) ;
	public List<Workshop> findByAuthorContaining(String author);
	public List<Workshop> findByKeywordsContaining(String keywords);
	public List<Workshop> findByCategoryContaining(String category);
}
