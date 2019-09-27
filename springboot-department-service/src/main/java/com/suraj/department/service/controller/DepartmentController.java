package com.suraj.department.service.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.department.service.client.EmployeeClient;
import com.suraj.department.service.model.Department;
import com.suraj.department.service.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@PostMapping(path = "/add")
	public ResponseEntity<Department> addNewDepartment(@RequestBody Department department){
		return ResponseEntity.ok(departmentRepository.save(department));
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Department>> getAllDepartments(){
		return ResponseEntity.ok(departmentRepository.findAll());
	}
	
	@GetMapping(path = "/{departmentID}")
	public ResponseEntity<Department> getDepartment(@PathVariable("departmentId") Long departmentId){
		Optional<Department> optionalDep = departmentRepository.findById(departmentId);
		return ResponseEntity.ok(optionalDep.get());
	}
	
	@GetMapping(path = "/organisation/{organisationID}")
	public ResponseEntity<List<Department>> getDepartmentByOrganisation(@PathVariable("organisationID") Long organisationId){
		List<Department> listByOrganisation = departmentRepository.findAll()
				.stream()
				.filter(dep -> dep.getOrganizationId().equals(organisationId))
				.collect(Collectors.toList());
		return ResponseEntity.ok(listByOrganisation);
	}
	
	@GetMapping(path = "/organisation/{organisationId}/with-employees")
	public ResponseEntity<List<Department>> getDepartmentWithOrganisationAndEmployees(@PathVariable("organisationId") Long organisationId){
		List<Department> list = departmentRepository.findAll()
				.stream()
				.filter(dep -> dep.getOrganizationId().equals(organisationId))
				.collect(Collectors.toList());
		list.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId()).getBody()));
		return ResponseEntity.ok(list);
	}

}
