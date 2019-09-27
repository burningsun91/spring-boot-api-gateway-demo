package com.suraj.organisation.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.suraj.organisation.service.model.Employee;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
	
	@GetMapping(path = "/employee/organisation/{organisationId}")
	public ResponseEntity<List<Employee>> findByOrganisation(@PathVariable("organisationId") Long organisationId);

}
