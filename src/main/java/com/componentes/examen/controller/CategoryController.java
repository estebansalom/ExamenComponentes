package com.componentes.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.componentes.examen.domain.Category;
import com.componentes.examen.domain.Query;
import com.componentes.examen.domain.Task;
import com.componentes.examen.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/add-category", method = RequestMethod.POST)
	public String insertCategory(Category category, BindingResult result, Model model) {
		categoryService.save(category);
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute(new Query());
		return "view-workshops";
	}

	@RequestMapping("/view-categories")
	public String listAll(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "view-tasks";
	};

}
