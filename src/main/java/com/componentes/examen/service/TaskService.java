package com.componentes.examen.service;

import java.util.List;
import java.util.Optional;

import com.componentes.examen.domain.Task;
import com.componentes.examen.domain.Workshop;

public interface TaskService {
	public void save(Task task);
	public Optional<Task> get(Long id);
	public List<Task> getAll();
	public Optional<Task> findById(Long id) ;
	public List<Task> findByWorkshopId(Workshop wkp);
	public String delete(Task task);
}
