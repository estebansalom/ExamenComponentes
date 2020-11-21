package com.componentes.examen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.componentes.examen.domain.Workshop;

public interface WorkshopRepository extends JpaRepository<Workshop, Long>{
	public List<Workshop> findByNameContaining(String word);
	
	public List<Workshop> findByCategoryContaining(String word);
	
	public List<Workshop> findByKeywordsContaining(String word);
	
	public List<Workshop> findByAuthorContaining(String author);
}
