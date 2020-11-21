package com.componentes.examen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.componentes.examen.domain.Task;
import com.componentes.examen.domain.Workshop;

public interface TaskRepository extends JpaRepository<Task, Long> {
	public void delete(Task task);

	public List<Task> findAllByWorkshopId(Workshop workshop);
}
