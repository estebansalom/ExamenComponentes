package com.componentes.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.componentes.examen.domain.Task;
import com.componentes.examen.domain.Workshop;
import com.componentes.examen.repo.TaskRepository;
import com.componentes.examen.repo.WorkshopRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository repo;
	
	@Override
	public void save(Task task) {
		repo.save(task);
	}

	@Override
	public Optional<Task> get(Long id) {
		return Optional.ofNullable(repo.getOne(id));
	}

	@Override
	public List<Task> getAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Task> findById(Long id) {
		return repo.findById(id);
	}
	
	@Override
	public String delete(Task task) {
	    repo.delete(task);
	    return "index";
	}

	@Override
	public List<Task> findByWorkshopId(Workshop wkp) {
		return repo.findAllByWorkshopId(wkp);
	}

}
