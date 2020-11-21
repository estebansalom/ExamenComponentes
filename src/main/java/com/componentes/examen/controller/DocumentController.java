package com.componentes.examen.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.componentes.examen.domain.Query;
import com.componentes.examen.domain.Task;
import com.componentes.examen.domain.Workshop;
import com.componentes.examen.service.DocumentService;
import com.componentes.examen.service.TaskService;
import com.componentes.examen.service.WorkshopService;

@Controller
public class DocumentController {
	
	@Autowired
	DocumentService documentService;
	@Autowired
	TaskService taskService;
	@Autowired
	WorkshopService workshopService;
	
	@RequestMapping(value = "/generate-document/{id}", method = RequestMethod.GET)
	public String generateDocument(@PathVariable("id") long id, Model model) {
		Optional<Workshop> wkpOptional = workshopService.findById(id);
		List<Task> tasks = taskService.findByWorkshopId(wkpOptional.get());
		File doc =  documentService.generateDocument(wkpOptional.get(), tasks);
		model.addAttribute("workshops", workshopService.getAll());
		System.out.println(doc.toString());
		model.addAttribute("doc", doc);
		model.addAttribute(new Query());
		return "view-workshops";
	}
}
