package com.componentes.examen.domain;

import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Workshop {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private String name;
	private String author;
	private String objective;
	private String category;
	private String keywords;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="workshopId")
	private Set<Task> tasks;
	
	public Workshop() {
		
	}
	
	public Workshop(long id, String name, String author, String objective, String category, String keywords) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.objective = objective;
		this.category = category;
		this.keywords = keywords;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Workshop [id=" + id + ", name=" + name + ", author=" + author + ", objective=" + objective
				+ ", category=" + category + ", keywords=" + keywords + ", tasks=" + tasks + "]";
	}
	
	
	
}


	

