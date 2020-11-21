package com.componentes.examen.service;

import java.io.File;
import java.util.List;

import com.componentes.examen.domain.Task;
import com.componentes.examen.domain.Workshop;

public interface DocumentService {
	public File generateDocument(Workshop wkp, List<Task> tasks);
}
