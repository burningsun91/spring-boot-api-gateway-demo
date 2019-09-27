package com.suraj.organisation.service.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private Long id;
	private String name;
	private List<Employee> employees = new ArrayList<>();
	
	public Department() {
		
	}
	
	public Department(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
