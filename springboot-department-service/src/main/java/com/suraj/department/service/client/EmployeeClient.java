package com.suraj.department.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.suraj.department.service.model.Employee;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
	
	@GetMapping("/employee/department/{departmentId}")
	public ResponseEntity<List<Employee>> findByDepartment(@PathVariable("departmentId") Long departmentId);

}
