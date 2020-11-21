package com.componentes.examen.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String name;
	private String description;
	private String label;
	private String time;
	@ManyToOne
    @JoinColumn(name="workshop.id", nullable=false)
	private Workshop workshopId;
	
	public Task () {
		
	}
	public Task(long id, String name, String description, String text, String time) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.label = text;
		this.time = time;
	}
	
	public Task(long id, String name, String description, String text, String time, Workshop workshop) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.label = text;
		this.time = time;
		this.workshopId = workshop;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String lable) {
		this.label = label;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public Workshop getWorkshopId() {
		return this.workshopId;
	}
	
	public void setWorkshopId(Workshop workshop) {
		this.workshopId = workshop;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", label=" + label + ", time="
				+ time + ", workshopId=" + workshopId + "]";
	}
	
	
}
