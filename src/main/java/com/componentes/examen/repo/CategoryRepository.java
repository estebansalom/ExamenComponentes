package com.componentes.examen.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.componentes.examen.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
