package com.componentes.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.componentes.examen.domain.Workshop;
import com.componentes.examen.service.WorkshopService;
import com.componentes.examen.domain.Task;

@Controller
public class WorkshopController {

	@Autowired
	WorkshopService workshopService;
	
	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/insertar",  method = RequestMethod.GET)
	public String insertarPage(Model model) {
		model.addAttribute(new Workshop());
		return "insertar";
	}	
	
	@RequestMapping(value = "/insertar",  method = RequestMethod.POST)
	public String insertarAction(Workshop ws, BindingResult result, Model model) {
		workshopService.save(ws);
		return "index";
	}
	
	@RequestMapping("/view-workshops")
	public String listar(Model model) {
		model.addAttribute("workshops",workshopService.getAll());
		return "view-workshops";
	}
	
	@RequestMapping(value = "/list/author/{query}", method = RequestMethod.GET)
	public String showWorkshopsByAuthor(@PathVariable("query") String query, Model model) {
		List<Workshop> wkpsContainingAuthor = workshopService.findByAuthorContaining(query);
	    model.addAttribute(new Task());
	    model.addAttribute("workshops", wkpsContainingAuthor);
	    return "view-workshops";
	}
	
	@RequestMapping(value = "/list/keywords/{query}", method = RequestMethod.GET)
	public String showWorkshopsByKeywords(@PathVariable("query") String query, Model model) {
		List<Workshop> wkpsContainingKeyword = workshopService.findByAuthorContaining(query);
	    model.addAttribute(new Task());
	    model.addAttribute("workshops", wkpsContainingKeyword);
	    return "view-workshops";
	}
	
	@RequestMapping(value = "/list/category/{query}", method = RequestMethod.GET)
	public String showWorkshopsByCategory(@PathVariable("query") String query, Model model) {
		List<Workshop> wkpsContainingCategory = workshopService.findByAuthorContaining(query);
	    model.addAttribute(new Task());
	    model.addAttribute("workshops", wkpsContainingCategory);
	    return "view-workshops";
	}
	
	@RequestMapping(value = "/add-task/{id}", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    Workshop ws = workshopService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid workshop Id:" + id));
	    model.addAttribute("entry", ws);
	    model.addAttribute(new Task());
	    return "add-task";
	}
	
	static List<Workshop> merge(List<Workshop> list1, List<Workshop> list2,List<Workshop> list3) {
		try{
	        int[] a = {1,2,3,4,5,6,7};
	        int[] b = {5,6,7,8,9,10};
	        int[] c = new int[a.length+b.length];
	        int[] fin = new int[a.length+b.length];
	        int i = 0;
	        for(int j : fin){
	            fin[i++] = -1;
	        }
	        i = 0;
	        for(int j : a){
	            c[i++] = j;
	        }
	        for(int j : b){
	            c[i++] = j;
	        }
	        boolean check = false;
	        for(int j = 0,k = 0; j < c.length; j++){
	            for(int l : fin){
	                if( l == c[j] )
	                    check = true;
	            }
	            if(!check){
	                fin[k++] = c[j];
	            } else check = false;
	        }

	    } catch(Exception ex){
	        ex.printStackTrace();
	    }
		return null;
	 }
	
}
