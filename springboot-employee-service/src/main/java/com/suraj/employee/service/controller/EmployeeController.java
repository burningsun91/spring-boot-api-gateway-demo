package com.suraj.employee.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.employee.service.exception.EmployeeNotFoundException;
import com.suraj.employee.service.model.Employee;
import com.suraj.employee.service.repository.EmployeeRepository;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@PostMapping(path = "/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return ResponseEntity.ok(emp);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Long employeeId){
		Boolean status = true;
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
			employeeRepository.deleteById(employeeId);
		}else {
			throw new EmployeeNotFoundException("Employee details to be deleted were not found");
		}
		return ResponseEntity.ok(status);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long employeeId) throws MissingPathVariableException{
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee details not found");
		}
		return ResponseEntity.ok(employee.get());
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(employeeRepository.findAll());
	}
	
	@GetMapping(path = "/department/{departmentId}")
	public ResponseEntity<List<Employee>> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		List<Employee> listByDepartmentId = employeeRepository.findAll().stream().filter(emp -> emp.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
		return ResponseEntity.ok(listByDepartmentId);
	}
	
	@GetMapping(path = "/organization/{organizationId}")
	public ResponseEntity<List<Employee>> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		List<Employee> listByOrganisationId = employeeRepository.findAll().stream().filter(emp -> emp.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
		return ResponseEntity.ok(listByOrganisationId);
	}

}
