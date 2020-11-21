package com.componentes.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.componentes.examen.domain.Workshop;
import com.componentes.examen.service.WorkshopService;
import com.componentes.examen.domain.Query;
import com.componentes.examen.domain.Task;

@Controller
public class WorkshopController {

	@Autowired
	WorkshopService workshopService;

	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}

	@RequestMapping(value = "/add-workshop", method = RequestMethod.GET)
	public String insertWorkshopPage(Model model) {
		model.addAttribute(new Workshop());
		return "add-workshop";
	}

	@RequestMapping(value = "/add-workshop", method = RequestMethod.POST)
	public String insertWorkshop(Workshop ws, BindingResult result, Model model) {
		workshopService.save(ws);
		return "index";
	}

	@RequestMapping("/view-workshops")
	public String showWorkshops(Model model) {
		model.addAttribute(new Query());
		model.addAttribute("workshops", workshopService.getAll());
		return "view-workshops";
	}

	@RequestMapping(value = "/search-workshops", method = RequestMethod.POST)
	public String showWorkshopsByCategory(Query query, BindingResult result, Model model) {
		List<Workshop> results;
		switch(query.getType()) {
		case "category":
			results = workshopService.findByCategoryContaining(query.getText());
			break;
		case "keywords":
			results = workshopService.findByKeywordsContaining(query.getText());
			break;
		case "author":
			results = workshopService.findByAuthorContaining(query.getText());
			break;
			default:
				results = workshopService.find(query.getText());
				break;
				
		}
		model.addAttribute(new Task());
		model.addAttribute(new Query());
		model.addAttribute("workshops", results);
		return "search-workshops";
	}

	@RequestMapping(value = "/add-task/{id}", method = RequestMethod.GET)
	public String showAddTaskForm(@PathVariable("id") long id, Model model) {
		Workshop ws = workshopService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid workshop Id:" + id));
		model.addAttribute("entry", ws);
		model.addAttribute(new Task());
		return "add-task";
	}

	@RequestMapping(value = "/edit-workshop/{id}", method = RequestMethod.GET)
	public String showUpdateWorkshopForm(@PathVariable("id") long id, Model model) {
		Optional<Workshop> wkp = workshopService.findById(id);
		model.addAttribute(new Workshop());
		model.addAttribute("wkp", wkp.get());
		return "edit-workshop";
	}

	@RequestMapping(value = "/edit-workshop", method = RequestMethod.POST)
	public String editWorkshop(Workshop workshop, BindingResult result, Model model) {
		workshopService.save(workshop);
		model.addAttribute(new Workshop());
		model.addAttribute(new Query());
		model.addAttribute("workshops", workshopService.getAll());
		return "view-workshops";
	}

	static List<Workshop> merge(List<Workshop> list1, List<Workshop> list2) {
		try {
			int[] a = { 1, 2, 3, 4, 5, 6, 7 };
			int[] b = { 5, 6, 7, 8, 9, 10 };
			int[] c = new int[a.length + b.length];
			int[] fin = new int[a.length + b.length];
			int i = 0;
			for (int j : fin) {
				fin[i++] = -1;
			}
			i = 0;
			for (int j : a) {
				c[i++] = j;
			}
			for (int j : b) {
				c[i++] = j;
			}
			boolean check = false;
			for (int j = 0, k = 0; j < c.length; j++) {
				for (int l : fin) {
					if (l == c[j])
						check = true;
				}
				if (!check) {
					fin[k++] = c[j];
				} else
					check = false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
