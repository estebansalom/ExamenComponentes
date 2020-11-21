package com.componentes.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.componentes.examen.domain.Task;
import com.componentes.examen.domain.Workshop;
import com.componentes.examen.service.TaskService;
import com.componentes.examen.service.WorkshopService;

@Controller

public class TaskController {

	@Autowired
	TaskService taskService;
	@Autowired
	WorkshopService workshopService;
	
	@RequestMapping(value= "/add-task", method = RequestMethod.POST)
	public String insertTask(Task task, BindingResult result, Model model) {
		taskService.save(task);
		model.addAttribute("tasks", taskService.getAll());
		return "view-tasks";
	}
	
	@RequestMapping("/view-tasks")
	public String list(Model model) {
		model.addAttribute("tasks",taskService.getAll());
		return "view-tasks";
	}
	
	@RequestMapping(value = "/view-tasks/{id}", method = RequestMethod.GET)
	public String showTasksByWorkshop(@PathVariable("id") long id, Model model) {
		Optional<Workshop> wkpOptional = workshopService.findById(id);
		List<Task> tasks = taskService.findByWorkshopId(wkpOptional.get());
	    model.addAttribute(new Task());
	    model.addAttribute("tasks", tasks);
	    return "view-tasks";
	}
	
	@RequestMapping(value = "/delete-task/{id}", method = RequestMethod.GET)
	public String deleteTask(@PathVariable("id") long id, Model model) {
		Optional<Task> task = taskService.findById(id);
		System.out.println(task.toString());
		taskService.delete(task.get());
	    model.addAttribute(new Task());
	    model.addAttribute("workshops",workshopService.getAll());
	    return "view-workshops";
	}
}
